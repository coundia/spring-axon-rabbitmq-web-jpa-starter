package com.groupe2cs.bizyhub.sales.application.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindAllSaleQuery {

    private final int page;
    private final int limit;
}
