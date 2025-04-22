package com.groupe2cs.bizyhub.shared.infrastructure.axon;


import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.ErrorContext;
import org.axonframework.eventhandling.ErrorHandler;
import org.axonframework.eventhandling.LoggingErrorHandler;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AxonConfig {

	public AxonConfig(EventProcessingConfigurer configurer) {
		// Handle any exceptions in @EventHandler methods by logging without retry
		configurer.registerDefaultListenerInvocationErrorHandler(
				componentName -> new LoggingErrorHandler()
		);

		// Catch any errors in the processing pipelines (tracking, subscribing, replay)
		// and log them as skipped events to prevent infinite retries
		configurer.registerDefaultErrorHandler(
				configuration -> new ErrorHandler() {
					@Override
					public void handleError(ErrorContext errorContext) {
						log.error("Skipping failed event [{}]: {}",
								errorContext.toString(),
								errorContext.error().getMessage()
						);
					}
				}
		);

	}
}