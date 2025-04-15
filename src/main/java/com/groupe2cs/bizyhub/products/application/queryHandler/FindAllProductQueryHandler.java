package com.groupe2cs.bizyhub.products.application.queryHandler;

import com.groupe2cs.bizyhub.products.application.dto.ProductPagedResponse;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.mapper.ProductMapper;
import com.groupe2cs.bizyhub.products.application.query.FindAllProductQuery;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllProductQueryHandler {

    private final ProductRepository repository;

    public FindAllProductQueryHandler(ProductRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public ProductPagedResponse handle(FindAllProductQuery query) {
        int limit = query.getLimit();
        int offset = query.getPage() * limit;

        long totalElements = repository.count();

        PageRequest pageable = PageRequest.of(offset / limit, limit);

        Page<Product> pages = repository.findAll(pageable);

        List<ProductResponse> responses = pages.stream()
                .map(ProductMapper::toResponse)
                .toList();

        return ProductPagedResponse.from(
                pages,
                responses
        );
    }
}
