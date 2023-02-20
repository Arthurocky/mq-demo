package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    //声明交换机
    @Bean // 注册的bean对象名称为方法名
    public FanoutExchange fanoutExchange()
    {
        return new FanoutExchange("itcast.fanout");
    }

    //声明队列Queue1
    @Bean
    public Queue fanoutQueue1()
    {
        return new Queue("fanout.queue1");
    }

    //声明队列Queue2
    @Bean
    public Queue fanoutQueue2()
    {
        return new Queue("fanout.queue2");
    }

    //绑定关系 把队列绑定到交换机
    @Bean
    public Binding fanoutBinding1(@Autowired FanoutExchange fanoutExchange, @Autowired Queue fanoutQueue1)
    {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutBinding2(@Autowired FanoutExchange fanoutExchange, @Autowired Queue fanoutQueue2)
    {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

}