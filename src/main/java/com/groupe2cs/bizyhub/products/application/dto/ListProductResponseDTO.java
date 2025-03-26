package com.groupe2cs.bizyhub.products.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


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
}