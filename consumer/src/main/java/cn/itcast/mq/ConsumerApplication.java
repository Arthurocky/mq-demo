package cn.itcast.mq;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args)
    {
        //Spring的上下文 称IOC, 容器 对象。对象共享池
        ConfigurableApplicationContext app = SpringApplication.run(ConsumerApplication.class, args);
        System.out.println(app.getBean("consumerApplication"));
        //  cn.itcast.mq.ConsumerApplication$$EnhancerBySpringCGLIB$$1686d0b9@46074492
    }


    /**
     * 消息转换器
     * @return
     */
    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
