package com.groupe2cs.bizyhub.order.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.order.application.dto.*;
import com.groupe2cs.bizyhub.order.infrastructure.entity.*;
import com.groupe2cs.bizyhub.order.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.order.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.order.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class OrderFixtures {

	public static Order byId(OrderRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Order byIdWaitExist(OrderRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Order byIdWaitNotExist(OrderRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateOrderCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		OrderRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateOrderCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateOrderCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
        createdByDataRepository,
        tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(OrderRepository repository) {
		repository.deleteAll();
	}

		public static CreateOrderCommand randomOneViaCommand(
		CommandGateway commandGateway,
		OrderRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateOrderCommand command = CreateOrderCommand.builder()
				.productId(OrderProductId.create(UUID.randomUUID().toString()))
				.userId(OrderUserId.create(UUID.randomUUID().toString()))
				.identifiant(OrderIdentifiant.create(UUID.randomUUID().toString()))
				.telephone(OrderTelephone.create(UUID.randomUUID().toString()))
				.mail(OrderMail.create(UUID.randomUUID().toString()))
				.ville(OrderVille.create(UUID.randomUUID().toString()))
				.remoteId(OrderRemoteId.create(UUID.randomUUID().toString()))
				.localId(OrderLocalId.create(UUID.randomUUID().toString()))
				.status(OrderStatus.create(UUID.randomUUID().toString()))
				.buyerName(OrderBuyerName.create(UUID.randomUUID().toString()))
				.address(OrderAddress.create(UUID.randomUUID().toString()))
				.notes(OrderNotes.create(UUID.randomUUID().toString()))
				.message(OrderMessage.create(UUID.randomUUID().toString()))
				.typeOrder(OrderTypeOrder.create(UUID.randomUUID().toString()))
				.paymentMethod(OrderPaymentMethod.create(UUID.randomUUID().toString()))
				.deliveryMethod(OrderDeliveryMethod.create(UUID.randomUUID().toString()))
				.amountCents(OrderAmountCents.create(8637.69))
				.quantity(OrderQuantity.create(33))
				.dateCommand(OrderDateCommand.create(java.time.Instant.now().plusSeconds(3600)))
			.build();

		command.setCreatedBy(OrderCreatedBy.create(user.getId()));
		command.setTenant(OrderTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateOrderCommand randomOneViaCommand(
        CommandGateway commandGateway,
        OrderRepository  repository,
        User user
        ) {

        CreateOrderCommand command = CreateOrderCommand.builder()
        .productId(OrderProductId.create(UUID.randomUUID().toString()))
        .userId(OrderUserId.create(UUID.randomUUID().toString()))
        .identifiant(OrderIdentifiant.create(UUID.randomUUID().toString()))
        .telephone(OrderTelephone.create(UUID.randomUUID().toString()))
        .mail(OrderMail.create(UUID.randomUUID().toString()))
        .ville(OrderVille.create(UUID.randomUUID().toString()))
        .remoteId(OrderRemoteId.create(UUID.randomUUID().toString()))
        .localId(OrderLocalId.create(UUID.randomUUID().toString()))
        .status(OrderStatus.create(UUID.randomUUID().toString()))
        .buyerName(OrderBuyerName.create(UUID.randomUUID().toString()))
        .address(OrderAddress.create(UUID.randomUUID().toString()))
        .notes(OrderNotes.create(UUID.randomUUID().toString()))
        .message(OrderMessage.create(UUID.randomUUID().toString()))
        .typeOrder(OrderTypeOrder.create(UUID.randomUUID().toString()))
        .paymentMethod(OrderPaymentMethod.create(UUID.randomUUID().toString()))
        .deliveryMethod(OrderDeliveryMethod.create(UUID.randomUUID().toString()))
        .amountCents(OrderAmountCents.create(8637.69))
        .quantity(OrderQuantity.create(33))
        .dateCommand(OrderDateCommand.create(java.time.Instant.now().plusSeconds(3600)))
        .build();

		command.setCreatedBy(OrderCreatedBy.create(user.getId()));
		command.setTenant(OrderTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
