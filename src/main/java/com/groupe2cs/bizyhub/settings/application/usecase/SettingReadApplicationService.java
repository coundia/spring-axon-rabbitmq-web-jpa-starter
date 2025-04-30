package com.groupe2cs.bizyhub.settings.application.usecase;

import com.groupe2cs.bizyhub.settings.application.dto.SettingPagedResponse;
import com.groupe2cs.bizyhub.settings.application.dto.SettingResponse;
import com.groupe2cs.bizyhub.settings.application.query.*;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class SettingReadApplicationService {

	private final QueryGateway queryGateway;


	public SettingPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

		FindAllSettingQuery query = new FindAllSettingQuery(page, limit, metaRequest);
		CompletableFuture<SettingPagedResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(SettingPagedResponse.class));
		return future.join();
	}


	public SettingResponse findBySettingId(SettingId value, MetaRequest metaRequest) {

		FindBySettingIdQuery query = new FindBySettingIdQuery(value, metaRequest);
		CompletableFuture<SettingResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(SettingResponse.class));
		return future.join();
	}


	public List<SettingResponse> findBySettingName(
			SettingName value,
			MetaRequest metaRequest
	) {

		FindBySettingNameQuery query = new FindBySettingNameQuery(value, metaRequest);
		CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
		return future.join();
	}

	public List<SettingResponse> findBySettingStringValue(
			SettingStringValue value,
			MetaRequest metaRequest
	) {

		FindBySettingStringValueQuery query = new FindBySettingStringValueQuery(value, metaRequest);
		CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
		return future.join();
	}

	public List<SettingResponse> findBySettingDescription(
			SettingDescription value,
			MetaRequest metaRequest
	) {

		FindBySettingDescriptionQuery query = new FindBySettingDescriptionQuery(value, metaRequest);
		CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
		return future.join();
	}

	public List<SettingResponse> findBySettingIsActive(
			SettingIsActive value,
			MetaRequest metaRequest
	) {

		FindBySettingIsActiveQuery query = new FindBySettingIsActiveQuery(value, metaRequest);
		CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
		return future.join();
	}

	public List<SettingResponse> findBySettingCreatedBy(
			SettingCreatedBy value,
			MetaRequest metaRequest
	) {

		FindBySettingCreatedByQuery query = new FindBySettingCreatedByQuery(value, metaRequest);
		CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
		return future.join();
	}

	public List<SettingResponse> findBySettingTenant(
			SettingTenant value,
			MetaRequest metaRequest
	) {

		FindBySettingTenantQuery query = new FindBySettingTenantQuery(value, metaRequest);
		CompletableFuture<List<SettingResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SettingResponse.class));
		return future.join();
	}

}
