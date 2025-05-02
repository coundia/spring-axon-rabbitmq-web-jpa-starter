package com.groupe2cs.bizyhub.categories.application.usecase;

import com.groupe2cs.bizyhub.categories.application.query.*;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.categories.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
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


public List<CategoryResponse> findByCategoryReference(
	CategoryReference value,
	MetaRequest metaRequest
	) {

	FindByCategoryReferenceQuery query = new FindByCategoryReferenceQuery(value,metaRequest);
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
public List<CategoryResponse> findByCategoryUpdatedAt(
	CategoryUpdatedAt value,
	MetaRequest metaRequest
	) {

	FindByCategoryUpdatedAtQuery query = new FindByCategoryUpdatedAtQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryTypeCategory(
	CategoryTypeCategory value,
	MetaRequest metaRequest
	) {

	FindByCategoryTypeCategoryQuery query = new FindByCategoryTypeCategoryQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryParentId(
	CategoryParentId value,
	MetaRequest metaRequest
	) {

	FindByCategoryParentIdQuery query = new FindByCategoryParentIdQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryIsDefault(
	CategoryIsDefault value,
	MetaRequest metaRequest
	) {

	FindByCategoryIsDefaultQuery query = new FindByCategoryIsDefaultQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryIcon(
	CategoryIcon value,
	MetaRequest metaRequest
	) {

	FindByCategoryIconQuery query = new FindByCategoryIconQuery(value,metaRequest);
	CompletableFuture<List<CategoryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CategoryResponse.class));
	return future.join();
}
public List<CategoryResponse> findByCategoryColorHex(
	CategoryColorHex value,
	MetaRequest metaRequest
	) {

	FindByCategoryColorHexQuery query = new FindByCategoryColorHexQuery(value,metaRequest);
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
