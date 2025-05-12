package com.groupe2cs.bizyhub.categories.application.queryHandler;

import com.groupe2cs.bizyhub.categories.application.mapper.*;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.*;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.*;
import com.groupe2cs.bizyhub.categories.application.query.*;
import com.groupe2cs.bizyhub.categories.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByCategoryReferenceHandler {

private final CategoryRepository repository;

@QueryHandler
public List<CategoryResponse> handle(FindByCategoryReferenceQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Category> entities = null;
	 String value = query.getReference().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByReferenceAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByReferenceAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(CategoryMapper::toResponse)
	.toList();
	}


}
