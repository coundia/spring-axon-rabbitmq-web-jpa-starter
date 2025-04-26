package com.groupe2cs.bizyhub.tenant.application.usecase;

import com.groupe2cs.bizyhub.tenant.application.dto.TenantPagedResponse;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.application.query.*;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TenantReadApplicationService {

	private final QueryGateway queryGateway;


	public TenantPagedResponse findAll(int page, int limit) {

		FindAllTenantQuery query = new FindAllTenantQuery(page, limit);
		CompletableFuture<TenantPagedResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TenantPagedResponse.class));
		return future.join();
	}


	public TenantResponse findByTenantId(TenantId value) {

		FindByTenantIdQuery query = new FindByTenantIdQuery(value);
		CompletableFuture<TenantResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TenantResponse.class));
		return future.join();
	}


	public List<TenantResponse> findByTenantName(TenantName value) {

		FindByTenantNameQuery query = new FindByTenantNameQuery(value);
		CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
		return future.join();
	}

	public List<TenantResponse> findByTenantDescription(TenantDescription value) {

		FindByTenantDescriptionQuery query = new FindByTenantDescriptionQuery(value);
		CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
		return future.join();
	}

	public List<TenantResponse> findByTenantDomain(TenantDomain value) {

		FindByTenantDomainQuery query = new FindByTenantDomainQuery(value);
		CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
		return future.join();
	}

	public List<TenantResponse> findByTenantLanguage(TenantLanguage value) {

		FindByTenantLanguageQuery query = new FindByTenantLanguageQuery(value);
		CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
		return future.join();
	}

	public List<TenantResponse> findByTenantActive(TenantActive value) {

		FindByTenantActiveQuery query = new FindByTenantActiveQuery(value);
		CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
		return future.join();
	}

	public List<TenantResponse> findByTenantCreatedBy(TenantCreatedBy value) {

		FindByTenantCreatedByQuery query = new FindByTenantCreatedByQuery(value);
		CompletableFuture<List<TenantResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TenantResponse.class));
		return future.join();
	}

}
