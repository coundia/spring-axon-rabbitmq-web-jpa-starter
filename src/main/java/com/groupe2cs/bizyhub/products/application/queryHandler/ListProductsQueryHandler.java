package com.groupe2cs.bizyhub.products.application.queryHandler;

import com.groupe2cs.bizyhub.products.application.dto.ProductResponseDTO;
import com.groupe2cs.bizyhub.products.application.query.ListProductsQuery;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ListProductsQueryHandler {

    private final ProductRepository productRepository;

    public ListProductsQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductResponseDTO> handle(ListProductsQuery query) {
        log.info("List products with page: {}", query.getPageable());
        Pageable pageable = PageRequest.of(query.getPageable().getPageNumber(), query.getPageable().getPageSize());

        return productRepository.findAll(pageable).getContent().stream()
                .map(product -> new ProductResponseDTO(
                        product.getId(),
                        product.getName(),
                        product.getPrice()
                ))
                .collect(Collectors.toList());
    }
}