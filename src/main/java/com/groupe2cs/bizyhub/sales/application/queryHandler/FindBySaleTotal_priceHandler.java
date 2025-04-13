package com.groupe2cs.bizyhub.sales.application.queryHandler;

import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.mapper.SaleMapper;
import com.groupe2cs.bizyhub.sales.application.query.FindBySaleTotal_priceQuery;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindBySaleTotal_priceHandler {

    private final SaleRepository repository;

    @QueryHandler
    public List<SaleResponse> handle(FindBySaleTotal_priceQuery query) {
        Double value = query.getTotal_price().value();
        List<Sale> entities = repository.findByTotal_price(value);
        return entities.stream().map(SaleMapper::toResponse).toList();
    }
}
