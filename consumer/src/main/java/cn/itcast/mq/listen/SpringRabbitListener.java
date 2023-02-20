package cn.itcast.mq.listen;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class SpringRabbitListener {
    // queues中的队列名必须与控制台的队列名一致，严格区分大小写
    @RabbitListener(queues = "simple.queue")
    public void consumeMsg(String msg)
    {
        System.out.println("spring 消费者接收到消息 ：【" + msg + "】");
    }
}

