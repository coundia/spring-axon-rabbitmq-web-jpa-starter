package com.groupe2cs.bizyhub.sync.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.sync.application.query.*;
import com.groupe2cs.bizyhub.sync.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class SyncStateReadApplicationService {

private final QueryGateway queryGateway;


public SyncStatePagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllSyncStateQuery query = new FindAllSyncStateQuery(page, limit,metaRequest);
	CompletableFuture<SyncStatePagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(SyncStatePagedResponse.class));
	return future.join();
}


public SyncStateResponse findBySyncStateId(SyncStateId value, MetaRequest metaRequest) {

	FindBySyncStateIdQuery query = new FindBySyncStateIdQuery(value,metaRequest);
	CompletableFuture<SyncStateResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(SyncStateResponse.class));
	return future.join();
}


public List<SyncStateResponse> findBySyncStateEntityTable(
	SyncStateEntityTable value,
	MetaRequest metaRequest
	) {

	FindBySyncStateEntityTableQuery query = new FindBySyncStateEntityTableQuery(value,metaRequest);
	CompletableFuture<List<SyncStateResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SyncStateResponse.class));
	return future.join();
}
public List<SyncStateResponse> findBySyncStateSyncAt(
	SyncStateSyncAt value,
	MetaRequest metaRequest
	) {

	FindBySyncStateSyncAtQuery query = new FindBySyncStateSyncAtQuery(value,metaRequest);
	CompletableFuture<List<SyncStateResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SyncStateResponse.class));
	return future.join();
}
public List<SyncStateResponse> findBySyncStateLastSyncAt(
	SyncStateLastSyncAt value,
	MetaRequest metaRequest
	) {

	FindBySyncStateLastSyncAtQuery query = new FindBySyncStateLastSyncAtQuery(value,metaRequest);
	CompletableFuture<List<SyncStateResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SyncStateResponse.class));
	return future.join();
}
public List<SyncStateResponse> findBySyncStateLastCursor(
	SyncStateLastCursor value,
	MetaRequest metaRequest
	) {

	FindBySyncStateLastCursorQuery query = new FindBySyncStateLastCursorQuery(value,metaRequest);
	CompletableFuture<List<SyncStateResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SyncStateResponse.class));
	return future.join();
}
public List<SyncStateResponse> findBySyncStateCreatedBy(
	SyncStateCreatedBy value,
	MetaRequest metaRequest
	) {

	FindBySyncStateCreatedByQuery query = new FindBySyncStateCreatedByQuery(value,metaRequest);
	CompletableFuture<List<SyncStateResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SyncStateResponse.class));
	return future.join();
}
public List<SyncStateResponse> findBySyncStateTenant(
	SyncStateTenant value,
	MetaRequest metaRequest
	) {

	FindBySyncStateTenantQuery query = new FindBySyncStateTenantQuery(value,metaRequest);
	CompletableFuture<List<SyncStateResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SyncStateResponse.class));
	return future.join();
}

}
