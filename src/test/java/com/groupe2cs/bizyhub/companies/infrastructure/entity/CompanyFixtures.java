package com.groupe2cs.bizyhub.companies.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.*;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.companies.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class CompanyFixtures {

	public static Company byId(CompanyRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Company byIdWaitExist(CompanyRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Company byIdWaitNotExist(CompanyRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateCompanyCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		CompanyRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateCompanyCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateCompanyCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
        createdByDataRepository,
        tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(CompanyRepository repository) {
		repository.deleteAll();
	}

		public static CreateCompanyCommand randomOneViaCommand(
		CommandGateway commandGateway,
		CompanyRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateCompanyCommand command = CreateCompanyCommand.builder()
				.remoteId(CompanyRemoteId.create(UUID.randomUUID().toString()))
				.localId(CompanyLocalId.create(UUID.randomUUID().toString()))
				.code(CompanyCode.create(UUID.randomUUID().toString()))
				.name(CompanyName.create(UUID.randomUUID().toString()))
				.description(CompanyDescription.create(UUID.randomUUID().toString()))
				.phone(CompanyPhone.create(UUID.randomUUID().toString()))
				.email(CompanyEmail.create(UUID.randomUUID().toString()))
				.website(CompanyWebsite.create(UUID.randomUUID().toString()))
				.taxId(CompanyTaxId.create(UUID.randomUUID().toString()))
				.currency(CompanyCurrency.create(UUID.randomUUID().toString()))
				.addressLine1(CompanyAddressLine1.create(UUID.randomUUID().toString()))
				.addressLine2(CompanyAddressLine2.create(UUID.randomUUID().toString()))
				.city(CompanyCity.create(UUID.randomUUID().toString()))
				.region(CompanyRegion.create(UUID.randomUUID().toString()))
				.country(CompanyCountry.create(UUID.randomUUID().toString()))
				.account(CompanyAccount.create(UUID.randomUUID().toString()))
				.postalCode(CompanyPostalCode.create(UUID.randomUUID().toString()))
				.isActive(CompanyIsActive.create(false))
				.status(CompanyStatus.create(UUID.randomUUID().toString()))
				.isPublic(CompanyIsPublic.create(false))
				.syncAt(CompanySyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.isDefault(CompanyIsDefault.create(true))
			.build();

		command.setCreatedBy(CompanyCreatedBy.create(user.getId()));
		command.setTenant(CompanyTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateCompanyCommand randomOneViaCommand(
        CommandGateway commandGateway,
        CompanyRepository  repository,
        User user
        ) {

        CreateCompanyCommand command = CreateCompanyCommand.builder()
        .remoteId(CompanyRemoteId.create(UUID.randomUUID().toString()))
        .localId(CompanyLocalId.create(UUID.randomUUID().toString()))
        .code(CompanyCode.create(UUID.randomUUID().toString()))
        .name(CompanyName.create(UUID.randomUUID().toString()))
        .description(CompanyDescription.create(UUID.randomUUID().toString()))
        .phone(CompanyPhone.create(UUID.randomUUID().toString()))
        .email(CompanyEmail.create(UUID.randomUUID().toString()))
        .website(CompanyWebsite.create(UUID.randomUUID().toString()))
        .taxId(CompanyTaxId.create(UUID.randomUUID().toString()))
        .currency(CompanyCurrency.create(UUID.randomUUID().toString()))
        .addressLine1(CompanyAddressLine1.create(UUID.randomUUID().toString()))
        .addressLine2(CompanyAddressLine2.create(UUID.randomUUID().toString()))
        .city(CompanyCity.create(UUID.randomUUID().toString()))
        .region(CompanyRegion.create(UUID.randomUUID().toString()))
        .country(CompanyCountry.create(UUID.randomUUID().toString()))
        .account(CompanyAccount.create(UUID.randomUUID().toString()))
        .postalCode(CompanyPostalCode.create(UUID.randomUUID().toString()))
        .isActive(CompanyIsActive.create(false))
        .status(CompanyStatus.create(UUID.randomUUID().toString()))
        .isPublic(CompanyIsPublic.create(false))
        .syncAt(CompanySyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .isDefault(CompanyIsDefault.create(true))
        .build();

		command.setCreatedBy(CompanyCreatedBy.create(user.getId()));
		command.setTenant(CompanyTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
