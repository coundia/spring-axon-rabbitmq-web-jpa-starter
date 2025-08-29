package com.groupe2cs.bizyhub.customers.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.customers.application.dto.*;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.*;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.customers.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class CustomerFixtures {

	public static Customer byId(CustomerRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Customer byIdWaitExist(CustomerRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Customer byIdWaitNotExist(CustomerRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateCustomerCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		CustomerRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateCustomerCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateCustomerCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(CustomerRepository repository) {
		repository.deleteAll();
	}

		public static CreateCustomerCommand randomOneViaCommand(
		CommandGateway commandGateway,
		CustomerRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateCustomerCommand command = CreateCustomerCommand.builder()
				.remoteId(CustomerRemoteId.create(UUID.randomUUID().toString()))
				.localId(CustomerLocalId.create(UUID.randomUUID().toString()))
				.code(CustomerCode.create(UUID.randomUUID().toString()))
				.firstName(CustomerFirstName.create(UUID.randomUUID().toString()))
				.lastName(CustomerLastName.create(UUID.randomUUID().toString()))
				.fullName(CustomerFullName.create(UUID.randomUUID().toString()))
				.balance(CustomerBalance.create(8331.41))
				.balanceDebt(CustomerBalanceDebt.create(9319.53))
				.phone(CustomerPhone.create(UUID.randomUUID().toString()))
				.email(CustomerEmail.create(UUID.randomUUID().toString()))
				.notes(CustomerNotes.create(UUID.randomUUID().toString()))
				.status(CustomerStatus.create(UUID.randomUUID().toString()))
				.account(CustomerAccount.create(UUID.randomUUID().toString()))
				.company(CustomerCompany.create(UUID.randomUUID().toString()))
				.addressLine1(CustomerAddressLine1.create(UUID.randomUUID().toString()))
				.addressLine2(CustomerAddressLine2.create(UUID.randomUUID().toString()))
				.city(CustomerCity.create(UUID.randomUUID().toString()))
				.region(CustomerRegion.create(UUID.randomUUID().toString()))
				.country(CustomerCountry.create(UUID.randomUUID().toString()))
				.postalCode(CustomerPostalCode.create(UUID.randomUUID().toString()))
				.syncAt(CustomerSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.isActive(CustomerIsActive.create(false))
			.build();

		command.setCreatedBy(CustomerCreatedBy.create(user.getId()));
		command.setTenant(CustomerTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateCustomerCommand randomOneViaCommand(
        CommandGateway commandGateway,
        CustomerRepository  repository,
        User user
        ) {

        CreateCustomerCommand command = CreateCustomerCommand.builder()
        .remoteId(CustomerRemoteId.create(UUID.randomUUID().toString()))
        .localId(CustomerLocalId.create(UUID.randomUUID().toString()))
        .code(CustomerCode.create(UUID.randomUUID().toString()))
        .firstName(CustomerFirstName.create(UUID.randomUUID().toString()))
        .lastName(CustomerLastName.create(UUID.randomUUID().toString()))
        .fullName(CustomerFullName.create(UUID.randomUUID().toString()))
        .balance(CustomerBalance.create(8331.41))
        .balanceDebt(CustomerBalanceDebt.create(9319.53))
        .phone(CustomerPhone.create(UUID.randomUUID().toString()))
        .email(CustomerEmail.create(UUID.randomUUID().toString()))
        .notes(CustomerNotes.create(UUID.randomUUID().toString()))
        .status(CustomerStatus.create(UUID.randomUUID().toString()))
        .account(CustomerAccount.create(UUID.randomUUID().toString()))
        .company(CustomerCompany.create(UUID.randomUUID().toString()))
        .addressLine1(CustomerAddressLine1.create(UUID.randomUUID().toString()))
        .addressLine2(CustomerAddressLine2.create(UUID.randomUUID().toString()))
        .city(CustomerCity.create(UUID.randomUUID().toString()))
        .region(CustomerRegion.create(UUID.randomUUID().toString()))
        .country(CustomerCountry.create(UUID.randomUUID().toString()))
        .postalCode(CustomerPostalCode.create(UUID.randomUUID().toString()))
        .syncAt(CustomerSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .isActive(CustomerIsActive.create(false))
        .build();

		command.setCreatedBy(CustomerCreatedBy.create(user.getId()));
		command.setTenant(CustomerTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
