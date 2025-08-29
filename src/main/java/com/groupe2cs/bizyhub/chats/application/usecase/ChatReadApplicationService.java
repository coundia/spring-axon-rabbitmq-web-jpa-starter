package com.groupe2cs.bizyhub.chats.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.chats.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.chats.application.query.*;
import com.groupe2cs.bizyhub.chats.application.mapper.*;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ChatReadApplicationService {

private final QueryGateway queryGateway;


public ChatPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllChatQuery query = new FindAllChatQuery(page, limit,metaRequest);
	CompletableFuture<ChatPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(ChatPagedResponse.class));
	return future.join();
}


public ChatResponse findByChatId(ChatId value, MetaRequest metaRequest) {

	FindByChatIdQuery query = new FindByChatIdQuery(value,metaRequest);
	CompletableFuture<ChatResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(ChatResponse.class));
	return future.join();
}


public List<ChatResponse> findByChatMessages(
	ChatMessages value,
	MetaRequest metaRequest
	) {

	FindByChatMessagesQuery query = new FindByChatMessagesQuery(value,metaRequest);
	CompletableFuture<List<ChatResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChatResponse.class));
	return future.join();
}
public List<ChatResponse> findByChatResponsesJson(
	ChatResponsesJson value,
	MetaRequest metaRequest
	) {

	FindByChatResponsesJsonQuery query = new FindByChatResponsesJsonQuery(value,metaRequest);
	CompletableFuture<List<ChatResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChatResponse.class));
	return future.join();
}
public List<ChatResponse> findByChatResponses(
	ChatResponses value,
	MetaRequest metaRequest
	) {

	FindByChatResponsesQuery query = new FindByChatResponsesQuery(value,metaRequest);
	CompletableFuture<List<ChatResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChatResponse.class));
	return future.join();
}
public List<ChatResponse> findByChatState(
	ChatState value,
	MetaRequest metaRequest
	) {

	FindByChatStateQuery query = new FindByChatStateQuery(value,metaRequest);
	CompletableFuture<List<ChatResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChatResponse.class));
	return future.join();
}
public List<ChatResponse> findByChatSyncAt(
	ChatSyncAt value,
	MetaRequest metaRequest
	) {

	FindByChatSyncAtQuery query = new FindByChatSyncAtQuery(value,metaRequest);
	CompletableFuture<List<ChatResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChatResponse.class));
	return future.join();
}
public List<ChatResponse> findByChatRemoteId(
	ChatRemoteId value,
	MetaRequest metaRequest
	) {

	FindByChatRemoteIdQuery query = new FindByChatRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<ChatResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChatResponse.class));
	return future.join();
}
public List<ChatResponse> findByChatLocalId(
	ChatLocalId value,
	MetaRequest metaRequest
	) {

	FindByChatLocalIdQuery query = new FindByChatLocalIdQuery(value,metaRequest);
	CompletableFuture<List<ChatResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChatResponse.class));
	return future.join();
}
public List<ChatResponse> findByChatAccount(
	ChatAccount value,
	MetaRequest metaRequest
	) {

	FindByChatAccountQuery query = new FindByChatAccountQuery(value,metaRequest);
	CompletableFuture<List<ChatResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChatResponse.class));
	return future.join();
}
public List<ChatResponse> findByChatDateTransaction(
	ChatDateTransaction value,
	MetaRequest metaRequest
	) {

	FindByChatDateTransactionQuery query = new FindByChatDateTransactionQuery(value,metaRequest);
	CompletableFuture<List<ChatResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChatResponse.class));
	return future.join();
}
public List<ChatResponse> findByChatCreatedBy(
	ChatCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByChatCreatedByQuery query = new FindByChatCreatedByQuery(value,metaRequest);
	CompletableFuture<List<ChatResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChatResponse.class));
	return future.join();
}
public List<ChatResponse> findByChatTenant(
	ChatTenant value,
	MetaRequest metaRequest
	) {

	FindByChatTenantQuery query = new FindByChatTenantQuery(value,metaRequest);
	CompletableFuture<List<ChatResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ChatResponse.class));
	return future.join();
}

}
