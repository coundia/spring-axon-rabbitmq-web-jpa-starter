package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class PermissionReadApplicationService {

private final QueryGateway queryGateway;


public PermissionPagedResponse findAll(int page, int limit) {

	FindAllPermissionQuery query = new FindAllPermissionQuery(page, limit);
	CompletableFuture<PermissionPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(PermissionPagedResponse.class));
	return future.join();
}


public PermissionResponse findByPermissionId(PermissionId value) {

	FindByPermissionIdQuery query = new FindByPermissionIdQuery(value);
	CompletableFuture<PermissionResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(PermissionResponse.class));
	return future.join();
}


public List<PermissionResponse> findByPermissionName(PermissionName value) {

	FindByPermissionNameQuery query = new FindByPermissionNameQuery(value);
	CompletableFuture<List<PermissionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(PermissionResponse.class));
	return future.join();
}

}
