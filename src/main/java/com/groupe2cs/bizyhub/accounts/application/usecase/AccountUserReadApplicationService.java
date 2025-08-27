package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.accounts.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.application.query.*;
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
public List<AccountUserResponse> findByAccountUserIdentity(
	AccountUserIdentity value,
	MetaRequest metaRequest
	) {

	FindByAccountUserIdentityQuery query = new FindByAccountUserIdentityQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserPhone(
	AccountUserPhone value,
	MetaRequest metaRequest
	) {

	FindByAccountUserPhoneQuery query = new FindByAccountUserPhoneQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserEmail(
	AccountUserEmail value,
	MetaRequest metaRequest
	) {

	FindByAccountUserEmailQuery query = new FindByAccountUserEmailQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserRole(
	AccountUserRole value,
	MetaRequest metaRequest
	) {

	FindByAccountUserRoleQuery query = new FindByAccountUserRoleQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserStatus(
	AccountUserStatus value,
	MetaRequest metaRequest
	) {

	FindByAccountUserStatusQuery query = new FindByAccountUserStatusQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserInvitedBy(
	AccountUserInvitedBy value,
	MetaRequest metaRequest
	) {

	FindByAccountUserInvitedByQuery query = new FindByAccountUserInvitedByQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserSyncAt(
	AccountUserSyncAt value,
	MetaRequest metaRequest
	) {

	FindByAccountUserSyncAtQuery query = new FindByAccountUserSyncAtQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserAcceptedAt(
	AccountUserAcceptedAt value,
	MetaRequest metaRequest
	) {

	FindByAccountUserAcceptedAtQuery query = new FindByAccountUserAcceptedAtQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserRevokedAt(
	AccountUserRevokedAt value,
	MetaRequest metaRequest
	) {

	FindByAccountUserRevokedAtQuery query = new FindByAccountUserRevokedAtQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserMessage(
	AccountUserMessage value,
	MetaRequest metaRequest
	) {

	FindByAccountUserMessageQuery query = new FindByAccountUserMessageQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserRemoteId(
	AccountUserRemoteId value,
	MetaRequest metaRequest
	) {

	FindByAccountUserRemoteIdQuery query = new FindByAccountUserRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<AccountUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountUserResponse.class));
	return future.join();
}
public List<AccountUserResponse> findByAccountUserLocalId(
	AccountUserLocalId value,
	MetaRequest metaRequest
	) {

	FindByAccountUserLocalIdQuery query = new FindByAccountUserLocalIdQuery(value,metaRequest);
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
