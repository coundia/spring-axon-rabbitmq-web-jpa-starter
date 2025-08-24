package com.groupe2cs.bizyhub.companies.application.mapper;

	import com.groupe2cs.bizyhub.companies.application.dto.*;
	import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
	import com.groupe2cs.bizyhub.companies.domain.*;
	import com.groupe2cs.bizyhub.companies.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.companies.application.command.*;

public class CompanyMapper {

public static CompanyResponse toResponse(Company entity) {
return CompanyResponse.builder()
		.id(entity.getId())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.code(entity.getCode())
		.name(entity.getName())
		.description(entity.getDescription())
		.phone(entity.getPhone())
		.email(entity.getEmail())
		.website(entity.getWebsite())
		.taxId(entity.getTaxId())
		.currency(entity.getCurrency())
		.addressLine1(entity.getAddressLine1())
		.addressLine2(entity.getAddressLine2())
		.city(entity.getCity())
		.region(entity.getRegion())
		.country(entity.getCountry())
		.postalCode(entity.getPostalCode())
		.isActive(entity.getIsActive())
		.syncAt(entity.getSyncAt())
		.isDefault(entity.getIsDefault())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static CompanyResponse toResponse(CreateCompanyCommand command) {
return CompanyResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.code(command.getCode().value())
	.name(command.getName().value())
	.description(command.getDescription().value())
	.phone(command.getPhone().value())
	.email(command.getEmail().value())
	.website(command.getWebsite().value())
	.taxId(command.getTaxId().value())
	.currency(command.getCurrency().value())
	.addressLine1(command.getAddressLine1().value())
	.addressLine2(command.getAddressLine2().value())
	.city(command.getCity().value())
	.region(command.getRegion().value())
	.country(command.getCountry().value())
	.postalCode(command.getPostalCode().value())
	.isActive(command.getIsActive().value())
	.syncAt(command.getSyncAt().value())
	.isDefault(command.getIsDefault().value())
.build();
}

public static CompanyResponse toResponse(UpdateCompanyCommand command) {
return CompanyResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.code(command.getCode().value())
	.name(command.getName().value())
	.description(command.getDescription().value())
	.phone(command.getPhone().value())
	.email(command.getEmail().value())
	.website(command.getWebsite().value())
	.taxId(command.getTaxId().value())
	.currency(command.getCurrency().value())
	.addressLine1(command.getAddressLine1().value())
	.addressLine2(command.getAddressLine2().value())
	.city(command.getCity().value())
	.region(command.getRegion().value())
	.country(command.getCountry().value())
	.postalCode(command.getPostalCode().value())
	.isActive(command.getIsActive().value())
	.syncAt(command.getSyncAt().value())
	.isDefault(command.getIsDefault().value())
.build();
}

public static CreateCompanyCommand toCommand(
CompanyRequest request
) {
return CreateCompanyCommand.builder()
	.remoteId(CompanyRemoteId.create(request.getRemoteId()))
	.localId(CompanyLocalId.create(request.getLocalId()))
	.code(CompanyCode.create(request.getCode()))
	.name(CompanyName.create(request.getName()))
	.description(CompanyDescription.create(request.getDescription()))
	.phone(CompanyPhone.create(request.getPhone()))
	.email(CompanyEmail.create(request.getEmail()))
	.website(CompanyWebsite.create(request.getWebsite()))
	.taxId(CompanyTaxId.create(request.getTaxId()))
	.currency(CompanyCurrency.create(request.getCurrency()))
	.addressLine1(CompanyAddressLine1.create(request.getAddressLine1()))
	.addressLine2(CompanyAddressLine2.create(request.getAddressLine2()))
	.city(CompanyCity.create(request.getCity()))
	.region(CompanyRegion.create(request.getRegion()))
	.country(CompanyCountry.create(request.getCountry()))
	.postalCode(CompanyPostalCode.create(request.getPostalCode()))
	.isActive(CompanyIsActive.create(request.getIsActive()))
	.syncAt(CompanySyncAt.create(request.getSyncAt()))
	.isDefault(CompanyIsDefault.create(request.getIsDefault()))
.build();
}

	public static UpdateCompanyCommand toUpdateCommand(CompanyId id, CompanyRequest request) {
	return UpdateCompanyCommand.builder()
	.id(id)
		.remoteId(CompanyRemoteId.create(request.getRemoteId()))
		.localId(CompanyLocalId.create(request.getLocalId()))
		.code(CompanyCode.create(request.getCode()))
		.name(CompanyName.create(request.getName()))
		.description(CompanyDescription.create(request.getDescription()))
		.phone(CompanyPhone.create(request.getPhone()))
		.email(CompanyEmail.create(request.getEmail()))
		.website(CompanyWebsite.create(request.getWebsite()))
		.taxId(CompanyTaxId.create(request.getTaxId()))
		.currency(CompanyCurrency.create(request.getCurrency()))
		.addressLine1(CompanyAddressLine1.create(request.getAddressLine1()))
		.addressLine2(CompanyAddressLine2.create(request.getAddressLine2()))
		.city(CompanyCity.create(request.getCity()))
		.region(CompanyRegion.create(request.getRegion()))
		.country(CompanyCountry.create(request.getCountry()))
		.postalCode(CompanyPostalCode.create(request.getPostalCode()))
		.isActive(CompanyIsActive.create(request.getIsActive()))
		.syncAt(CompanySyncAt.create(request.getSyncAt()))
		.isDefault(CompanyIsDefault.create(request.getIsDefault()))
	.build();
	}


public static DeleteCompanyCommand toDeleteCommand(CompanyId id) {
return DeleteCompanyCommand.builder()
.id(id)
.build();
}
}
