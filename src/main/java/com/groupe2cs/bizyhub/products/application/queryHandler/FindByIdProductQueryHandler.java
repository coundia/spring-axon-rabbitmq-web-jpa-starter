package com.groupe2cs.bizyhub.products.application.queryHandler;


import com.groupe2cs.bizyhub.products.application.query.FindByIdProductQuery;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class FindByIdProductQueryHandler {
    private final ProductRepository repository;

    public FindByIdProductQueryHandler(ProductRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public Product handle(FindByIdProductQuery query) {
        return repository.findById(
                query.getProductId().value()).orElseThrow(
                () -> new RuntimeException("Product with id " + query.getProductId() + " not found")
        );
    }
}
