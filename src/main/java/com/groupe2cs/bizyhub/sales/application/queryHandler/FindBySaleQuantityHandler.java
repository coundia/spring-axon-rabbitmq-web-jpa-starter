package com.groupe2cs.bizyhub.sales.application.queryHandler;

import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.mapper.SaleMapper;
import com.groupe2cs.bizyhub.sales.application.query.FindBySaleQuantityQuery;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindBySaleQuantityHandler {

    private final SaleRepository repository;

    @QueryHandler
    public List<SaleResponse> handle(FindBySaleQuantityQuery query) {
        Integer value = query.getQuantity().value();
        List<Sale> entities = repository.findByQuantity(value);
        return entities.stream()
                .map(SaleMapper::toResponse)
                .toList();
    }

}
