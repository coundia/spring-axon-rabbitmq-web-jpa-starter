package com.groupe2cs.bizyhub.products.application.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@Getter
public class ListProductsQuery {
    private Pageable pageable;
}
