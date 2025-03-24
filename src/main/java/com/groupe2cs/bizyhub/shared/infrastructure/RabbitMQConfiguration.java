package com.groupe2cs.bizyhub.shared.infrastructure;


import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
/*
    @Autowired
    private Environment env;

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory cf =
            new CachingConnectionFactory(env.getProperty("spring.rabbitmq.host"));
        cf.setUsername(Objects.requireNonNull(env.getProperty("spring.rabbitmq.username")));
        cf.setPassword(Objects.requireNonNull(env.getProperty("spring.rabbitmq.password")));
        cf.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.rabbitmq.port"))));
        return cf;
    }

    @Bean
    Queue defaultStream() {
        return new Queue(Objects.requireNonNull(env.getProperty("spring.application.queue")), true);
    }

    @Bean
    FanoutExchange eventBusExchange() {
        return new FanoutExchange(env.getProperty("spring.application.exchange"), true, false);
    }

    @Bean
    Binding binding() {
        return new Binding(env.getProperty("spring.application.queue"), Binding.DestinationType.QUEUE,
            env.getProperty("spring.application.exchange"), "*.*", null);
    }

    @Bean
    RabbitAdmin rabbitAdmin() {
        RabbitAdmin admin = new RabbitAdmin(connectionFactory());
        admin.setAutoStartup(true);
        admin.declareExchange(eventBusExchange());
        admin.declareQueue(defaultStream());
        admin.declareBinding(binding());
        return admin;
    }

    @Bean
    RabbitTransactionManager transactionManager() {
        return new RabbitTransactionManager(connectionFactory());
    }
    */
}
