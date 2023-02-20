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
    //Work queues，也被称为（Task queues），任务模型。简单来说就是**让多个消费者绑定到一个队列，共同消费队列中的消息**。
    @Test
    public void testSendNormalMsg(){
        rabbitTemplate.convertAndSend("simple.queue", "Hello amqp");
    }

    //要模拟多个消费者绑定同一个队列，我们在consumertestWorkQueue服务的SpringRabbitListener中添加2个新的方法：
    //平均分配：奇数为消费者1处理，则偶数为消费者2处理
    @Test
    public void testSendWorkMsg(){
        for (int i = 0; i < 50; i++) {
            //Ctrl+Shift + 上下
            rabbitTemplate.convertAndSend("simple.queue", "第" + (i+1) + "个消息");
        }
    }

}
