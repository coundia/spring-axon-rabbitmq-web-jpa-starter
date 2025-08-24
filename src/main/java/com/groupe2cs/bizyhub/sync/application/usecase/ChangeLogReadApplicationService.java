package com.groupe2cs.bizyhub.sync.application.usecase;

import com.groupe2cs.bizyhub.sync.application.mapper.*;
import com.groupe2cs.bizyhub.sync.application.query.*;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ChangeLogReadApplicationService {

private final QueryGateway queryGateway;


public ChangeLogPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllChangeLogQuery query = new FindAllChangeLogQuery(page, limit,metaRequest);
	CompletableFuture<ChangeLogPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(ChangeLogPagedResponse.class));
	return future.join();
}


public ChangeLogResponse findByChangeLogId(ChangeLogId value, MetaRequest metaRequest) {

	FindByChangeLogIdQuery query = new FindByChangeLogIdQuery(value,metaRequest);
	CompletableFuture<ChangeLogResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(ChangeLogResponse.class));
	return future.join();
}


public List<ChangeLogResponse> findByChangeLogEntityTable(
	ChangeLogEntityTable value,
	MetaRequest metaRequest
	) {

	FindByChangeLogEntityTableQuery query = new FindByChangeLogEntityTableQuery(value,metaRequest);
	CompletableFuture<List<ChangeLogResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChangeLogResponse.class));
	return future.join();
}
public List<ChangeLogResponse> findByChangeLogEntityId(
	ChangeLogEntityId value,
	MetaRequest metaRequest
	) {

	FindByChangeLogEntityIdQuery query = new FindByChangeLogEntityIdQuery(value,metaRequest);
	CompletableFuture<List<ChangeLogResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChangeLogResponse.class));
	return future.join();
}
public List<ChangeLogResponse> findByChangeLogRemoteId(
	ChangeLogRemoteId value,
	MetaRequest metaRequest
	) {

	FindByChangeLogRemoteIdQuery query = new FindByChangeLogRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<ChangeLogResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChangeLogResponse.class));
	return future.join();
}
public List<ChangeLogResponse> findByChangeLogOperation(
	ChangeLogOperation value,
	MetaRequest metaRequest
	) {

	FindByChangeLogOperationQuery query = new FindByChangeLogOperationQuery(value,metaRequest);
	CompletableFuture<List<ChangeLogResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChangeLogResponse.class));
	return future.join();
}
public List<ChangeLogResponse> findByChangeLogPayload(
	ChangeLogPayload value,
	MetaRequest metaRequest
	) {

	FindByChangeLogPayloadQuery query = new FindByChangeLogPayloadQuery(value,metaRequest);
	CompletableFuture<List<ChangeLogResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChangeLogResponse.class));
	return future.join();
}
public List<ChangeLogResponse> findByChangeLogStatus(
	ChangeLogStatus value,
	MetaRequest metaRequest
	) {

	FindByChangeLogStatusQuery query = new FindByChangeLogStatusQuery(value,metaRequest);
	CompletableFuture<List<ChangeLogResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChangeLogResponse.class));
	return future.join();
}
public List<ChangeLogResponse> findByChangeLogSyncAt(
	ChangeLogSyncAt value,
	MetaRequest metaRequest
	) {

	FindByChangeLogSyncAtQuery query = new FindByChangeLogSyncAtQuery(value,metaRequest);
	CompletableFuture<List<ChangeLogResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChangeLogResponse.class));
	return future.join();
}
public List<ChangeLogResponse> findByChangeLogAttempts(
	ChangeLogAttempts value,
	MetaRequest metaRequest
	) {

	FindByChangeLogAttemptsQuery query = new FindByChangeLogAttemptsQuery(value,metaRequest);
	CompletableFuture<List<ChangeLogResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChangeLogResponse.class));
	return future.join();
}
public List<ChangeLogResponse> findByChangeLogError(
	ChangeLogError value,
	MetaRequest metaRequest
	) {

	FindByChangeLogErrorQuery query = new FindByChangeLogErrorQuery(value,metaRequest);
	CompletableFuture<List<ChangeLogResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChangeLogResponse.class));
	return future.join();
}
public List<ChangeLogResponse> findByChangeLogCreatedBy(
	ChangeLogCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByChangeLogCreatedByQuery query = new FindByChangeLogCreatedByQuery(value,metaRequest);
	CompletableFuture<List<ChangeLogResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChangeLogResponse.class));
	return future.join();
}
public List<ChangeLogResponse> findByChangeLogTenant(
	ChangeLogTenant value,
	MetaRequest metaRequest
	) {

	FindByChangeLogTenantQuery query = new FindByChangeLogTenantQuery(value,metaRequest);
	CompletableFuture<List<ChangeLogResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChangeLogResponse.class));
	return future.join();
}

}
