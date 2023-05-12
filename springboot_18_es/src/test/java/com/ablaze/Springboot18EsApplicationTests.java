package com.ablaze;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.mapping.IntegerNumberProperty;
import co.elastic.clients.elasticsearch._types.mapping.Property;
import co.elastic.clients.elasticsearch._types.mapping.TextProperty;
import co.elastic.clients.elasticsearch.cat.IndicesResponse;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.elasticsearch.core.search.TotalHitsRelation;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import co.elastic.clients.elasticsearch.indices.IndexState;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import com.ablaze.dao.BookDao;
import com.ablaze.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class Springboot18EsApplicationTests {

    @Autowired
    private BookDao bookDao;

//    @Autowired
//    private ElasticsearchRestTemplate template;

    @Autowired
    private ElasticsearchClient client;

    /**
     * 创建索引
     *
     * @throws IOException
     */
    @Test
    void testCreateIndex() throws IOException {
        //写法比RestHighLevelClient更加简洁
        CreateIndexResponse indexResponse = client.indices().create(c -> c.index("books"));
    }

    /**
     * 查看索引
     *
     * @throws IOException
     */
    @Test
    void getIndex() throws IOException {
        // 查看指定索引
        GetIndexResponse getIndexResponse = client.indices().get(i -> i.index("books"));
        Map<String, IndexState> result = getIndexResponse.result();
        result.forEach((k, v) -> log.info("key = {},value = {}", k, v));

        // 查看全部索引
        IndicesResponse indicesResponse = client.cat().indices();
        // 返回对象具体查看 co.elastic.clients.elasticsearch.cat.indices.IndicesRecord
        indicesResponse.valueBody().forEach(
                info -> log.info("health:{}\n status:{} \n uuid:{} \n ", info.health(), info.status(), info.uuid())
        );

    }

    /**
     * 删除索引
     *
     * @throws IOException
     */
    @Test
    void deleteIndex() throws IOException {
        DeleteIndexResponse deleteIndexResponse = client.indices().delete(s -> s.index("books"));
        log.info("删除索引操作结果：{}", deleteIndexResponse.acknowledged());
    }

    /**
     * 添加文档
     *
     * @throws IOException
     */
    @Test
    void testCreateDoc() throws IOException {
        Map<String, Property> documentMap = new HashMap<>();
        documentMap.put("userName", Property.of(property ->
                        property.text(TextProperty.of(textProperty ->
                                textProperty.index(true).analyzer("ik_max_word"))
                        )
                )
        );
        documentMap.put("age", Property.of(property ->
                        property.integer(IntegerNumberProperty.of(integerNumberProperty
                                -> integerNumberProperty.index(true))
                        )
                )
        );


        CreateIndexResponse createIndexResponse = client.indices().create(createIndexBuilder ->
                createIndexBuilder.index("books").mappings(mappings ->
                                mappings.properties(documentMap))
                        .aliases("Books", aliases ->
                                aliases.isWriteIndex(true))
        );
        boolean acknowledged = createIndexResponse.acknowledged();
        System.out.println("acknowledged = " + acknowledged);

    }

    /**
     * 增添文档
     *
     * @throws IOException
     */
    @Test
    void addOneDocument() throws IOException {
        // 方法1、using the fluent DSL
        Book book = bookDao.selectById(1);
        IndexResponse indexResponse = client.index(s ->
                // 索引
                s.index("books")
                        // ID
                        .id(String.valueOf(book.getId()))
                        // 文档
                        .document(book)
        );
        log.info("result:{}", indexResponse.result().jsonValue());


        // 方法2、You can also assign objects created with the DSL to variables. Java API Client classes have a static of() method for this, that creates an object with the DSL syntax.
        Book book2 = bookDao.selectById(2);
        IndexRequest<Book> request = IndexRequest.of(i -> i
                .index("books")
                .id(String.valueOf(book2.getId()))
                .document(book2));
        IndexResponse response = client.index(request);
        log.info("Indexed with version " + response.version());


        // 方法3、Using classic builders
        Book book3 = bookDao.selectById(3);
        IndexRequest.Builder<Book> indexReqBuilder = new IndexRequest.Builder<>();
        indexReqBuilder.index("books");
        indexReqBuilder.id(String.valueOf(book3.getId()));
        indexReqBuilder.document(book3);
        IndexResponse responseTwo = client.index(indexReqBuilder.build());
        log.info("Indexed with version " + responseTwo.version());
    }

    /**
     * 批量新增
     *
     * @throws IOException
     */
    @Test
    void batchAddDocument() throws IOException {
        // 方法1、use BulkOperation
        List<Book> bookList = bookDao.selectList(null);

        List<BulkOperation> bulkOperations = new ArrayList<>();
        bookList.forEach(u ->
                bulkOperations.add(BulkOperation.of(b ->
                        b.index(c -> c.id(String.valueOf(u.getId())).document(u))))
        );
        BulkResponse bulkResponse = client.bulk(s -> s.index("books").operations(bulkOperations));
        bulkResponse.items().forEach(i ->
                log.info("i = {}", i.result()));
        log.error("bulkResponse.errors() = {}", bulkResponse.errors());

        // 方法2、use BulkRequest
        /*BulkRequest.Builder br = new BulkRequest.Builder();
        for (Book book : bookList) {
            br.operations(op -> op
                    .index(idx -> idx
                            .index("books")
                            .id(String.valueOf(book.getId()))
                            .document(book)));
        }
        BulkResponse result = client.bulk(br.build());
        // Log errors, if any
        if (result.errors()) {
            log.error("Bulk had errors");
            for (BulkResponseItem item : result.items()) {
                if (item.error() != null) {
                    log.error(item.error().reason());
                }
            }
        }*/
    }

    /**
     * 查询文档
     *
     * @throws IOException
     */
    @Test
    void getDocument() throws IOException {
        // co.elastic.clients.elasticsearch.core.get.GetResult<TDocument>
        GetResponse<Book> getResponse = client.get(s -> s.index("books").id("1"), Book.class);
        log.info("getResponse:{}", getResponse.source());

        // Reading a domain object
        if (getResponse.found()) {
            Book book = getResponse.source();
            assert book != null;
            log.info("book name={}", book.getName());
        }

        // Reading raw JSON
        // if (getResponse.found())
        // {
        //    ObjectNode json = getResponse.source();
        //    String name = json.get("name").asText();
        //    log.info("Product name " + name);
        // }

        // 判断文档是否存在
        BooleanResponse booleanResponse = client.exists(s -> s.index("books").id("1"));
        log.info("判断Document是否存在:{}", booleanResponse.value());
    }

    /**
     * 按条件查询
     * @throws IOException
     */
    @Test
    void searchOne() throws IOException {
        String searchText = "Java";
        SearchResponse<Book> response = client.search(s -> s
                        // 我们要搜索的索引的名称
                        .index("books")
                        // 搜索请求的查询部分（搜索请求也可以有其他组件，如聚合）
                        .query(q -> q
                                // 在众多可用的查询变体中选择一个。我们在这里选择匹配查询（全文搜索）
                                .match(t -> t
                                        // name配置匹配查询：我们在字段中搜索一个词
                                        .field("name")
                                        .query(searchText)
                                )
                        ),
                // 匹配文档的目标类
                Book.class
        );
        TotalHits total = response.hits().total();
        boolean isExactResult = total.relation() == TotalHitsRelation.Eq;

        if (isExactResult) {
            log.info("There are " + total.value() + " results");
        } else {
            log.info("There are more than " + total.value() + " results");
        }

        List<Hit<Book>> hits = response.hits().hits();
        for (Hit<Book> hit : hits) {
            Book book = hit.source();
            assert book != null;
            log.info("Found userId " + book.getId() + ", name " + book.getName());
        }
    }

}

