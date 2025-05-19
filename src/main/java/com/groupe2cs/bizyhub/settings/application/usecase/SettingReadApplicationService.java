package com.groupe2cs.bizyhub.settings.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.settings.application.dto.*;
import com.groupe2cs.bizyhub.settings.application.query.*;
import com.groupe2cs.bizyhub.settings.application.mapper.*;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class SettingReadApplicationService {

private final QueryGateway queryGateway;


public SettingPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllSettingQuery query = new FindAllSettingQuery(page, limit,metaRequest);
	CompletableFuture<SettingPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(SettingPagedResponse.class));
	return future.join();
}


public SettingResponse findBySettingId(SettingId value, MetaRequest metaRequest) {

	FindBySettingIdQuery query = new FindBySettingIdQuery(value,metaRequest);
	CompletableFuture<SettingResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(SettingResponse.class));
	return future.join();
}


public List<SettingResponse> findBySettingName(
	SettingName value,
	MetaRequest metaRequest
	) {

	FindBySettingNameQuery query = new FindBySettingNameQuery(value,metaRequest);
	CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
	return future.join();
}
public List<SettingResponse> findBySettingValue(
	SettingValue value,
	MetaRequest metaRequest
	) {

	FindBySettingValueQuery query = new FindBySettingValueQuery(value,metaRequest);
	CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
	return future.join();
}
public List<SettingResponse> findBySettingLocale(
	SettingLocale value,
	MetaRequest metaRequest
	) {

	FindBySettingLocaleQuery query = new FindBySettingLocaleQuery(value,metaRequest);
	CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
	return future.join();
}
public List<SettingResponse> findBySettingDetails(
	SettingDetails value,
	MetaRequest metaRequest
	) {

	FindBySettingDetailsQuery query = new FindBySettingDetailsQuery(value,metaRequest);
	CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
	return future.join();
}
public List<SettingResponse> findBySettingIsActive(
	SettingIsActive value,
	MetaRequest metaRequest
	) {

	FindBySettingIsActiveQuery query = new FindBySettingIsActiveQuery(value,metaRequest);
	CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
	return future.join();
}
public List<SettingResponse> findBySettingUpdatedAt(
	SettingUpdatedAt value,
	MetaRequest metaRequest
	) {

	FindBySettingUpdatedAtQuery query = new FindBySettingUpdatedAtQuery(value,metaRequest);
	CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
	return future.join();
}
public List<SettingResponse> findBySettingReference(
	SettingReference value,
	MetaRequest metaRequest
	) {

	FindBySettingReferenceQuery query = new FindBySettingReferenceQuery(value,metaRequest);
	CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
	return future.join();
}
public List<SettingResponse> findBySettingCreatedBy(
	SettingCreatedBy value,
	MetaRequest metaRequest
	) {

	FindBySettingCreatedByQuery query = new FindBySettingCreatedByQuery(value,metaRequest);
	CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
	return future.join();
}
public List<SettingResponse> findBySettingTenant(
	SettingTenant value,
	MetaRequest metaRequest
	) {

	FindBySettingTenantQuery query = new FindBySettingTenantQuery(value,metaRequest);
	CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
	return future.join();
}

}
