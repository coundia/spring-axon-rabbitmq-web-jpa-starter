package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.application.query.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.accounts.application.mapper.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AccountReadApplicationService {

private final QueryGateway queryGateway;


public AccountPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllAccountQuery query = new FindAllAccountQuery(page, limit,metaRequest);
	CompletableFuture<AccountPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(AccountPagedResponse.class));
	return future.join();
}


public AccountResponse findByAccountId(AccountId value, MetaRequest metaRequest) {

	FindByAccountIdQuery query = new FindByAccountIdQuery(value,metaRequest);
	CompletableFuture<AccountResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(AccountResponse.class));
	return future.join();
}


public List<AccountResponse> findByAccountCode(
	AccountCode value,
	MetaRequest metaRequest
	) {

	FindByAccountCodeQuery query = new FindByAccountCodeQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountName(
	AccountName value,
	MetaRequest metaRequest
	) {

	FindByAccountNameQuery query = new FindByAccountNameQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountStatus(
	AccountStatus value,
	MetaRequest metaRequest
	) {

	FindByAccountStatusQuery query = new FindByAccountStatusQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountCurrency(
	AccountCurrency value,
	MetaRequest metaRequest
	) {

	FindByAccountCurrencyQuery query = new FindByAccountCurrencyQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountTypeAccount(
	AccountTypeAccount value,
	MetaRequest metaRequest
	) {

	FindByAccountTypeAccountQuery query = new FindByAccountTypeAccountQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountBalance(
	AccountBalance value,
	MetaRequest metaRequest
	) {

	FindByAccountBalanceQuery query = new FindByAccountBalanceQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountBalancePrev(
	AccountBalancePrev value,
	MetaRequest metaRequest
	) {

	FindByAccountBalancePrevQuery query = new FindByAccountBalancePrevQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountBalanceBlocked(
	AccountBalanceBlocked value,
	MetaRequest metaRequest
	) {

	FindByAccountBalanceBlockedQuery query = new FindByAccountBalanceBlockedQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountBalanceInit(
	AccountBalanceInit value,
	MetaRequest metaRequest
	) {

	FindByAccountBalanceInitQuery query = new FindByAccountBalanceInitQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountBalanceGoal(
	AccountBalanceGoal value,
	MetaRequest metaRequest
	) {

	FindByAccountBalanceGoalQuery query = new FindByAccountBalanceGoalQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountBalanceLimit(
	AccountBalanceLimit value,
	MetaRequest metaRequest
	) {

	FindByAccountBalanceLimitQuery query = new FindByAccountBalanceLimitQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountDescription(
	AccountDescription value,
	MetaRequest metaRequest
	) {

	FindByAccountDescriptionQuery query = new FindByAccountDescriptionQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountIsActive(
	AccountIsActive value,
	MetaRequest metaRequest
	) {

	FindByAccountIsActiveQuery query = new FindByAccountIsActiveQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountIsDefault(
	AccountIsDefault value,
	MetaRequest metaRequest
	) {

	FindByAccountIsDefaultQuery query = new FindByAccountIsDefaultQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountSyncAt(
	AccountSyncAt value,
	MetaRequest metaRequest
	) {

	FindByAccountSyncAtQuery query = new FindByAccountSyncAtQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountCreatedBy(
	AccountCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByAccountCreatedByQuery query = new FindByAccountCreatedByQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountTenant(
	AccountTenant value,
	MetaRequest metaRequest
	) {

	FindByAccountTenantQuery query = new FindByAccountTenantQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}

}
