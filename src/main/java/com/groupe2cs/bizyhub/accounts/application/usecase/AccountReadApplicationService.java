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


public List<AccountResponse> findByAccountName(
	AccountName value,
	MetaRequest metaRequest
	) {

	FindByAccountNameQuery query = new FindByAccountNameQuery(value,metaRequest);
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
public List<AccountResponse> findByAccountCurrentBalance(
	AccountCurrentBalance value,
	MetaRequest metaRequest
	) {

	FindByAccountCurrentBalanceQuery query = new FindByAccountCurrentBalanceQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountPreviousBalance(
	AccountPreviousBalance value,
	MetaRequest metaRequest
	) {

	FindByAccountPreviousBalanceQuery query = new FindByAccountPreviousBalanceQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountDetails(
	AccountDetails value,
	MetaRequest metaRequest
	) {

	FindByAccountDetailsQuery query = new FindByAccountDetailsQuery(value,metaRequest);
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
public List<AccountResponse> findByAccountUpdatedAt(
	AccountUpdatedAt value,
	MetaRequest metaRequest
	) {

	FindByAccountUpdatedAtQuery query = new FindByAccountUpdatedAtQuery(value,metaRequest);
	CompletableFuture<List<AccountResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(AccountResponse.class));
	return future.join();
}
public List<AccountResponse> findByAccountReference(
	AccountReference value,
	MetaRequest metaRequest
	) {

	FindByAccountReferenceQuery query = new FindByAccountReferenceQuery(value,metaRequest);
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
