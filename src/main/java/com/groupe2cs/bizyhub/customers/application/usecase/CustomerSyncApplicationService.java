package com.groupe2cs.bizyhub.customers.application.usecase;
import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.customers.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.customers.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CustomerSyncApplicationService {

	private final CustomerGate gateService;
	private final CommandGateway commandGateway;

	public void syncCustomer(CustomerSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateCustomerCommand command = CreateCustomerCommand.builder()
								.remoteId(CustomerRemoteId.create(d.getRemoteId()))
								.localId(CustomerLocalId.create(d.getLocalId()))
								.code(CustomerCode.create(d.getCode()))
								.firstName(CustomerFirstName.create(d.getFirstName()))
								.lastName(CustomerLastName.create(d.getLastName()))
								.fullName(CustomerFullName.create(d.getFullName()))
								.balance(CustomerBalance.create(d.getBalance()))
								.balanceDebt(CustomerBalanceDebt.create(d.getBalanceDebt()))
								.phone(CustomerPhone.create(d.getPhone()))
								.email(CustomerEmail.create(d.getEmail()))
								.notes(CustomerNotes.create(d.getNotes()))
								.status(CustomerStatus.create(d.getStatus()))
								.account(CustomerAccount.create(d.getAccount()))
								.company(CustomerCompany.create(d.getCompany()))
								.addressLine1(CustomerAddressLine1.create(d.getAddressLine1()))
								.addressLine2(CustomerAddressLine2.create(d.getAddressLine2()))
								.city(CustomerCity.create(d.getCity()))
								.region(CustomerRegion.create(d.getRegion()))
								.country(CustomerCountry.create(d.getCountry()))
								.postalCode(CustomerPostalCode.create(d.getPostalCode()))
								.syncAt(CustomerSyncAt.create(d.getSyncAt()))
								.isActive(CustomerIsActive.create(d.getIsActive()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(CustomerTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(CustomerCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Customer with id " + d.getId());
					}

					UpdateCustomerCommand update = UpdateCustomerCommand.builder()
							.id(CustomerId.create(d.getId()))
							.remoteId(CustomerRemoteId.create(d.getRemoteId()))
							.localId(CustomerLocalId.create(d.getLocalId()))
							.code(CustomerCode.create(d.getCode()))
							.firstName(CustomerFirstName.create(d.getFirstName()))
							.lastName(CustomerLastName.create(d.getLastName()))
							.fullName(CustomerFullName.create(d.getFullName()))
							.balance(CustomerBalance.create(d.getBalance()))
							.balanceDebt(CustomerBalanceDebt.create(d.getBalanceDebt()))
							.phone(CustomerPhone.create(d.getPhone()))
							.email(CustomerEmail.create(d.getEmail()))
							.notes(CustomerNotes.create(d.getNotes()))
							.status(CustomerStatus.create(d.getStatus()))
							.account(CustomerAccount.create(d.getAccount()))
							.company(CustomerCompany.create(d.getCompany()))
							.addressLine1(CustomerAddressLine1.create(d.getAddressLine1()))
							.addressLine2(CustomerAddressLine2.create(d.getAddressLine2()))
							.city(CustomerCity.create(d.getCity()))
							.region(CustomerRegion.create(d.getRegion()))
							.country(CustomerCountry.create(d.getCountry()))
							.postalCode(CustomerPostalCode.create(d.getPostalCode()))
							.syncAt(CustomerSyncAt.create(d.getSyncAt()))
							.isActive(CustomerIsActive.create(d.getIsActive()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Customer with id " + d.getId());
					}

					DeleteCustomerCommand delete = DeleteCustomerCommand.builder()
						.id(CustomerId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
