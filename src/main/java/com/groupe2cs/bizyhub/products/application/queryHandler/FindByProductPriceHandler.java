package com.groupe2cs.bizyhub.products.application.queryHandler;

import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.mapper.ProductMapper;
import com.groupe2cs.bizyhub.products.application.query.FindByProductPriceQuery;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByProductPriceHandler {

    private final ProductRepository repository;

    @QueryHandler
    public List<ProductResponse> handle(FindByProductPriceQuery query) {
        Double value = query.getPrice().value();
        List<Product> entities = repository.findByPrice(value);
        return entities.stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

}
