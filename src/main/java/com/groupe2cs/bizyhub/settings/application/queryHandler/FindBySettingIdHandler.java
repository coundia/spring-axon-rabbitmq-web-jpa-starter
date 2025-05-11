package com.groupe2cs.bizyhub.settings.application.queryHandler;

import com.groupe2cs.bizyhub.settings.application.mapper.*;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.*;
import com.groupe2cs.bizyhub.settings.application.dto.*;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.*;
import com.groupe2cs.bizyhub.settings.application.query.*;
import com.groupe2cs.bizyhub.settings.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindBySettingIdHandler {

private final SettingRepository repository;
@QueryHandler

 public SettingResponse handle(FindBySettingIdQuery query) {

    MetaRequest metaRequest = query.getMetaRequest();
    Setting entity = null;

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
		return SettingMapper.toResponse(entity);
	}

}
