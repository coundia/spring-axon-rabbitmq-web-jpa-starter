package com.groupe2cs.bizyhub.shared.infrastructure.axon;

import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AxonConfig {

    @Bean
    @Primary
    public Serializer serializer() {
        return JacksonSerializer.defaultSerializer();
    }

    @Bean
    @Qualifier("messageSerializer")
    public Serializer messageSerializer(@Qualifier("serializer") Serializer s) {
        return s;
    }

    @Bean
    @Qualifier("eventSerializer")
    public Serializer eventSerializer(@Qualifier("serializer") Serializer s) {
        return s;
    }
}
