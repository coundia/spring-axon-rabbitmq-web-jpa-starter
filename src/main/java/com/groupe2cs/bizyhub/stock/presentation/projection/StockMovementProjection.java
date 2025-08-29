package com.groupe2cs.bizyhub.stock.presentation.projection;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.stock.domain.event.StockMovementCreatedEvent;
import com.groupe2cs.bizyhub.stock.domain.event.StockMovementDeletedEvent;
import com.groupe2cs.bizyhub.stock.domain.event.StockMovementUpdatedEvent;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockMovement;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockMovementRepository;
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
@ProcessingGroup("StockMovement")
public class StockMovementProjection {

	private final StockMovementRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(StockMovementCreatedEvent event) {
		try {
			StockMovement entity = StockMovement.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getTypeStockMovement() != null && hasId(event.getTypeStockMovement().value())) {
				entity.setTypeStockMovement(event.getTypeStockMovement().value());
			}
			if (event.getQuantity() != null && hasId(event.getQuantity().value())) {
				entity.setQuantity(event.getQuantity().value());
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
			if (event.getCompany() != null && hasId(event.getCompany().value())) {
				entity.setCompany(event.getCompany().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getProductVariant() != null && hasId(event.getProductVariant().value())) {
				entity.setProductVariant(event.getProductVariant().value());
			}
			if (event.getOrderLineId() != null && hasId(event.getOrderLineId().value())) {
				entity.setOrderLineId(event.getOrderLineId().value());
			}
			if (event.getDiscriminator() != null && hasId(event.getDiscriminator().value())) {
				entity.setDiscriminator(event.getDiscriminator().value());
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


			repository.save(entity);


			log.info("StockMovement inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving StockMovement: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(StockMovementUpdatedEvent event) {
		try {
			StockMovement entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("StockMovement not found"));


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getTypeStockMovement() != null && hasId(event.getTypeStockMovement().value())) {
				entity.setTypeStockMovement(event.getTypeStockMovement().value());
			}
			if (event.getQuantity() != null && hasId(event.getQuantity().value())) {
				entity.setQuantity(event.getQuantity().value());
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
			if (event.getCompany() != null && hasId(event.getCompany().value())) {
				entity.setCompany(event.getCompany().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getProductVariant() != null && hasId(event.getProductVariant().value())) {
				entity.setProductVariant(event.getProductVariant().value());
			}
			if (event.getOrderLineId() != null && hasId(event.getOrderLineId().value())) {
				entity.setOrderLineId(event.getOrderLineId().value());
			}
			if (event.getDiscriminator() != null && hasId(event.getDiscriminator().value())) {
				entity.setDiscriminator(event.getDiscriminator().value());
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


			log.info("StockMovement updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating StockMovement: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(StockMovementDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("StockMovement deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting StockMovement: {}", e.getMessage(), e);
			throw e;
		}
	}
}
