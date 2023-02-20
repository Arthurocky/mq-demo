package cn.itcast.mq.listen;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class WorkQueueListener {

    @RabbitListener(queues = "simple.queue")
    public void consumeMsg1(String msg) throws InterruptedException {
        System.out.println("消费者1 接收到消息 ：【" + msg + "】");
        Thread.sleep(20);
    }


    @RabbitListener(queues = "simple.queue")
    public void consumeMsg2(String msg) throws InterruptedException {
        System.err.println("消费者2 接收到消息 ：【" + msg + "】");
        Thread.sleep(100);
    }

}
