package com.groupe2cs.bizyhub.stock.presentation.projection;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.stock.domain.event.StockLevelCreatedEvent;
import com.groupe2cs.bizyhub.stock.domain.event.StockLevelDeletedEvent;
import com.groupe2cs.bizyhub.stock.domain.event.StockLevelUpdatedEvent;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockLevel;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockLevelRepository;
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
@ProcessingGroup("StockLevel")
public class StockLevelProjection {

	private final StockLevelRepository repository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(StockLevelCreatedEvent event) {
		try {
			StockLevel entity = StockLevel.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getStockOnHand() != null && hasId(event.getStockOnHand().value())) {
				entity.setStockOnHand(event.getStockOnHand().value());
			}
			if (event.getStockAllocated() != null && hasId(event.getStockAllocated().value())) {
				entity.setStockAllocated(event.getStockAllocated().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getProductVariant() != null && hasId(event.getProductVariant().value())) {
				entity.setProductVariant(event.getProductVariant().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getCompany() != null && hasId(event.getCompany().value())) {
				entity.setCompany(event.getCompany().value());
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


			repository.save(entity);


			log.info("StockLevel inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving StockLevel: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(StockLevelUpdatedEvent event) {
		try {
			StockLevel entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("StockLevel not found"));


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getStockOnHand() != null && hasId(event.getStockOnHand().value())) {
				entity.setStockOnHand(event.getStockOnHand().value());
			}
			if (event.getStockAllocated() != null && hasId(event.getStockAllocated().value())) {
				entity.setStockAllocated(event.getStockAllocated().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getProductVariant() != null && hasId(event.getProductVariant().value())) {
				entity.setProductVariant(event.getProductVariant().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getCompany() != null && hasId(event.getCompany().value())) {
				entity.setCompany(event.getCompany().value());
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


			log.info("StockLevel updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating StockLevel: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(StockLevelDeletedEvent event) {
		try {


			repository.deleteById(event.getId().value());
			log.info("StockLevel deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting StockLevel: {}", e.getMessage(), e);
			throw e;
		}
	}
}
