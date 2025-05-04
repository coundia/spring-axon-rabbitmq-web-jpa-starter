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
public class FindBySettingStringValueHandler {

private final SettingRepository repository;
@QueryHandler
public List<SettingResponse> handle(FindBySettingStringValueQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();

String value = query.getStringValue().value();
	List<Setting> entities = repository.findByStringValueAndCreatedById(value, metaRequest.getUserId());
	return entities.stream()
	.map(SettingMapper::toResponse)
	.toList();
	}


}
