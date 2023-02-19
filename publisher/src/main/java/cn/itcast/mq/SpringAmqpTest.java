package cn.itcast.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;


/**
 * @version 1.0
 * @description 说明
 * @package cn.itcast.mq.helloworld
 */
@SpringBootTest
public class SpringAmqpTest {
    // Autowired 优先使用类型来注入，如果这个类型有多个bean对象实现，则按属性名注入，如果属性名的beanName没找到则报错
    // Resource 优先使用属性名 从容器找 这个name为属性名的bean对象，如果没找到则用类型来注入
    // Resource = Autowired + @Qualifier(指定的bean名称来注入)
    @Resource
    private RabbitTemplate rabbitTemplate;


    // junit 4的版本(包比较短)时需要配置@RunWith注解, 版本>5(包名比较长)则不需要
    @Test
    public void testSendNormalMsg(){
        rabbitTemplate.convertAndSend("simple.queue", "Hello amqp");
    }

}
