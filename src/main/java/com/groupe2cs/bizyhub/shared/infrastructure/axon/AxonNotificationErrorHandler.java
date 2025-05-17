package com.groupe2cs.bizyhub.shared.infrastructure.axon;

import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.EventMessageHandler;
import org.axonframework.eventhandling.ListenerInvocationErrorHandler;
import org.springframework.stereotype.Component;

@Component
public class AxonNotificationErrorHandler implements ListenerInvocationErrorHandler {

	@Override
	public void onError(Exception exception,
						EventMessage<?> event,
						EventMessageHandler eventHandler) throws Exception {

		String evtType = event.getPayloadType().getSimpleName();
		System.out.println("Fail - " + evtType + ": " + exception.getMessage());
	}
}
