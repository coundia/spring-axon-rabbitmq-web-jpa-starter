package com.groupe2cs.bizyhub.products.application.queryHandler;

import com.groupe2cs.bizyhub.products.application.mapper.*;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.products.application.query.*;
import com.groupe2cs.bizyhub.products.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByProductPurchasePriceHandler {

private final ProductRepository repository;

@QueryHandler
public List<ProductResponse> handle(FindByProductPurchasePriceQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Product> entities = null;
	 Double value = query.getPurchasePrice().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByPurchasePriceAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByPurchasePriceAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(ProductMapper::toResponse)
	.toList();
	}


}
