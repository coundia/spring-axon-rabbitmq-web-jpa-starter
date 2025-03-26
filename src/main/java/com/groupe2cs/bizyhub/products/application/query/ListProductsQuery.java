package com.groupe2cs.bizyhub.products.application.query;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

import java.util.Map;



@AllArgsConstructor
@Getter
public class ListProductsQuery {
    private Map<String, String> filters;
    private Pageable pageable;
}
