package com.groupe2cs.bizyhub.chats.presentation.projection;

	import com.groupe2cs.bizyhub.chats.domain.event.*;
	import com.groupe2cs.bizyhub.chats.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.chats.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
	import org.axonframework.eventhandling.EventHandler;

import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.config.ProcessingGroup;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@AllowReplay(value = false)
@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
@ProcessingGroup("Chat")
public class ChatProjection {

private final ChatRepository repository;


@EventHandler
public void on(ChatCreatedEvent event) {
try {
Chat entity = Chat.builder()
		.id(event.getId() == null ? null : event.getId().value())
 		.messages(event.getMessages() == null ? null : event.getMessages().value())
 		.responsesJson(event.getResponsesJson() == null ? null : event.getResponsesJson().value())
 		.responses(event.getResponses() == null ? null : event.getResponses().value())
 		.state(event.getState() == null ? null : event.getState().value())
  		.account( event.getAccount() == null ? null : new com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account(event.getAccount().value()))
.build();

entity.setId(event.getId().value());

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}
	if(event.getTenant() != null) {
	entity.setTenant(new Tenant(event.getTenant().value()));
	}


repository.save(entity);


log.info("Chat inserted: {}", entity);

} catch (Exception e) {
log.error("Error saving Chat: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(ChatUpdatedEvent event) {
try {
Chat entity = repository.findById(event.getId().value())
.orElseThrow(() -> new RuntimeException("Chat not found"));


	if(event.getId() != null) {
		entity.setId(event.getId().value());
    }
	if(event.getMessages() != null) {
		entity.setMessages(event.getMessages().value());
    }
	if(event.getResponsesJson() != null) {
		entity.setResponsesJson(event.getResponsesJson().value());
    }
	if(event.getResponses() != null) {
		entity.setResponses(event.getResponses().value());
    }
	if(event.getState() != null) {
		entity.setState(event.getState().value());
    }

     if(event.getAccount() != null) {
		  entity.setAccount(new com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account(event.getAccount().value()));
	  }

if(event.getCreatedBy() !=null){
	entity.setCreatedBy( new User(event.getCreatedBy().value()));
}

if(entity.getTenant() == null && event.getTenant() != null) {
	log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}", event.getTenant().value());
	entity.setTenant(new Tenant(event.getTenant().value()));
}

repository.save(entity);


log.info("Chat updated successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error updating Chat: {}", e.getMessage(), e);
throw e;
}
}

@EventHandler
public void on(ChatDeletedEvent event) {
try {


repository.deleteById(event.getId().value());
log.info("Chat deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Chat: {}", e.getMessage(), e);
throw e;
}
}
}
