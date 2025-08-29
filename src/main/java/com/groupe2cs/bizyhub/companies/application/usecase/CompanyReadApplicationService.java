package com.groupe2cs.bizyhub.companies.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import com.groupe2cs.bizyhub.companies.application.query.*;
import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.companies.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CompanyReadApplicationService {

private final QueryGateway queryGateway;


public CompanyPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllCompanyQuery query = new FindAllCompanyQuery(page, limit,metaRequest);
	CompletableFuture<CompanyPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(CompanyPagedResponse.class));
	return future.join();
}


public CompanyResponse findByCompanyId(CompanyId value, MetaRequest metaRequest) {

	FindByCompanyIdQuery query = new FindByCompanyIdQuery(value,metaRequest);
	CompletableFuture<CompanyResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(CompanyResponse.class));
	return future.join();
}


public List<CompanyResponse> findByCompanyRemoteId(
	CompanyRemoteId value,
	MetaRequest metaRequest
	) {

	FindByCompanyRemoteIdQuery query = new FindByCompanyRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyLocalId(
	CompanyLocalId value,
	MetaRequest metaRequest
	) {

	FindByCompanyLocalIdQuery query = new FindByCompanyLocalIdQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyCode(
	CompanyCode value,
	MetaRequest metaRequest
	) {

	FindByCompanyCodeQuery query = new FindByCompanyCodeQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyName(
	CompanyName value,
	MetaRequest metaRequest
	) {

	FindByCompanyNameQuery query = new FindByCompanyNameQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyDescription(
	CompanyDescription value,
	MetaRequest metaRequest
	) {

	FindByCompanyDescriptionQuery query = new FindByCompanyDescriptionQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyPhone(
	CompanyPhone value,
	MetaRequest metaRequest
	) {

	FindByCompanyPhoneQuery query = new FindByCompanyPhoneQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyEmail(
	CompanyEmail value,
	MetaRequest metaRequest
	) {

	FindByCompanyEmailQuery query = new FindByCompanyEmailQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyWebsite(
	CompanyWebsite value,
	MetaRequest metaRequest
	) {

	FindByCompanyWebsiteQuery query = new FindByCompanyWebsiteQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyTaxId(
	CompanyTaxId value,
	MetaRequest metaRequest
	) {

	FindByCompanyTaxIdQuery query = new FindByCompanyTaxIdQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyCurrency(
	CompanyCurrency value,
	MetaRequest metaRequest
	) {

	FindByCompanyCurrencyQuery query = new FindByCompanyCurrencyQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyAddressLine1(
	CompanyAddressLine1 value,
	MetaRequest metaRequest
	) {

	FindByCompanyAddressLine1Query query = new FindByCompanyAddressLine1Query(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyAddressLine2(
	CompanyAddressLine2 value,
	MetaRequest metaRequest
	) {

	FindByCompanyAddressLine2Query query = new FindByCompanyAddressLine2Query(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyCity(
	CompanyCity value,
	MetaRequest metaRequest
	) {

	FindByCompanyCityQuery query = new FindByCompanyCityQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyRegion(
	CompanyRegion value,
	MetaRequest metaRequest
	) {

	FindByCompanyRegionQuery query = new FindByCompanyRegionQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyCountry(
	CompanyCountry value,
	MetaRequest metaRequest
	) {

	FindByCompanyCountryQuery query = new FindByCompanyCountryQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyAccount(
	CompanyAccount value,
	MetaRequest metaRequest
	) {

	FindByCompanyAccountQuery query = new FindByCompanyAccountQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyPostalCode(
	CompanyPostalCode value,
	MetaRequest metaRequest
	) {

	FindByCompanyPostalCodeQuery query = new FindByCompanyPostalCodeQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyIsActive(
	CompanyIsActive value,
	MetaRequest metaRequest
	) {

	FindByCompanyIsActiveQuery query = new FindByCompanyIsActiveQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanySyncAt(
	CompanySyncAt value,
	MetaRequest metaRequest
	) {

	FindByCompanySyncAtQuery query = new FindByCompanySyncAtQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyIsDefault(
	CompanyIsDefault value,
	MetaRequest metaRequest
	) {

	FindByCompanyIsDefaultQuery query = new FindByCompanyIsDefaultQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyCreatedBy(
	CompanyCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByCompanyCreatedByQuery query = new FindByCompanyCreatedByQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}
public List<CompanyResponse> findByCompanyTenant(
	CompanyTenant value,
	MetaRequest metaRequest
	) {

	FindByCompanyTenantQuery query = new FindByCompanyTenantQuery(value,metaRequest);
	CompletableFuture<List<CompanyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CompanyResponse.class));
	return future.join();
}

}
