package com.groupe2cs.bizyhub.settings.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.settings.application.dto.*;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.*;
import com.groupe2cs.bizyhub.settings.application.query.*;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.*;
import com.groupe2cs.bizyhub.settings.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllSettingQueryHandler {

private final SettingRepository repository;

public FindAllSettingQueryHandler(SettingRepository repository) {
	this.repository = repository;
}

@QueryHandler
public SettingPagedResponse handle(FindAllSettingQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<Setting> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all Settings");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{

log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);


}

List<SettingResponse> responses = pages.stream()
	.map(SettingMapper::toResponse)
	.toList();

	return SettingPagedResponse.from(
	pages,
	responses
	);
	}
}
