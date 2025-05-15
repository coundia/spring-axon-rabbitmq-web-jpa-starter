package com.groupe2cs.bizyhub.chats.presentation.projection;

import com.groupe2cs.bizyhub.chats.domain.event.ChatCreatedEvent;
import com.groupe2cs.bizyhub.chats.domain.event.ChatDeletedEvent;
import com.groupe2cs.bizyhub.chats.domain.event.ChatUpdatedEvent;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.Chat;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.ChatRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
					.account(event.getAccount() == null ?
							null :
							new com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account(event.getAccount()
									.value()))
					.updatedAt(event.getUpdatedAt() == null ? null : event.getUpdatedAt().value())
					.reference(event.getReference() == null ? null : event.getReference().value())
					.build();

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
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


			entity.setId(event.getId().value());
			entity.setMessages(event.getMessages().value());
			if(event.getResponsesJson() != null) {
				entity.setResponsesJson(event.getResponsesJson().value());
			}
			entity.setResponses(event.getResponses().value());
			entity.setState(event.getState().value());
			entity.setAccount(new com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account(event.getAccount()
					.value()));
			entity.setUpdatedAt(event.getUpdatedAt().value());
			entity.setReference(event.getReference().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}

			if (entity.getTenant() == null && event.getTenant() != null) {
				log.info("Tenant is null on entity, it will be,  updated with tenant ID: {}",
						event.getTenant().value());
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
