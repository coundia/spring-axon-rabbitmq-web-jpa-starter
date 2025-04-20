package com.groupe2cs.bizyhub.shared.infrastructure.axon;


import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.LoggingErrorHandler;
import org.axonframework.eventhandling.ErrorHandler;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AxonConfig {

		public AxonConfig(EventProcessingConfigurer configurer) {
		configurer
		.registerDefaultListenerInvocationErrorHandler(cc -> new LoggingErrorHandler())
		.registerDefaultErrorHandler(conf -> new ErrorHandler() {
		@Override
		public void handleError(org.axonframework.eventhandling.ErrorContext errorContext) {
		log.error(
		"Skipping failed event  {}",
		errorContext.error().getMessage()
		);
		}
		});
		}
}
