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
public class FindBySaleUserUpdatedAtHandler {

private final SaleUserRepository repository;
@QueryHandler
public List<SaleUserResponse> handle(FindBySaleUserUpdatedAtQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();

java.time.Instant value = query.getUpdatedAt().value();
	List<SaleUser> entities = repository.findByUpdatedAtAndCreatedById(value, metaRequest.getUserId());
	return entities.stream()
	.map(SaleUserMapper::toResponse)
	.toList();
	}


}
