package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class UserReadApplicationService {

private final QueryGateway queryGateway;


public UserPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllUserQuery query = new FindAllUserQuery(page, limit,metaRequest);
	CompletableFuture<UserPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(UserPagedResponse.class));
	return future.join();
}


public UserResponse findByUserId(UserId value, MetaRequest metaRequest) {

	FindByUserIdQuery query = new FindByUserIdQuery(value,metaRequest);
	CompletableFuture<UserResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(UserResponse.class));
	return future.join();
}


public List<UserResponse> findByUserUsername(
	UserUsername value,
	MetaRequest metaRequest
	) {

	FindByUserUsernameQuery query = new FindByUserUsernameQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}
public List<UserResponse> findByUserPassword(
	UserPassword value,
	MetaRequest metaRequest
	) {

	FindByUserPasswordQuery query = new FindByUserPasswordQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}
public List<UserResponse> findByUserFirstName(
	UserFirstName value,
	MetaRequest metaRequest
	) {

	FindByUserFirstNameQuery query = new FindByUserFirstNameQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}
public List<UserResponse> findByUserLastName(
	UserLastName value,
	MetaRequest metaRequest
	) {

	FindByUserLastNameQuery query = new FindByUserLastNameQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}
public List<UserResponse> findByUserEmail(
	UserEmail value,
	MetaRequest metaRequest
	) {

	FindByUserEmailQuery query = new FindByUserEmailQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}
public List<UserResponse> findByUserTelephone(
	UserTelephone value,
	MetaRequest metaRequest
	) {

	FindByUserTelephoneQuery query = new FindByUserTelephoneQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}
public List<UserResponse> findByUserLimitPerDay(
	UserLimitPerDay value,
	MetaRequest metaRequest
	) {

	FindByUserLimitPerDayQuery query = new FindByUserLimitPerDayQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}
public List<UserResponse> findByUserIsPremium(
	UserIsPremium value,
	MetaRequest metaRequest
	) {

	FindByUserIsPremiumQuery query = new FindByUserIsPremiumQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}
public List<UserResponse> findByUserEnabled(
	UserEnabled value,
	MetaRequest metaRequest
	) {

	FindByUserEnabledQuery query = new FindByUserEnabledQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}
public List<UserResponse> findByUserIsBan(
	UserIsBan value,
	MetaRequest metaRequest
	) {

	FindByUserIsBanQuery query = new FindByUserIsBanQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}
public List<UserResponse> findByUserMessage(
	UserMessage value,
	MetaRequest metaRequest
	) {

	FindByUserMessageQuery query = new FindByUserMessageQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}
public List<UserResponse> findByUserCreatedBy(
	UserCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByUserCreatedByQuery query = new FindByUserCreatedByQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}
public List<UserResponse> findByUserTenant(
	UserTenant value,
	MetaRequest metaRequest
	) {

	FindByUserTenantQuery query = new FindByUserTenantQuery(value,metaRequest);
	CompletableFuture<List<UserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserResponse.class));
	return future.join();
}

}
