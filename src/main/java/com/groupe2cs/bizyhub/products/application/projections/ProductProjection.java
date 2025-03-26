package com.groupe2cs.bizyhub.products.application.projections;

import com.groupe2cs.bizyhub.products.application.event.ProductCreatedEvent;
import com.groupe2cs.bizyhub.products.application.event.ProductDeletedEvent;
import com.groupe2cs.bizyhub.products.application.event.UpdateNameProductEvent;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ProductProjection {
    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product product = new Product(event.getId(), event.getName(), event.getPrice());
        productRepository.save(product);
    }

    @EventHandler
    public void on(ProductDeletedEvent event) {
        productRepository.findById(event.getProductId()).ifPresentOrElse(
                productRepository::delete,
                () -> {
                    throw new IllegalArgumentException("Product not found with id: " + event.getProductId());
                }
        );
    }

    @EventHandler
    public void on(UpdateNameProductEvent event) {
       Product product = productRepository.findById(event.getProductId()).orElseThrow();
       product.setName(event.getProductName());
       productRepository.save(product);
    }

}
