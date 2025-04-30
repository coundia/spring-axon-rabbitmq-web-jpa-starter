package com.groupe2cs.bizyhub.balances.application.usecase;

import com.groupe2cs.bizyhub.balances.application.dto.BalancePagedResponse;
import com.groupe2cs.bizyhub.balances.application.dto.BalanceResponse;
import com.groupe2cs.bizyhub.balances.application.query.*;
import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class BalanceReadApplicationService {

	private final QueryGateway queryGateway;


	public BalancePagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

		FindAllBalanceQuery query = new FindAllBalanceQuery(page, limit, metaRequest);
		CompletableFuture<BalancePagedResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(BalancePagedResponse.class));
		return future.join();
	}


	public BalanceResponse findByBalanceId(BalanceId value, MetaRequest metaRequest) {

		FindByBalanceIdQuery query = new FindByBalanceIdQuery(value, metaRequest);
		CompletableFuture<BalanceResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(BalanceResponse.class));
		return future.join();
	}


	public List<BalanceResponse> findByBalanceName(
			BalanceName value,
			MetaRequest metaRequest
	) {

		FindByBalanceNameQuery query = new FindByBalanceNameQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceCurrency(
			BalanceCurrency value,
			MetaRequest metaRequest
	) {

		FindByBalanceCurrencyQuery query = new FindByBalanceCurrencyQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceCurrentBalance(
			BalanceCurrentBalance value,
			MetaRequest metaRequest
	) {

		FindByBalanceCurrentBalanceQuery query = new FindByBalanceCurrentBalanceQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalancePreviousBalance(
			BalancePreviousBalance value,
			MetaRequest metaRequest
	) {

		FindByBalancePreviousBalanceQuery query = new FindByBalancePreviousBalanceQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceLastUpdated(
			BalanceLastUpdated value,
			MetaRequest metaRequest
	) {

		FindByBalanceLastUpdatedQuery query = new FindByBalanceLastUpdatedQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceIsDefault(
			BalanceIsDefault value,
			MetaRequest metaRequest
	) {

		FindByBalanceIsDefaultQuery query = new FindByBalanceIsDefaultQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceOrdre(
			BalanceOrdre value,
			MetaRequest metaRequest
	) {

		FindByBalanceOrdreQuery query = new FindByBalanceOrdreQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceIsArchived(
			BalanceIsArchived value,
			MetaRequest metaRequest
	) {

		FindByBalanceIsArchivedQuery query = new FindByBalanceIsArchivedQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceIsAllowDebit(
			BalanceIsAllowDebit value,
			MetaRequest metaRequest
	) {

		FindByBalanceIsAllowDebitQuery query = new FindByBalanceIsAllowDebitQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceIsAllowCredit(
			BalanceIsAllowCredit value,
			MetaRequest metaRequest
	) {

		FindByBalanceIsAllowCreditQuery query = new FindByBalanceIsAllowCreditQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceIsExcluTotal(
			BalanceIsExcluTotal value,
			MetaRequest metaRequest
	) {

		FindByBalanceIsExcluTotalQuery query = new FindByBalanceIsExcluTotalQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceActivateNotification(
			BalanceActivateNotification value,
			MetaRequest metaRequest
	) {

		FindByBalanceActivateNotificationQuery query = new FindByBalanceActivateNotificationQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceSyncedAt(
			BalanceSyncedAt value,
			MetaRequest metaRequest
	) {

		FindByBalanceSyncedAtQuery query = new FindByBalanceSyncedAtQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceCreatedBy(
			BalanceCreatedBy value,
			MetaRequest metaRequest
	) {

		FindByBalanceCreatedByQuery query = new FindByBalanceCreatedByQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

	public List<BalanceResponse> findByBalanceTenant(
			BalanceTenant value,
			MetaRequest metaRequest
	) {

		FindByBalanceTenantQuery query = new FindByBalanceTenantQuery(value, metaRequest);
		CompletableFuture<List<BalanceResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(BalanceResponse.class));
		return future.join();
	}

}
