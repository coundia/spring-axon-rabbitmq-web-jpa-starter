package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class RefreshTokenReadApplicationService {

	private final QueryGateway queryGateway;


	public RefreshTokenPagedResponse findAll(int page, int limit) {

		FindAllRefreshTokenQuery query = new FindAllRefreshTokenQuery(page, limit);
		CompletableFuture<RefreshTokenPagedResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(RefreshTokenPagedResponse.class));
		return future.join();
	}


	public RefreshTokenResponse findByRefreshTokenId(RefreshTokenId value) {

		FindByRefreshTokenIdQuery query = new FindByRefreshTokenIdQuery(value);
		CompletableFuture<RefreshTokenResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(RefreshTokenResponse.class));
		return future.join();
	}


	public List<RefreshTokenResponse> findByRefreshTokenToken(RefreshTokenToken value) {

		FindByRefreshTokenTokenQuery query = new FindByRefreshTokenTokenQuery(value);
		CompletableFuture<List<RefreshTokenResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RefreshTokenResponse.class));
		return future.join();
	}

	public List<RefreshTokenResponse> findByRefreshTokenUsername(RefreshTokenUsername value) {

		FindByRefreshTokenUsernameQuery query = new FindByRefreshTokenUsernameQuery(value);
		CompletableFuture<List<RefreshTokenResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RefreshTokenResponse.class));
		return future.join();
	}

	public List<RefreshTokenResponse> findByRefreshTokenExpiration(RefreshTokenExpiration value) {

		FindByRefreshTokenExpirationQuery query = new FindByRefreshTokenExpirationQuery(value);
		CompletableFuture<List<RefreshTokenResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RefreshTokenResponse.class));
		return future.join();
	}

	public List<RefreshTokenResponse> findByRefreshTokenCreatedBy(RefreshTokenCreatedBy value) {

		FindByRefreshTokenCreatedByQuery query = new FindByRefreshTokenCreatedByQuery(value);
		CompletableFuture<List<RefreshTokenResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RefreshTokenResponse.class));
		return future.join();
	}

}
