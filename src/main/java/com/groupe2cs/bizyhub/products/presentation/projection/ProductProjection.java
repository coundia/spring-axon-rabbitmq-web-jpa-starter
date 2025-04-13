package com.groupe2cs.bizyhub.products.presentation.projection;

import com.groupe2cs.bizyhub.products.domain.event.ProductCreatedEvent;
import com.groupe2cs.bizyhub.products.domain.event.ProductDeletedEvent;
import com.groupe2cs.bizyhub.products.domain.event.ProductUpdatedEvent;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductProjection {

    private final ProductRepository repository;

    public ProductProjection(ProductRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        try {
            Product entity =
                    new Product(event.getId().value(), event.getName().value(), event.getPrice().value());
            repository.save(entity);
            log.info("Product inserted: {}", entity);
        } catch (Exception e) {
            log.error("Error saving Product: {}", e.getMessage(), e);
        }
    }

    @EventHandler
    public void on(ProductUpdatedEvent event) {
        try {
            Product entity =
                    repository
                            .findById(event.getId().value())
                            .orElseThrow(() -> new RuntimeException("Product not found"));

            entity.setId(event.getId().value());
            entity.setName(event.getName().value());
            entity.setPrice(event.getPrice().value());

            repository.save(entity);
            log.info("Product updated successfully: {}", event.getId().value());
        } catch (Exception e) {
            log.error("Error updating Product: {}", e.getMessage(), e);
        }
    }

    @EventHandler
    public void on(ProductDeletedEvent event) {
        try {
            repository.deleteById(event.getId().value());
            log.info("Product deleted successfully: {}", event.getId().value());
        } catch (Exception e) {
            log.error("Error deleting Product: {}", e.getMessage(), e);
        }
    }
}
