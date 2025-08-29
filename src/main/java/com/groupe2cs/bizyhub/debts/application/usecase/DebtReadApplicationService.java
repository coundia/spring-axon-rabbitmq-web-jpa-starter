package com.groupe2cs.bizyhub.debts.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.debts.application.dto.*;
import com.groupe2cs.bizyhub.debts.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import com.groupe2cs.bizyhub.debts.application.mapper.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class DebtReadApplicationService {

private final QueryGateway queryGateway;


public DebtPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllDebtQuery query = new FindAllDebtQuery(page, limit,metaRequest);
	CompletableFuture<DebtPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(DebtPagedResponse.class));
	return future.join();
}


public DebtResponse findByDebtId(DebtId value, MetaRequest metaRequest) {

	FindByDebtIdQuery query = new FindByDebtIdQuery(value,metaRequest);
	CompletableFuture<DebtResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(DebtResponse.class));
	return future.join();
}


public List<DebtResponse> findByDebtRemoteId(
	DebtRemoteId value,
	MetaRequest metaRequest
	) {

	FindByDebtRemoteIdQuery query = new FindByDebtRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtLocalId(
	DebtLocalId value,
	MetaRequest metaRequest
	) {

	FindByDebtLocalIdQuery query = new FindByDebtLocalIdQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtCode(
	DebtCode value,
	MetaRequest metaRequest
	) {

	FindByDebtCodeQuery query = new FindByDebtCodeQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtNotes(
	DebtNotes value,
	MetaRequest metaRequest
	) {

	FindByDebtNotesQuery query = new FindByDebtNotesQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtBalance(
	DebtBalance value,
	MetaRequest metaRequest
	) {

	FindByDebtBalanceQuery query = new FindByDebtBalanceQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtBalanceDebt(
	DebtBalanceDebt value,
	MetaRequest metaRequest
	) {

	FindByDebtBalanceDebtQuery query = new FindByDebtBalanceDebtQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtDueDate(
	DebtDueDate value,
	MetaRequest metaRequest
	) {

	FindByDebtDueDateQuery query = new FindByDebtDueDateQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtStatuses(
	DebtStatuses value,
	MetaRequest metaRequest
	) {

	FindByDebtStatusesQuery query = new FindByDebtStatusesQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtAccount(
	DebtAccount value,
	MetaRequest metaRequest
	) {

	FindByDebtAccountQuery query = new FindByDebtAccountQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtSyncAt(
	DebtSyncAt value,
	MetaRequest metaRequest
	) {

	FindByDebtSyncAtQuery query = new FindByDebtSyncAtQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtCustomer(
	DebtCustomer value,
	MetaRequest metaRequest
	) {

	FindByDebtCustomerQuery query = new FindByDebtCustomerQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtIsActive(
	DebtIsActive value,
	MetaRequest metaRequest
	) {

	FindByDebtIsActiveQuery query = new FindByDebtIsActiveQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtCreatedBy(
	DebtCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByDebtCreatedByQuery query = new FindByDebtCreatedByQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}
public List<DebtResponse> findByDebtTenant(
	DebtTenant value,
	MetaRequest metaRequest
	) {

	FindByDebtTenantQuery query = new FindByDebtTenantQuery(value,metaRequest);
	CompletableFuture<List<DebtResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(DebtResponse.class));
	return future.join();
}

}
