package com.groupe2cs.bizyhub.sales.application.queryHandler;

import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.mapper.SaleMapper;
import com.groupe2cs.bizyhub.sales.application.query.FindBySaleProductQuery;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindBySaleProductHandler {

    private final SaleRepository repository;

    @QueryHandler
    public List<SaleResponse> handle(FindBySaleProductQuery query) {
        String value = query.getProduct().value();
        List<Sale> entities = repository.findByProduct(value);
        return entities.stream()
                .map(SaleMapper::toResponse)
                .toList();
    }

}
