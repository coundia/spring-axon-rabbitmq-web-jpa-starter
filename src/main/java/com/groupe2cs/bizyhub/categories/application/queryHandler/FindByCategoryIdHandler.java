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
public class FindByCategoryIdHandler {

private final CategoryRepository repository;
@QueryHandler

 public CategoryResponse handle(FindByCategoryIdQuery query) {

    MetaRequest metaRequest = query.getMetaRequest();
    Category entity = null;

	String value = query.getId().value();

	if(metaRequest.isAdmin()) {
	    entity = repository.findByIdAndTenantId(value, metaRequest.getTenantId())
	    .stream()
        .findFirst()
	    .orElse(null);
	 }else{
	    entity = repository.findByIdAndCreatedById(value, metaRequest.getUserId())
	    .stream()
        .findFirst()
	    .orElse(null);
	 }

    if (entity == null) {
        return null;
    }
		return CategoryMapper.toResponse(entity);
	}

}
