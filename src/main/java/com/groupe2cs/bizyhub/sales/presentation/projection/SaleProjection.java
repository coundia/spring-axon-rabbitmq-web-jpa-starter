package com.groupe2cs.bizyhub.sales.presentation.projection;

import com.groupe2cs.bizyhub.sales.domain.event.SaleCreatedEvent;
import com.groupe2cs.bizyhub.sales.domain.event.SaleDeletedEvent;
import com.groupe2cs.bizyhub.sales.domain.event.SaleUpdatedEvent;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SaleProjection {

    private final SaleRepository repository;

    public SaleProjection(SaleRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(SaleCreatedEvent event) {
        try {
            Sale entity =
                    new Sale(
                            event.getId().value(),
                            event.getQuantity().value(),
                            event.getTotal_price().value(),
                            event.getFacture().value());
            repository.save(entity);
            log.info("Sale inserted: {}", entity);
        } catch (Exception e) {
            log.error("Error saving Sale: {}", e.getMessage(), e);
        }
    }

    @EventHandler
    public void on(SaleUpdatedEvent event) {
        try {
            Sale entity =
                    repository
                            .findById(event.getId().value())
                            .orElseThrow(() -> new RuntimeException("Sale not found"));

            entity.setId(event.getId().value());
            entity.setQuantity(event.getQuantity().value());
            entity.setTotal_price(event.getTotal_price().value());
            entity.setFacture(event.getFacture().value());

            repository.save(entity);
            log.info("Sale updated successfully: {}", event.getId().value());
        } catch (Exception e) {
            log.error("Error updating Sale: {}", e.getMessage(), e);
        }
    }

    @EventHandler
    public void on(SaleDeletedEvent event) {
        try {
            repository.deleteById(event.getId().value());
            log.info("Sale deleted successfully: {}", event.getId().value());
        } catch (Exception e) {
            log.error("Error deleting Sale: {}", e.getMessage(), e);
        }
    }
}
