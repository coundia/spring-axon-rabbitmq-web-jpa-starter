package com.groupe2cs.bizyhub.message.application.usecase;

import com.groupe2cs.bizyhub.message.application.dto.MessagePagedResponse;
import com.groupe2cs.bizyhub.message.application.dto.MessageResponse;
import com.groupe2cs.bizyhub.message.application.query.*;
import com.groupe2cs.bizyhub.message.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class MessageReadApplicationService {

	private final QueryGateway queryGateway;


	public MessagePagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

		FindAllMessageQuery query = new FindAllMessageQuery(page, limit, metaRequest);
		CompletableFuture<MessagePagedResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(MessagePagedResponse.class));
		return future.join();
	}


	public MessageResponse findByMessageId(MessageId value, MetaRequest metaRequest) {

		FindByMessageIdQuery query = new FindByMessageIdQuery(value, metaRequest);
		CompletableFuture<MessageResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(MessageResponse.class));
		return future.join();
	}


	public List<MessageResponse> findByMessageCode(
			MessageCode value,
			MetaRequest metaRequest
	) {

		FindByMessageCodeQuery query = new FindByMessageCodeQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageEmail(
			MessageEmail value,
			MetaRequest metaRequest
	) {

		FindByMessageEmailQuery query = new FindByMessageEmailQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessagePhone(
			MessagePhone value,
			MetaRequest metaRequest
	) {

		FindByMessagePhoneQuery query = new FindByMessagePhoneQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageContent(
			MessageContent value,
			MetaRequest metaRequest
	) {

		FindByMessageContentQuery query = new FindByMessageContentQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessagePlateforme(
			MessagePlateforme value,
			MetaRequest metaRequest
	) {

		FindByMessagePlateformeQuery query = new FindByMessagePlateformeQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageSource(
			MessageSource value,
			MetaRequest metaRequest
	) {

		FindByMessageSourceQuery query = new FindByMessageSourceQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageAgent(
			MessageAgent value,
			MetaRequest metaRequest
	) {

		FindByMessageAgentQuery query = new FindByMessageAgentQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageStatus(
			MessageStatus value,
			MetaRequest metaRequest
	) {

		FindByMessageStatusQuery query = new FindByMessageStatusQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageDescription(
			MessageDescription value,
			MetaRequest metaRequest
	) {

		FindByMessageDescriptionQuery query = new FindByMessageDescriptionQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageIsActive(
			MessageIsActive value,
			MetaRequest metaRequest
	) {

		FindByMessageIsActiveQuery query = new FindByMessageIsActiveQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageIsDefault(
			MessageIsDefault value,
			MetaRequest metaRequest
	) {

		FindByMessageIsDefaultQuery query = new FindByMessageIsDefaultQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageRemoteId(
			MessageRemoteId value,
			MetaRequest metaRequest
	) {

		FindByMessageRemoteIdQuery query = new FindByMessageRemoteIdQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageLocalId(
			MessageLocalId value,
			MetaRequest metaRequest
	) {

		FindByMessageLocalIdQuery query = new FindByMessageLocalIdQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageDepotAt(
			MessageDepotAt value,
			MetaRequest metaRequest
	) {

		FindByMessageDepotAtQuery query = new FindByMessageDepotAtQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageSyncAt(
			MessageSyncAt value,
			MetaRequest metaRequest
	) {

		FindByMessageSyncAtQuery query = new FindByMessageSyncAtQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageCreatedBy(
			MessageCreatedBy value,
			MetaRequest metaRequest
	) {

		FindByMessageCreatedByQuery query = new FindByMessageCreatedByQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

	public List<MessageResponse> findByMessageTenant(
			MessageTenant value,
			MetaRequest metaRequest
	) {

		FindByMessageTenantQuery query = new FindByMessageTenantQuery(value, metaRequest);
		CompletableFuture<List<MessageResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(MessageResponse.class));
		return future.join();
	}

}
