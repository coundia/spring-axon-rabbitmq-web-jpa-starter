package com.groupe2cs.bizyhub.order.presentation.projection;

import com.groupe2cs.bizyhub.order.domain.event.OrderCreatedEvent;
import com.groupe2cs.bizyhub.order.domain.event.OrderDeletedEvent;
import com.groupe2cs.bizyhub.order.domain.event.OrderUpdatedEvent;
import com.groupe2cs.bizyhub.order.infrastructure.entity.Order;
import com.groupe2cs.bizyhub.order.infrastructure.repository.OrderRepository;
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
@ProcessingGroup("Order")
public class OrderProjection {

	private final OrderRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(OrderCreatedEvent event) {
		try {
			Order entity = Order.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getProductId() != null && hasId(event.getProductId().value())) {
				entity.setProductId(event.getProductId().value());
			}
			if (event.getUserId() != null && hasId(event.getUserId().value())) {
				entity.setUserId(event.getUserId().value());
			}
			if (event.getIdentifiant() != null && hasId(event.getIdentifiant().value())) {
				entity.setIdentifiant(event.getIdentifiant().value());
			}
			if (event.getTelephone() != null && hasId(event.getTelephone().value())) {
				entity.setTelephone(event.getTelephone().value());
			}
			if (event.getMail() != null && hasId(event.getMail().value())) {
				entity.setMail(event.getMail().value());
			}
			if (event.getVille() != null && hasId(event.getVille().value())) {
				entity.setVille(event.getVille().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getBuyerName() != null && hasId(event.getBuyerName().value())) {
				entity.setBuyerName(event.getBuyerName().value());
			}
			if (event.getAddress() != null && hasId(event.getAddress().value())) {
				entity.setAddress(event.getAddress().value());
			}
			if (event.getNotes() != null && hasId(event.getNotes().value())) {
				entity.setNotes(event.getNotes().value());
			}
			if (event.getMessage() != null && hasId(event.getMessage().value())) {
				entity.setMessage(event.getMessage().value());
			}
			if (event.getTypeOrder() != null && hasId(event.getTypeOrder().value())) {
				entity.setTypeOrder(event.getTypeOrder().value());
			}
			if (event.getPaymentMethod() != null && hasId(event.getPaymentMethod().value())) {
				entity.setPaymentMethod(event.getPaymentMethod().value());
			}
			if (event.getDeliveryMethod() != null && hasId(event.getDeliveryMethod().value())) {
				entity.setDeliveryMethod(event.getDeliveryMethod().value());
			}
			if (event.getAmountCents() != null && hasId(event.getAmountCents().value())) {
				entity.setAmountCents(event.getAmountCents().value());
			}
			if (event.getQuantity() != null && hasId(event.getQuantity().value())) {
				entity.setQuantity(event.getQuantity().value());
			}
			if (event.getDateCommand() != null && hasId(event.getDateCommand().value())) {
				entity.setDateCommand(event.getDateCommand().value());
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}

/*
	if(event.getRemoteId().value() == null) {
		entity.setRemoteId(event.getId().value());
	}
	*/

			repository.save(entity);


			log.info("Order inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving Order: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(OrderUpdatedEvent event) {
		try {
			Order entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("Order not found"));


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getProductId() != null && hasId(event.getProductId().value())) {
				entity.setProductId(event.getProductId().value());
			}
			if (event.getUserId() != null && hasId(event.getUserId().value())) {
				entity.setUserId(event.getUserId().value());
			}
			if (event.getIdentifiant() != null && hasId(event.getIdentifiant().value())) {
				entity.setIdentifiant(event.getIdentifiant().value());
			}
			if (event.getTelephone() != null && hasId(event.getTelephone().value())) {
				entity.setTelephone(event.getTelephone().value());
			}
			if (event.getMail() != null && hasId(event.getMail().value())) {
				entity.setMail(event.getMail().value());
			}
			if (event.getVille() != null && hasId(event.getVille().value())) {
				entity.setVille(event.getVille().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getBuyerName() != null && hasId(event.getBuyerName().value())) {
				entity.setBuyerName(event.getBuyerName().value());
			}
			if (event.getAddress() != null && hasId(event.getAddress().value())) {
				entity.setAddress(event.getAddress().value());
			}
			if (event.getNotes() != null && hasId(event.getNotes().value())) {
				entity.setNotes(event.getNotes().value());
			}
			if (event.getMessage() != null && hasId(event.getMessage().value())) {
				entity.setMessage(event.getMessage().value());
			}
			if (event.getTypeOrder() != null && hasId(event.getTypeOrder().value())) {
				entity.setTypeOrder(event.getTypeOrder().value());
			}
			if (event.getPaymentMethod() != null && hasId(event.getPaymentMethod().value())) {
				entity.setPaymentMethod(event.getPaymentMethod().value());
			}
			if (event.getDeliveryMethod() != null && hasId(event.getDeliveryMethod().value())) {
				entity.setDeliveryMethod(event.getDeliveryMethod().value());
			}
			if (event.getAmountCents() != null && hasId(event.getAmountCents().value())) {
				entity.setAmountCents(event.getAmountCents().value());
			}
			if (event.getQuantity() != null && hasId(event.getQuantity().value())) {
				entity.setQuantity(event.getQuantity().value());
			}
			if (event.getDateCommand() != null && hasId(event.getDateCommand().value())) {
				entity.setDateCommand(event.getDateCommand().value());
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


			log.info("Order updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating Order: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(OrderDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("Order deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting Order: {}", e.getMessage(), e);
			throw e;
		}
	}
}
