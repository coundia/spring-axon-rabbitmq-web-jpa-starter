package com.groupe2cs.bizyhub.shared.infrastructure.axon;


import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.EventMessageHandler;
import org.axonframework.eventhandling.ListenerInvocationErrorHandler;

public class RetryTwoTimesHandler implements ListenerInvocationErrorHandler {

	private EventMessage<?> lastEvent = null;
	private int retryCount = 0;

	@Override
	public void onError(Exception exception, EventMessage<?> event, EventMessageHandler eventHandler) throws Exception {
		if (!event.equals(lastEvent)) {
			lastEvent = event;
			retryCount = 0;
		}

		if (retryCount++ < 2) {
			throw exception;
		}
	}
}
