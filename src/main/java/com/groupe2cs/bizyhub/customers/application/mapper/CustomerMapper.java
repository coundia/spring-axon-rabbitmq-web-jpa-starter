package com.groupe2cs.bizyhub.customers.application.mapper;

	import com.groupe2cs.bizyhub.customers.application.dto.*;
	import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
	import com.groupe2cs.bizyhub.customers.domain.*;
	import com.groupe2cs.bizyhub.customers.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.customers.application.command.*;

public class CustomerMapper {

public static CustomerResponse toResponse(Customer entity) {
return CustomerResponse.builder()
		.id(entity.getId())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.code(entity.getCode())
		.firstName(entity.getFirstName())
		.lastName(entity.getLastName())
		.fullName(entity.getFullName())
		.balance(entity.getBalance())
		.balanceDebt(entity.getBalanceDebt())
		.phone(entity.getPhone())
		.email(entity.getEmail())
		.notes(entity.getNotes())
		.status(entity.getStatus())
		.company(entity.getCompany())
		.addressLine1(entity.getAddressLine1())
		.addressLine2(entity.getAddressLine2())
		.city(entity.getCity())
		.region(entity.getRegion())
		.country(entity.getCountry())
		.postalCode(entity.getPostalCode())
		.syncAt(entity.getSyncAt())
		.isActive(entity.getIsActive())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static CustomerResponse toResponse(CreateCustomerCommand command) {
return CustomerResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.code(command.getCode().value())
	.firstName(command.getFirstName().value())
	.lastName(command.getLastName().value())
	.fullName(command.getFullName().value())
	.balance(command.getBalance().value())
	.balanceDebt(command.getBalanceDebt().value())
	.phone(command.getPhone().value())
	.email(command.getEmail().value())
	.notes(command.getNotes().value())
	.status(command.getStatus().value())
	.company(command.getCompany().value())
	.addressLine1(command.getAddressLine1().value())
	.addressLine2(command.getAddressLine2().value())
	.city(command.getCity().value())
	.region(command.getRegion().value())
	.country(command.getCountry().value())
	.postalCode(command.getPostalCode().value())
	.syncAt(command.getSyncAt().value())
	.isActive(command.getIsActive().value())
.build();
}

public static CustomerResponse toResponse(UpdateCustomerCommand command) {
return CustomerResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.code(command.getCode().value())
	.firstName(command.getFirstName().value())
	.lastName(command.getLastName().value())
	.fullName(command.getFullName().value())
	.balance(command.getBalance().value())
	.balanceDebt(command.getBalanceDebt().value())
	.phone(command.getPhone().value())
	.email(command.getEmail().value())
	.notes(command.getNotes().value())
	.status(command.getStatus().value())
	.company(command.getCompany().value())
	.addressLine1(command.getAddressLine1().value())
	.addressLine2(command.getAddressLine2().value())
	.city(command.getCity().value())
	.region(command.getRegion().value())
	.country(command.getCountry().value())
	.postalCode(command.getPostalCode().value())
	.syncAt(command.getSyncAt().value())
	.isActive(command.getIsActive().value())
.build();
}

public static CreateCustomerCommand toCommand(
CustomerRequest request
) {
return CreateCustomerCommand.builder()
	.remoteId(CustomerRemoteId.create(request.getRemoteId()))
	.localId(CustomerLocalId.create(request.getLocalId()))
	.code(CustomerCode.create(request.getCode()))
	.firstName(CustomerFirstName.create(request.getFirstName()))
	.lastName(CustomerLastName.create(request.getLastName()))
	.fullName(CustomerFullName.create(request.getFullName()))
	.balance(CustomerBalance.create(request.getBalance()))
	.balanceDebt(CustomerBalanceDebt.create(request.getBalanceDebt()))
	.phone(CustomerPhone.create(request.getPhone()))
	.email(CustomerEmail.create(request.getEmail()))
	.notes(CustomerNotes.create(request.getNotes()))
	.status(CustomerStatus.create(request.getStatus()))
	.company(CustomerCompany.create(request.getCompany()))
	.addressLine1(CustomerAddressLine1.create(request.getAddressLine1()))
	.addressLine2(CustomerAddressLine2.create(request.getAddressLine2()))
	.city(CustomerCity.create(request.getCity()))
	.region(CustomerRegion.create(request.getRegion()))
	.country(CustomerCountry.create(request.getCountry()))
	.postalCode(CustomerPostalCode.create(request.getPostalCode()))
	.syncAt(CustomerSyncAt.create(request.getSyncAt()))
	.isActive(CustomerIsActive.create(request.getIsActive()))
.build();
}

	public static UpdateCustomerCommand toUpdateCommand(CustomerId id, CustomerRequest request) {
	return UpdateCustomerCommand.builder()
	.id(id)
		.remoteId(CustomerRemoteId.create(request.getRemoteId()))
		.localId(CustomerLocalId.create(request.getLocalId()))
		.code(CustomerCode.create(request.getCode()))
		.firstName(CustomerFirstName.create(request.getFirstName()))
		.lastName(CustomerLastName.create(request.getLastName()))
		.fullName(CustomerFullName.create(request.getFullName()))
		.balance(CustomerBalance.create(request.getBalance()))
		.balanceDebt(CustomerBalanceDebt.create(request.getBalanceDebt()))
		.phone(CustomerPhone.create(request.getPhone()))
		.email(CustomerEmail.create(request.getEmail()))
		.notes(CustomerNotes.create(request.getNotes()))
		.status(CustomerStatus.create(request.getStatus()))
		.company(CustomerCompany.create(request.getCompany()))
		.addressLine1(CustomerAddressLine1.create(request.getAddressLine1()))
		.addressLine2(CustomerAddressLine2.create(request.getAddressLine2()))
		.city(CustomerCity.create(request.getCity()))
		.region(CustomerRegion.create(request.getRegion()))
		.country(CustomerCountry.create(request.getCountry()))
		.postalCode(CustomerPostalCode.create(request.getPostalCode()))
		.syncAt(CustomerSyncAt.create(request.getSyncAt()))
		.isActive(CustomerIsActive.create(request.getIsActive()))
	.build();
	}


public static DeleteCustomerCommand toDeleteCommand(CustomerId id) {
return DeleteCustomerCommand.builder()
.id(id)
.build();
}
}
