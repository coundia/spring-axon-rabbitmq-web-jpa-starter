package com.groupe2cs.bizyhub.products.presentation.projection;

import com.groupe2cs.bizyhub.products.domain.event.ProductCreatedEvent;
import com.groupe2cs.bizyhub.products.domain.event.ProductDeletedEvent;
import com.groupe2cs.bizyhub.products.domain.event.ProductUpdatedEvent;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductImageRepository;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
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
@ProcessingGroup("Product")
public class ProductProjection {

	private final ProductRepository repository;
	private final ProductImageRepository productImageRepository;


	private static boolean hasId(Object s) {
		return s != null;
	}


	@EventHandler
	public void on(ProductCreatedEvent event) {
		try {
			Product entity = Product.builder().build();
			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getCode() != null && hasId(event.getCode().value())) {
				entity.setCode(event.getCode().value());
			}
			if (event.getName() != null && hasId(event.getName().value())) {
				entity.setName(event.getName().value());
			}
			if (event.getDescription() != null && hasId(event.getDescription().value())) {
				entity.setDescription(event.getDescription().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getIsPublic() != null && hasId(event.getIsPublic().value())) {
				entity.setIsPublic(event.getIsPublic().value());
			}
			if (event.getHasSold() != null && hasId(event.getHasSold().value())) {
				entity.setHasSold(event.getHasSold().value());
			}
			if (event.getHasPrice() != null && hasId(event.getHasPrice().value())) {
				entity.setHasPrice(event.getHasPrice().value());
			}
			if (event.getLevel() != null && hasId(event.getLevel().value())) {
				entity.setLevel(event.getLevel().value());
			}
			if (event.getQuantity() != null && hasId(event.getQuantity().value())) {
				entity.setQuantity(event.getQuantity().value());
			}
			if (event.getBarcode() != null && hasId(event.getBarcode().value())) {
				entity.setBarcode(event.getBarcode().value());
			}
			if (event.getCompany() != null && hasId(event.getCompany().value())) {
				entity.setCompany(event.getCompany().value());
			}
			if (event.getUnit() != null && hasId(event.getUnit().value())) {
				entity.setUnit(event.getUnit().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getCategory() != null && hasId(event.getCategory().value())) {
				entity.setCategory(event.getCategory().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getDefaultPrice() != null && hasId(event.getDefaultPrice().value())) {
				entity.setDefaultPrice(event.getDefaultPrice().value());
			}
			if (event.getStatuses() != null && hasId(event.getStatuses().value())) {
				entity.setStatuses(event.getStatuses().value());
			}
			if (event.getPurchasePrice() != null && hasId(event.getPurchasePrice().value())) {
				entity.setPurchasePrice(event.getPurchasePrice().value());
			}


			entity.setId(event.getId().value());

			if (event.getCreatedBy() != null) {
				entity.setCreatedBy(new User(event.getCreatedBy().value()));
			}
			if (event.getTenant() != null) {
				entity.setTenant(new Tenant(event.getTenant().value()));
			}


			if (event.getRemoteId().value() == null) {
				entity.setRemoteId(event.getId().value());
			}


			repository.save(entity);


			log.info("Product inserted: {}", entity);

		} catch (Exception e) {
			log.error("Error saving Product: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(ProductUpdatedEvent event) {
		try {
			Product entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("Product not found"));


			if (event.getId() != null && hasId(event.getId().value())) {
				entity.setId(event.getId().value());
			}
			if (event.getRemoteId() != null && hasId(event.getRemoteId().value())) {
				entity.setRemoteId(event.getRemoteId().value());
			}
			if (event.getLocalId() != null && hasId(event.getLocalId().value())) {
				entity.setLocalId(event.getLocalId().value());
			}
			if (event.getCode() != null && hasId(event.getCode().value())) {
				entity.setCode(event.getCode().value());
			}
			if (event.getName() != null && hasId(event.getName().value())) {
				entity.setName(event.getName().value());
			}
			if (event.getDescription() != null && hasId(event.getDescription().value())) {
				entity.setDescription(event.getDescription().value());
			}
			if (event.getStatus() != null && hasId(event.getStatus().value())) {
				entity.setStatus(event.getStatus().value());
			}
			if (event.getIsPublic() != null && hasId(event.getIsPublic().value())) {
				entity.setIsPublic(event.getIsPublic().value());
			}
			if (event.getHasSold() != null && hasId(event.getHasSold().value())) {
				entity.setHasSold(event.getHasSold().value());
			}
			if (event.getHasPrice() != null && hasId(event.getHasPrice().value())) {
				entity.setHasPrice(event.getHasPrice().value());
			}
			if (event.getLevel() != null && hasId(event.getLevel().value())) {
				entity.setLevel(event.getLevel().value());
			}
			if (event.getQuantity() != null && hasId(event.getQuantity().value())) {
				entity.setQuantity(event.getQuantity().value());
			}
			if (event.getBarcode() != null && hasId(event.getBarcode().value())) {
				entity.setBarcode(event.getBarcode().value());
			}
			if (event.getCompany() != null && hasId(event.getCompany().value())) {
				entity.setCompany(event.getCompany().value());
			}
			if (event.getUnit() != null && hasId(event.getUnit().value())) {
				entity.setUnit(event.getUnit().value());
			}
			if (event.getSyncAt() != null && hasId(event.getSyncAt().value())) {
				entity.setSyncAt(event.getSyncAt().value());
			}
			if (event.getCategory() != null && hasId(event.getCategory().value())) {
				entity.setCategory(event.getCategory().value());
			}
			if (event.getAccount() != null && hasId(event.getAccount().value())) {
				entity.setAccount(event.getAccount().value());
			}
			if (event.getDefaultPrice() != null && hasId(event.getDefaultPrice().value())) {
				entity.setDefaultPrice(event.getDefaultPrice().value());
			}
			if (event.getStatuses() != null && hasId(event.getStatuses().value())) {
				entity.setStatuses(event.getStatuses().value());
			}
			if (event.getPurchasePrice() != null && hasId(event.getPurchasePrice().value())) {
				entity.setPurchasePrice(event.getPurchasePrice().value());
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


			log.info("Product updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating Product: {}", e.getMessage(), e);
			throw e;
		}
	}

	@EventHandler
	public void on(ProductDeletedEvent event) {
		try {

			productImageRepository.deleteByProductId(event.getId().value());

			repository.deleteById(event.getId().value());
			log.info("Product deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting Product: {}", e.getMessage(), e);
			throw e;
		}
	}
}
