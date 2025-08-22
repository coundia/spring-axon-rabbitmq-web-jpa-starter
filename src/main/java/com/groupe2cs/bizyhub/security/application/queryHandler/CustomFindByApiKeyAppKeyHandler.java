package com.groupe2cs.bizyhub.security.application.queryHandler;

	import com.groupe2cs.bizyhub.security.application.query.FindByApiKeyAppKeyQuery;
	import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
	import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
	import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
	import com.groupe2cs.bizyhub.security.application.mapper.ApiKeyMapper;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
	import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
	import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import org.axonframework.queryhandling.QueryHandler;

/**
* Handler for the FindByApiKeyAppKeyQuery.
* This class is responsible for handling the query to find an API key by its app key.
*/
@Slf4j
@Component
@RequiredArgsConstructor
public class CustomFindByApiKeyAppKeyHandler {

private final ApiKeyRepository repository;

@QueryHandler
public ApiKeyResponse handle(FindByApiKeyAppKeyQuery query) {

MetaRequest metaRequest = query.getMetaRequest();

String value = query.getAppKey().value();
ApiKey entity = repository.findByAppKeyAndTenantName(value, metaRequest.getTenantName())
.stream()
.findFirst()
.orElse(null);

if (entity == null) {
log.error("[FindByApiKeyAppKeyHandler] Api key not found for appKey: {} in tenant name {}",
value,
metaRequest.getTenantName());
return null;
}
return ApiKeyMapper.toResponse(entity);
}


}
