package com.groupe2cs.bizyhub.categories.application.usecase;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.categories.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.categories.application.mapper.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CategoryReadApplicationService {

private final QueryGateway queryGateway;


public CategoryPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllCategoryQuery query = new FindAllCategoryQuery(page, limit,metaRequest);
	CompletableFuture<CategoryPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(CategoryPagedResponse.class));
	return future.join();
}


public CategoryResponse findByCategoryId(CategoryId value, MetaRequest metaRequest) {

	FindByCategoryIdQuery query = new FindByCategoryIdQuery(value,metaRequest);
	CompletableFuture<CategoryResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(CategoryResponse.class));
	return future.join();
}


public List<CategoryResponse> findByCategoryCode(
	CategoryCode value,
	MetaRequest metaRequest
	) {

	FindByCategoryCodeQuery query = new FindByCategoryCodeQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryName(
	CategoryName value,
	MetaRequest metaRequest
	) {

	FindByCategoryNameQuery query = new FindByCategoryNameQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryRemoteId(
	CategoryRemoteId value,
	MetaRequest metaRequest
	) {

	FindByCategoryRemoteIdQuery query = new FindByCategoryRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryLocalId(
	CategoryLocalId value,
	MetaRequest metaRequest
	) {

	FindByCategoryLocalIdQuery query = new FindByCategoryLocalIdQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryAccount(
	CategoryAccount value,
	MetaRequest metaRequest
	) {

	FindByCategoryAccountQuery query = new FindByCategoryAccountQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryDescription(
	CategoryDescription value,
	MetaRequest metaRequest
	) {

	FindByCategoryDescriptionQuery query = new FindByCategoryDescriptionQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryTypeEntry(
	CategoryTypeEntry value,
	MetaRequest metaRequest
	) {

	FindByCategoryTypeEntryQuery query = new FindByCategoryTypeEntryQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryVersion(
	CategoryVersion value,
	MetaRequest metaRequest
	) {

	FindByCategoryVersionQuery query = new FindByCategoryVersionQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategorySyncAt(
	CategorySyncAt value,
	MetaRequest metaRequest
	) {

	FindByCategorySyncAtQuery query = new FindByCategorySyncAtQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryCreatedBy(
	CategoryCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByCategoryCreatedByQuery query = new FindByCategoryCreatedByQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryTenant(
	CategoryTenant value,
	MetaRequest metaRequest
	) {

	FindByCategoryTenantQuery query = new FindByCategoryTenantQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}

}
