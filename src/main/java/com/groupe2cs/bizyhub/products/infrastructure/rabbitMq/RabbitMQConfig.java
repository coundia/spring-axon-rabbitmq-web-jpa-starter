package com.groupe2cs.bizyhub.products.infrastructure.rabbitMq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("axon-exchange");
    }

    @Bean
    public DirectExchange exchange2() {
        return new DirectExchange("bizyhub-exchange");
    }


    @Bean
    public Queue queue() {
        return new Queue("axon-queue");
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("axon.routing.key");
    }
}
