package cn.itcast.mq.listen;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Component;

//@Component
public class FanoutListener {

    @RabbitListener(queues = "fanout.queue1")
    public void consumeQueue1(String msg){
        System.out.println("消费者1接收到Fanout消息：【" + msg + "】");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void consumeQueue2(String msg){
        System.out.println("消费者2接收到Fanout消息：【" + msg + "】");
    }
}
