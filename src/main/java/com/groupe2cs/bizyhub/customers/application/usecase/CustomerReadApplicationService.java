package com.groupe2cs.bizyhub.customers.application.usecase;

import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
import com.groupe2cs.bizyhub.customers.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.customers.application.query.*;
import com.groupe2cs.bizyhub.customers.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CustomerReadApplicationService {

private final QueryGateway queryGateway;


public CustomerPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllCustomerQuery query = new FindAllCustomerQuery(page, limit,metaRequest);
	CompletableFuture<CustomerPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(CustomerPagedResponse.class));
	return future.join();
}


public CustomerResponse findByCustomerId(CustomerId value, MetaRequest metaRequest) {

	FindByCustomerIdQuery query = new FindByCustomerIdQuery(value,metaRequest);
	CompletableFuture<CustomerResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(CustomerResponse.class));
	return future.join();
}


public List<CustomerResponse> findByCustomerRemoteId(
	CustomerRemoteId value,
	MetaRequest metaRequest
	) {

	FindByCustomerRemoteIdQuery query = new FindByCustomerRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerCode(
	CustomerCode value,
	MetaRequest metaRequest
	) {

	FindByCustomerCodeQuery query = new FindByCustomerCodeQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerFirstName(
	CustomerFirstName value,
	MetaRequest metaRequest
	) {

	FindByCustomerFirstNameQuery query = new FindByCustomerFirstNameQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerLastName(
	CustomerLastName value,
	MetaRequest metaRequest
	) {

	FindByCustomerLastNameQuery query = new FindByCustomerLastNameQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerFullName(
	CustomerFullName value,
	MetaRequest metaRequest
	) {

	FindByCustomerFullNameQuery query = new FindByCustomerFullNameQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerBalance(
	CustomerBalance value,
	MetaRequest metaRequest
	) {

	FindByCustomerBalanceQuery query = new FindByCustomerBalanceQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerBalanceDebt(
	CustomerBalanceDebt value,
	MetaRequest metaRequest
	) {

	FindByCustomerBalanceDebtQuery query = new FindByCustomerBalanceDebtQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerPhone(
	CustomerPhone value,
	MetaRequest metaRequest
	) {

	FindByCustomerPhoneQuery query = new FindByCustomerPhoneQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerEmail(
	CustomerEmail value,
	MetaRequest metaRequest
	) {

	FindByCustomerEmailQuery query = new FindByCustomerEmailQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerNotes(
	CustomerNotes value,
	MetaRequest metaRequest
	) {

	FindByCustomerNotesQuery query = new FindByCustomerNotesQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerStatus(
	CustomerStatus value,
	MetaRequest metaRequest
	) {

	FindByCustomerStatusQuery query = new FindByCustomerStatusQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerCompany(
	CustomerCompany value,
	MetaRequest metaRequest
	) {

	FindByCustomerCompanyQuery query = new FindByCustomerCompanyQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerAddressLine1(
	CustomerAddressLine1 value,
	MetaRequest metaRequest
	) {

	FindByCustomerAddressLine1Query query = new FindByCustomerAddressLine1Query(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerAddressLine2(
	CustomerAddressLine2 value,
	MetaRequest metaRequest
	) {

	FindByCustomerAddressLine2Query query = new FindByCustomerAddressLine2Query(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerCity(
	CustomerCity value,
	MetaRequest metaRequest
	) {

	FindByCustomerCityQuery query = new FindByCustomerCityQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerRegion(
	CustomerRegion value,
	MetaRequest metaRequest
	) {

	FindByCustomerRegionQuery query = new FindByCustomerRegionQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerCountry(
	CustomerCountry value,
	MetaRequest metaRequest
	) {

	FindByCustomerCountryQuery query = new FindByCustomerCountryQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerPostalCode(
	CustomerPostalCode value,
	MetaRequest metaRequest
	) {

	FindByCustomerPostalCodeQuery query = new FindByCustomerPostalCodeQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerSyncAt(
	CustomerSyncAt value,
	MetaRequest metaRequest
	) {

	FindByCustomerSyncAtQuery query = new FindByCustomerSyncAtQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerIsActive(
	CustomerIsActive value,
	MetaRequest metaRequest
	) {

	FindByCustomerIsActiveQuery query = new FindByCustomerIsActiveQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerCreatedBy(
	CustomerCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByCustomerCreatedByQuery query = new FindByCustomerCreatedByQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}
public List<CustomerResponse> findByCustomerTenant(
	CustomerTenant value,
	MetaRequest metaRequest
	) {

	FindByCustomerTenantQuery query = new FindByCustomerTenantQuery(value,metaRequest);
	CompletableFuture<List<CustomerResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(CustomerResponse.class));
	return future.join();
}

}
