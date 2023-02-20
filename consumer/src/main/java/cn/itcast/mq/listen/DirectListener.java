package cn.itcast.mq.listen;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class DirectListener {

    @RabbitListener(
            // 绑定关系
            bindings = @QueueBinding(
                    // 声明队列
                    value = @Queue("direct.queue1"),
                    // 交换机, 【注意】要指定交换机的类型
                    exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
                    // key=bindingKey
                    key = {"blue", "red"}
            ))
    public void consumeQueue1(String msg){
        System.out.println("消费者1接收到Direct消息：【" + msg + "】");
    }

    @RabbitListener(
            // 绑定关系
            bindings = @QueueBinding(
                    // 声明队列
                    value = @Queue("direct.queue2"),
                    // 交换机, 【注意】要指定交换机的类型
                    exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
                    // key=bindingKey
                    key = {"yellow", "red"}
            ))
    public void consumeQueue2(String msg){
        System.err.println("消费者2接收到Direct消息：【" + msg + "】");
    }
}
