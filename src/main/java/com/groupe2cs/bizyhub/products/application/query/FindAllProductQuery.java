package com.groupe2cs.bizyhub.products.application.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindAllProductQuery {

    private final int page;
    private final int limit;

}
