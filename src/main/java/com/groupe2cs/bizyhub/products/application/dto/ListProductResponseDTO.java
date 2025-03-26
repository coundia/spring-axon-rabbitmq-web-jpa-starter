package com.groupe2cs.bizyhub.products.application.dto;

import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class ListProductResponseDTO implements Serializable {
    @Schema(description = "The list of products")
    private List<ProductResponseDTO> products = new ArrayList<>();
    private long currentPages;
    private long totalPages;
    private long totalElements;
    private long limit;

    public static ListProductResponseDTO fromPage(Page<Product> responsePage, Pageable pageable) {
        ListProductResponseDTO listProductResponseDTO = new ListProductResponseDTO();
        List<ProductResponseDTO> productsList = responsePage.getContent()
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