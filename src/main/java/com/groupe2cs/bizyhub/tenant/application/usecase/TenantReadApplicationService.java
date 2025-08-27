package com.groupe2cs.bizyhub.tenant.application.usecase;

import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.tenant.application.mapper.*;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.tenant.application.query.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TenantReadApplicationService {

private final QueryGateway queryGateway;


public TenantPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllTenantQuery query = new FindAllTenantQuery(page, limit,metaRequest);
	CompletableFuture<TenantPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TenantPagedResponse.class));
	return future.join();
}


public TenantResponse findByTenantId(TenantId value, MetaRequest metaRequest) {

	FindByTenantIdQuery query = new FindByTenantIdQuery(value,metaRequest);
	CompletableFuture<TenantResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TenantResponse.class));
	return future.join();
}


public List<TenantResponse> findByTenantName(
	TenantName value,
	MetaRequest metaRequest
	) {

	FindByTenantNameQuery query = new FindByTenantNameQuery(value,metaRequest);
	CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
	return future.join();
}
public List<TenantResponse> findByTenantDescription(
	TenantDescription value,
	MetaRequest metaRequest
	) {

	FindByTenantDescriptionQuery query = new FindByTenantDescriptionQuery(value,metaRequest);
	CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
	return future.join();
}
public List<TenantResponse> findByTenantDomain(
	TenantDomain value,
	MetaRequest metaRequest
	) {

	FindByTenantDomainQuery query = new FindByTenantDomainQuery(value,metaRequest);
	CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
	return future.join();
}
public List<TenantResponse> findByTenantLanguage(
	TenantLanguage value,
	MetaRequest metaRequest
	) {

	FindByTenantLanguageQuery query = new FindByTenantLanguageQuery(value,metaRequest);
	CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
	return future.join();
}
public List<TenantResponse> findByTenantActive(
	TenantActive value,
	MetaRequest metaRequest
	) {

	FindByTenantActiveQuery query = new FindByTenantActiveQuery(value,metaRequest);
	CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
	return future.join();
}
public List<TenantResponse> findByTenantTenant(
	TenantTenant value,
	MetaRequest metaRequest
	) {

	FindByTenantTenantQuery query = new FindByTenantTenantQuery(value,metaRequest);
	CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
	return future.join();
}
public List<TenantResponse> findByTenantCreatedBy(
	TenantCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByTenantCreatedByQuery query = new FindByTenantCreatedByQuery(value,metaRequest);
	CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
	return future.join();
}

}
