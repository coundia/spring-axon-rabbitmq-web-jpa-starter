package com.groupe2cs.bizyhub.products.application.queryHandler;


import com.groupe2cs.bizyhub.products.application.query.GetProductQuery;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductQueryHandler {
    private final ProductRepository repository;

    public ProductQueryHandler(ProductRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public Product handle(GetProductQuery query) {
        return repository.findById(query.getId().value()).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
