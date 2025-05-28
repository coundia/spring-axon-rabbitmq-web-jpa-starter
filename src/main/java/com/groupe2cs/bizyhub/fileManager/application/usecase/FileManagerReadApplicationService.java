package com.groupe2cs.bizyhub.fileManager.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.fileManager.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.fileManager.application.query.*;
import com.groupe2cs.bizyhub.fileManager.application.mapper.*;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class FileManagerReadApplicationService {

private final QueryGateway queryGateway;


public FileManagerPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllFileManagerQuery query = new FindAllFileManagerQuery(page, limit,metaRequest);
	CompletableFuture<FileManagerPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(FileManagerPagedResponse.class));
	return future.join();
}


public FileManagerResponse findByFileManagerId(FileManagerId value, MetaRequest metaRequest) {

	FindByFileManagerIdQuery query = new FindByFileManagerIdQuery(value,metaRequest);
	CompletableFuture<FileManagerResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(FileManagerResponse.class));
	return future.join();
}


public List<FileManagerResponse> findByFileManagerName(
	FileManagerName value,
	MetaRequest metaRequest
	) {

	FindByFileManagerNameQuery query = new FindByFileManagerNameQuery(value,metaRequest);
	CompletableFuture<List<FileManagerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(FileManagerResponse.class));
	return future.join();
}
public List<FileManagerResponse> findByFileManagerDetails(
	FileManagerDetails value,
	MetaRequest metaRequest
	) {

	FindByFileManagerDetailsQuery query = new FindByFileManagerDetailsQuery(value,metaRequest);
	CompletableFuture<List<FileManagerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(FileManagerResponse.class));
	return future.join();
}
public List<FileManagerResponse> findByFileManagerObjectId(
	FileManagerObjectId value,
	MetaRequest metaRequest
	) {

	FindByFileManagerObjectIdQuery query = new FindByFileManagerObjectIdQuery(value,metaRequest);
	CompletableFuture<List<FileManagerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(FileManagerResponse.class));
	return future.join();
}
public List<FileManagerResponse> findByFileManagerObjectName(
	FileManagerObjectName value,
	MetaRequest metaRequest
	) {

	FindByFileManagerObjectNameQuery query = new FindByFileManagerObjectNameQuery(value,metaRequest);
	CompletableFuture<List<FileManagerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(FileManagerResponse.class));
	return future.join();
}
public List<FileManagerResponse> findByFileManagerOriginalName(
	FileManagerOriginalName value,
	MetaRequest metaRequest
	) {

	FindByFileManagerOriginalNameQuery query = new FindByFileManagerOriginalNameQuery(value,metaRequest);
	CompletableFuture<List<FileManagerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(FileManagerResponse.class));
	return future.join();
}
public List<FileManagerResponse> findByFileManagerMimeType(
	FileManagerMimeType value,
	MetaRequest metaRequest
	) {

	FindByFileManagerMimeTypeQuery query = new FindByFileManagerMimeTypeQuery(value,metaRequest);
	CompletableFuture<List<FileManagerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(FileManagerResponse.class));
	return future.join();
}
public List<FileManagerResponse> findByFileManagerSize(
	FileManagerSize value,
	MetaRequest metaRequest
	) {

	FindByFileManagerSizeQuery query = new FindByFileManagerSizeQuery(value,metaRequest);
	CompletableFuture<List<FileManagerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(FileManagerResponse.class));
	return future.join();
}
public List<FileManagerResponse> findByFileManagerPath(
	FileManagerPath value,
	MetaRequest metaRequest
	) {

	FindByFileManagerPathQuery query = new FindByFileManagerPathQuery(value,metaRequest);
	CompletableFuture<List<FileManagerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(FileManagerResponse.class));
	return future.join();
}
public List<FileManagerResponse> findByFileManagerUri(
	FileManagerUri value,
	MetaRequest metaRequest
	) {

	FindByFileManagerUriQuery query = new FindByFileManagerUriQuery(value,metaRequest);
	CompletableFuture<List<FileManagerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(FileManagerResponse.class));
	return future.join();
}
public List<FileManagerResponse> findByFileManagerIsPublic(
	FileManagerIsPublic value,
	MetaRequest metaRequest
	) {

	FindByFileManagerIsPublicQuery query = new FindByFileManagerIsPublicQuery(value,metaRequest);
	CompletableFuture<List<FileManagerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(FileManagerResponse.class));
	return future.join();
}
public List<FileManagerResponse> findByFileManagerCreatedBy(
	FileManagerCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByFileManagerCreatedByQuery query = new FindByFileManagerCreatedByQuery(value,metaRequest);
	CompletableFuture<List<FileManagerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(FileManagerResponse.class));
	return future.join();
}
public List<FileManagerResponse> findByFileManagerTenant(
	FileManagerTenant value,
	MetaRequest metaRequest
	) {

	FindByFileManagerTenantQuery query = new FindByFileManagerTenantQuery(value,metaRequest);
	CompletableFuture<List<FileManagerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(FileManagerResponse.class));
	return future.join();
}

}
