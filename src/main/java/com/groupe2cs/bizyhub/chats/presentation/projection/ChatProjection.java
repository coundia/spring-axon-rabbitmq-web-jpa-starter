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


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(ChatCreatedEvent event) {
		try {
			Chat entity = Chat.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getMessages() != null && hasId(event.getMessages().value())) {
				entity.setMessages(event.getMessages().value());
			}
			if (event.getResponsesJson() != null && hasId(event.getResponsesJson().value())) {
				entity.setResponsesJson(event.getResponsesJson().value());
			}
			if (event.getResponses() != null && hasId(event.getResponses().value())) {
				entity.setResponses(event.getResponses().value());
			}
			if (event.getState() != null && hasId(event.getState().value())) {
				entity.setState(event.getState().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getDateTransaction() != null && hasId(event.getDateTransaction().value())) {
				entity.setDateTransaction(event.getDateTransaction().value());
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

			 entity.setRemoteId(event.getId().value());

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


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getMessages() != null && hasId(event.getMessages().value())) {
				entity.setMessages(event.getMessages().value());
			}
			if (event.getResponsesJson() != null && hasId(event.getResponsesJson().value())) {
				entity.setResponsesJson(event.getResponsesJson().value());
			}
			if (event.getResponses() != null && hasId(event.getResponses().value())) {
				entity.setResponses(event.getResponses().value());
			}
			if (event.getState() != null && hasId(event.getState().value())) {
				entity.setState(event.getState().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getDateTransaction() != null && hasId(event.getDateTransaction().value())) {
				entity.setDateTransaction(event.getDateTransaction().value());
			}

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
