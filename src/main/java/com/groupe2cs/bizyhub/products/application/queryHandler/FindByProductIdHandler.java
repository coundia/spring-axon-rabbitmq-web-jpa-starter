package com.groupe2cs.bizyhub.products.application.queryHandler;

import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.mapper.ProductMapper;
import com.groupe2cs.bizyhub.products.application.query.FindByProductIdQuery;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNotFoundException;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByProductIdHandler {

    private final ProductRepository repository;

    @QueryHandler
    public ProductResponse handle(FindByProductIdQuery query) {
        String value = query.getId().value();
        Product entity = repository.findById(value)
                .orElseThrow(() -> new ProductNotFoundException(query.getId()));
        return ProductMapper.toResponse(entity);
    }

}
