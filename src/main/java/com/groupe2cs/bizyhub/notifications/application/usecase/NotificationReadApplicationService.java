package com.groupe2cs.bizyhub.notifications.application.usecase;

import com.groupe2cs.bizyhub.notifications.application.dto.NotificationPagedResponse;
import com.groupe2cs.bizyhub.notifications.application.dto.NotificationResponse;
import com.groupe2cs.bizyhub.notifications.application.query.*;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class NotificationReadApplicationService {

	private final QueryGateway queryGateway;


	public NotificationPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

		FindAllNotificationQuery query = new FindAllNotificationQuery(page, limit, metaRequest);
		CompletableFuture<NotificationPagedResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(NotificationPagedResponse.class));
		return future.join();
	}


	public NotificationResponse findByNotificationId(NotificationId value, MetaRequest metaRequest) {

		FindByNotificationIdQuery query = new FindByNotificationIdQuery(value, metaRequest);
		CompletableFuture<NotificationResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(NotificationResponse.class));
		return future.join();
	}


	public List<NotificationResponse> findByNotificationDeviceToken(
			NotificationDeviceToken value,
			MetaRequest metaRequest
	) {

		FindByNotificationDeviceTokenQuery query = new FindByNotificationDeviceTokenQuery(value, metaRequest);
		CompletableFuture<List<NotificationResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(NotificationResponse.class));
		return future.join();
	}

	public List<NotificationResponse> findByNotificationTitle(
			NotificationTitle value,
			MetaRequest metaRequest
	) {

		FindByNotificationTitleQuery query = new FindByNotificationTitleQuery(value, metaRequest);
		CompletableFuture<List<NotificationResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(NotificationResponse.class));
		return future.join();
	}

	public List<NotificationResponse> findByNotificationMessage(
			NotificationMessage value,
			MetaRequest metaRequest
	) {

		FindByNotificationMessageQuery query = new FindByNotificationMessageQuery(value, metaRequest);
		CompletableFuture<List<NotificationResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(NotificationResponse.class));
		return future.join();
	}

	public List<NotificationResponse> findByNotificationStatus(
			NotificationStatus value,
			MetaRequest metaRequest
	) {

		FindByNotificationStatusQuery query = new FindByNotificationStatusQuery(value, metaRequest);
		CompletableFuture<List<NotificationResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(NotificationResponse.class));
		return future.join();
	}

	public List<NotificationResponse> findByNotificationReserved(
			NotificationReserved value,
			MetaRequest metaRequest
	) {

		FindByNotificationReservedQuery query = new FindByNotificationReservedQuery(value, metaRequest);
		CompletableFuture<List<NotificationResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(NotificationResponse.class));
		return future.join();
	}

	public List<NotificationResponse> findByNotificationErrorMessage(
			NotificationErrorMessage value,
			MetaRequest metaRequest
	) {

		FindByNotificationErrorMessageQuery query = new FindByNotificationErrorMessageQuery(value, metaRequest);
		CompletableFuture<List<NotificationResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(NotificationResponse.class));
		return future.join();
	}

	public List<NotificationResponse> findByNotificationCreatedBy(
			NotificationCreatedBy value,
			MetaRequest metaRequest
	) {

		FindByNotificationCreatedByQuery query = new FindByNotificationCreatedByQuery(value, metaRequest);
		CompletableFuture<List<NotificationResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(NotificationResponse.class));
		return future.join();
	}

	public List<NotificationResponse> findByNotificationTenant(
			NotificationTenant value,
			MetaRequest metaRequest
	) {

		FindByNotificationTenantQuery query = new FindByNotificationTenantQuery(value, metaRequest);
		CompletableFuture<List<NotificationResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(NotificationResponse.class));
		return future.join();
	}

}
