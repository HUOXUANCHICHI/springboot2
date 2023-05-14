package com.ablaze.service.impl;

import com.ablaze.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Author: ablaze
 * @Date: 2023/05/14/17:36
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    //发送人
    private String from = "3045723913@qq.com";
    //接收人
    private String to = "15084078791@163.com";
    //标题
    private String subject = "测试邮件";
    //正文
    private String context = "<img src='https://ts1.cn.mm.bing.net/th/id/R-C.30b685e211d09036c0a0a60427469748?rik=V3kNzi9WuWUJVA&riu=http%3a%2f%2f5b0988e595225.cdn.sohucs.com%2fimages%2f20190916%2f1f2286619ee14290b29c14ab13077835.jpeg&ehk=0RwXvdox0Avpfwxm%2fN2C%2b6FBOtKN4EnrYfficy3TxUc%3d&risl=&pid=ImgRaw&r=0'/><a href='https://www.itcast.cn'>点开有惊喜</a>";

    @Override
    public void sendMail() {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from + "(小甜甜)");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context, true);

            //添加附件

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
