package com.groupe2cs.bizyhub.products.application.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@Getter
public class FindByNameProductsQuery {
    private Pageable pageable;
    private String name;
}
