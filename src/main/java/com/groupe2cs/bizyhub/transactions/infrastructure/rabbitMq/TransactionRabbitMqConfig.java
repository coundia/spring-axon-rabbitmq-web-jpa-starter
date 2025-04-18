package com.groupe2cs.bizyhub.transactions.infrastructure.rabbitMq;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionRabbitMqConfig {

    @Bean
    public TopicExchange transactionExchange() {
        return new TopicExchange("transaction.exchange", true, false);
    }

    @Bean
    public Queue transactionCreatedQueue() {
        return QueueBuilder.durable("transaction.created.queue").build();
    }

    @Bean
    public Queue transactionUpdatedQueue() {
        return QueueBuilder.durable("transaction.updated.queue").build();
    }

    @Bean
    public Queue transactionDeletedQueue() {
        return QueueBuilder.durable("transaction.deleted.queue").build();
    }

    @Bean
    public Binding transactionCreatedBinding() {
        return BindingBuilder.bind(transactionCreatedQueue())
                .to(transactionExchange())
                .with("transaction.created");
    }

    @Bean
    public Binding transactionUpdatedBinding() {
        return BindingBuilder.bind(transactionUpdatedQueue())
                .to(transactionExchange())
                .with("transaction.updated");
    }

    @Bean
    public Binding transactionDeletedBinding() {
        return BindingBuilder.bind(transactionDeletedQueue())
                .to(transactionExchange())
                .with("transaction.deleted");
    }
}
