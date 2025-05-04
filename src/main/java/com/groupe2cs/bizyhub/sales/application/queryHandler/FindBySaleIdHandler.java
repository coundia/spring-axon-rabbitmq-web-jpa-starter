package com.groupe2cs.bizyhub.sales.application.queryHandler;

import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.sales.application.query.*;
import com.groupe2cs.bizyhub.sales.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindBySaleIdHandler {

private final SaleRepository repository;
@QueryHandler

 public SaleResponse handle(FindBySaleIdQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

	String value = query.getId().value();
	Sale entity = repository.findByIdAndCreatedById(value, metaRequest.getUserId())
		.orElse(null);

		if (entity == null) {
			return null;
		}

		return SaleMapper.toResponse(entity);
	}

}
