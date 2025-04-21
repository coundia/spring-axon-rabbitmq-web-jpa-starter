package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.dto.UserPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.query.FindAllUserQuery;
import com.groupe2cs.bizyhub.security.application.query.FindByUserIdQuery;
import com.groupe2cs.bizyhub.security.application.query.FindByUserPasswordQuery;
import com.groupe2cs.bizyhub.security.application.query.FindByUserUsernameQuery;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserPassword;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserUsername;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class UserReadApplicationService {

	private final QueryGateway queryGateway;


	public UserPagedResponse findAll(int page, int limit) {

		FindAllUserQuery query = new FindAllUserQuery(page, limit);
		CompletableFuture<UserPagedResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(UserPagedResponse.class));
		return future.join();
	}


	public UserResponse findByUserId(UserId value) {

		FindByUserIdQuery query = new FindByUserIdQuery(value);
		CompletableFuture<UserResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(UserResponse.class));
		return future.join();
	}


	public List<UserResponse> findByUserUsername(UserUsername value) {

		FindByUserUsernameQuery query = new FindByUserUsernameQuery(value);
		CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
		return future.join();
	}

	public List<UserResponse> findByUserPassword(UserPassword value) {

		FindByUserPasswordQuery query = new FindByUserPasswordQuery(value);
		CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
		return future.join();
	}

}
