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
public class FindBySettingValueHandler {

private final SettingRepository repository;

@QueryHandler
public List<SettingResponse> handle(FindBySettingValueQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Setting> entities = null;
	 String value = query.getValue().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByValueAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByValueAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(SettingMapper::toResponse)
	.toList();
	}


}
