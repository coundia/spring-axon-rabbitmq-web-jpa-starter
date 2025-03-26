package com.groupe2cs.bizyhub.products.application.queryHandler;

import com.groupe2cs.bizyhub.products.application.dto.ListProductResponseDTO;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponseDTO;
import com.groupe2cs.bizyhub.products.application.query.ListProductsQuery;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
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
    public ListProductResponseDTO handle(ListProductsQuery query) {
        log.info("List products with page: {}", query.getPageable());
        Pageable pageable = PageRequest.of(query.getPageable().getPageNumber(), query.getPageable().getPageSize());

        ListProductResponseDTO listProductResponseDTO = new ListProductResponseDTO();

        Page<Product> responsePage = productRepository.findAll(pageable);

      List<ProductResponseDTO> productsList =  responsePage.getContent()
                .stream()
                .map(product -> new ProductResponseDTO(
                        product.getId(),
                        product.getName(),
                        product.getPrice()
                ))
                .collect(Collectors.toList());

      listProductResponseDTO.setProducts(productsList);
      listProductResponseDTO.setTotalPages(responsePage.getTotalPages());
      listProductResponseDTO.setTotalElements(responsePage.getTotalElements());
      listProductResponseDTO.setCurrentPages(pageable.getPageNumber());
      listProductResponseDTO.setLimit(pageable.getPageSize());

        return listProductResponseDTO;
    }
}