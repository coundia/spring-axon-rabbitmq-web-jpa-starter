package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.application.query.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.accounts.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AccountUserReadApplicationService {

private final QueryGateway queryGateway;


public AccountUserPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllAccountUserQuery query = new FindAllAccountUserQuery(page, limit,metaRequest);
	CompletableFuture<AccountUserPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(AccountUserPagedResponse.class));
	return future.join();
}


public AccountUserResponse findByAccountUserId(AccountUserId value, MetaRequest metaRequest) {

	FindByAccountUserIdQuery query = new FindByAccountUserIdQuery(value,metaRequest);
	CompletableFuture<AccountUserResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(AccountUserResponse.class));
	return future.join();
}


public List<AccountUserResponse> findByAccountUserName(
	AccountUserName value,
	MetaRequest metaRequest
	) {

	FindByAccountUserNameQuery query = new FindByAccountUserNameQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserAccount(
	AccountUserAccount value,
	MetaRequest metaRequest
	) {

	FindByAccountUserAccountQuery query = new FindByAccountUserAccountQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserUser(
	AccountUserUser value,
	MetaRequest metaRequest
	) {

	FindByAccountUserUserQuery query = new FindByAccountUserUserQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserUsername(
	AccountUserUsername value,
	MetaRequest metaRequest
	) {

	FindByAccountUserUsernameQuery query = new FindByAccountUserUsernameQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserDetails(
	AccountUserDetails value,
	MetaRequest metaRequest
	) {

	FindByAccountUserDetailsQuery query = new FindByAccountUserDetailsQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserIsActive(
	AccountUserIsActive value,
	MetaRequest metaRequest
	) {

	FindByAccountUserIsActiveQuery query = new FindByAccountUserIsActiveQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserCreatedBy(
	AccountUserCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByAccountUserCreatedByQuery query = new FindByAccountUserCreatedByQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserTenant(
	AccountUserTenant value,
	MetaRequest metaRequest
	) {

	FindByAccountUserTenantQuery query = new FindByAccountUserTenantQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}

}
