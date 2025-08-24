package com.groupe2cs.bizyhub.companies.application.usecase;
import com.groupe2cs.bizyhub.companies.application.command.*;
import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CompanySyncApplicationService {

	private final CompanyGate gateService;
	private final CommandGateway commandGateway;

	public void syncCompany(CompanySyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateCompanyCommand command = CreateCompanyCommand.builder()
								.remoteId(CompanyRemoteId.create(d.getRemoteId()))
								.code(CompanyCode.create(d.getCode()))
								.name(CompanyName.create(d.getName()))
								.description(CompanyDescription.create(d.getDescription()))
								.phone(CompanyPhone.create(d.getPhone()))
								.email(CompanyEmail.create(d.getEmail()))
								.website(CompanyWebsite.create(d.getWebsite()))
								.taxId(CompanyTaxId.create(d.getTaxId()))
								.currency(CompanyCurrency.create(d.getCurrency()))
								.addressLine1(CompanyAddressLine1.create(d.getAddressLine1()))
								.addressLine2(CompanyAddressLine2.create(d.getAddressLine2()))
								.city(CompanyCity.create(d.getCity()))
								.region(CompanyRegion.create(d.getRegion()))
								.country(CompanyCountry.create(d.getCountry()))
								.postalCode(CompanyPostalCode.create(d.getPostalCode()))
								.isActive(CompanyIsActive.create(d.getIsActive()))
								.syncAt(CompanySyncAt.create(d.getSyncAt()))
								.isDefault(CompanyIsDefault.create(d.getIsDefault()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(CompanyTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(CompanyCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Company with id " + d.getId());
					}

					UpdateCompanyCommand update = UpdateCompanyCommand.builder()
							.id(CompanyId.create(d.getId()))
							.remoteId(CompanyRemoteId.create(d.getRemoteId()))
							.code(CompanyCode.create(d.getCode()))
							.name(CompanyName.create(d.getName()))
							.description(CompanyDescription.create(d.getDescription()))
							.phone(CompanyPhone.create(d.getPhone()))
							.email(CompanyEmail.create(d.getEmail()))
							.website(CompanyWebsite.create(d.getWebsite()))
							.taxId(CompanyTaxId.create(d.getTaxId()))
							.currency(CompanyCurrency.create(d.getCurrency()))
							.addressLine1(CompanyAddressLine1.create(d.getAddressLine1()))
							.addressLine2(CompanyAddressLine2.create(d.getAddressLine2()))
							.city(CompanyCity.create(d.getCity()))
							.region(CompanyRegion.create(d.getRegion()))
							.country(CompanyCountry.create(d.getCountry()))
							.postalCode(CompanyPostalCode.create(d.getPostalCode()))
							.isActive(CompanyIsActive.create(d.getIsActive()))
							.syncAt(CompanySyncAt.create(d.getSyncAt()))
							.isDefault(CompanyIsDefault.create(d.getIsDefault()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Company with id " + d.getId());
					}

					DeleteCompanyCommand delete = DeleteCompanyCommand.builder()
						.id(CompanyId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
