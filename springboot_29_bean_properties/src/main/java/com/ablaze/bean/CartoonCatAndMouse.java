package com.ablaze.bean;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.util.StringUtils;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/22:34
 */
//@Component
@Data
@EnableConfigurationProperties(CartoonProperties.class)
public class CartoonCatAndMouse {
    private Cat cat;
    private Mouse mouse;

    private CartoonProperties cartoonProperties;

    public CartoonCatAndMouse(CartoonProperties cartoonProperties) {
        this.cartoonProperties = cartoonProperties;
        this.cat = new Cat();
        cat.setName(cartoonProperties.getCat() != null && StringUtils.hasText(cartoonProperties.getCat().getName()) ? cartoonProperties.getCat().getName() : "tom");
        cat.setAge(cartoonProperties.getCat() != null && cartoonProperties.getCat().getAge() != null ? cartoonProperties.getCat().getAge() : 3);
        this.mouse = new Mouse();
        mouse.setName(cartoonProperties.getMouse() != null && StringUtils.hasText(cartoonProperties.getMouse().getName()) ? cartoonProperties.getMouse().getName() : "jerry");
        mouse.setAge(cartoonProperties.getMouse() != null && cartoonProperties.getMouse().getAge() != null ? cartoonProperties.getMouse().getAge() : 4);

    }

    public void play() {
        System.out.println(cat.getAge() + "岁的" + cat.getName() + "和" + mouse.getAge() + "岁的" + mouse.getName() + "打起来了");
    }
}
