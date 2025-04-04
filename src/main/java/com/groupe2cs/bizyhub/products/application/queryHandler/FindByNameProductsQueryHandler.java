package com.groupe2cs.bizyhub.products.application.queryHandler;

import com.groupe2cs.bizyhub.products.application.dto.ListProductResponseDTO;
import com.groupe2cs.bizyhub.products.application.query.FindByNameProductsQuery;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class FindByNameProductsQueryHandler {

    private final ProductRepository productRepository;

    public FindByNameProductsQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public ListProductResponseDTO handle(FindByNameProductsQuery query) {

        Pageable pageable = PageRequest.of(query.getPageable().getPageNumber(), query.getPageable().getPageSize());
        Page<Product> responsePage = productRepository.findAllByNameContainingIgnoreCase(query.getName(), pageable);

        return ListProductResponseDTO.fromPage(responsePage, pageable);
    }
}