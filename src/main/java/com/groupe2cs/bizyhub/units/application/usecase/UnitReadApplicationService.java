package com.groupe2cs.bizyhub.units.application.usecase;

import com.groupe2cs.bizyhub.units.application.dto.*;
import com.groupe2cs.bizyhub.units.application.query.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.units.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.units.domain.valueObject.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class UnitReadApplicationService {

private final QueryGateway queryGateway;


public UnitPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllUnitQuery query = new FindAllUnitQuery(page, limit,metaRequest);
	CompletableFuture<UnitPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(UnitPagedResponse.class));
	return future.join();
}


public UnitResponse findByUnitId(UnitId value, MetaRequest metaRequest) {

	FindByUnitIdQuery query = new FindByUnitIdQuery(value,metaRequest);
	CompletableFuture<UnitResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(UnitResponse.class));
	return future.join();
}


public List<UnitResponse> findByUnitRemoteId(
	UnitRemoteId value,
	MetaRequest metaRequest
	) {

	FindByUnitRemoteIdQuery query = new FindByUnitRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<UnitResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UnitResponse.class));
	return future.join();
}
public List<UnitResponse> findByUnitCode(
	UnitCode value,
	MetaRequest metaRequest
	) {

	FindByUnitCodeQuery query = new FindByUnitCodeQuery(value,metaRequest);
	CompletableFuture<List<UnitResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UnitResponse.class));
	return future.join();
}
public List<UnitResponse> findByUnitName(
	UnitName value,
	MetaRequest metaRequest
	) {

	FindByUnitNameQuery query = new FindByUnitNameQuery(value,metaRequest);
	CompletableFuture<List<UnitResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UnitResponse.class));
	return future.join();
}
public List<UnitResponse> findByUnitSyncAt(
	UnitSyncAt value,
	MetaRequest metaRequest
	) {

	FindByUnitSyncAtQuery query = new FindByUnitSyncAtQuery(value,metaRequest);
	CompletableFuture<List<UnitResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UnitResponse.class));
	return future.join();
}
public List<UnitResponse> findByUnitDescription(
	UnitDescription value,
	MetaRequest metaRequest
	) {

	FindByUnitDescriptionQuery query = new FindByUnitDescriptionQuery(value,metaRequest);
	CompletableFuture<List<UnitResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UnitResponse.class));
	return future.join();
}
public List<UnitResponse> findByUnitCreatedBy(
	UnitCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByUnitCreatedByQuery query = new FindByUnitCreatedByQuery(value,metaRequest);
	CompletableFuture<List<UnitResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UnitResponse.class));
	return future.join();
}
public List<UnitResponse> findByUnitTenant(
	UnitTenant value,
	MetaRequest metaRequest
	) {

	FindByUnitTenantQuery query = new FindByUnitTenantQuery(value,metaRequest);
	CompletableFuture<List<UnitResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UnitResponse.class));
	return future.join();
}

}
