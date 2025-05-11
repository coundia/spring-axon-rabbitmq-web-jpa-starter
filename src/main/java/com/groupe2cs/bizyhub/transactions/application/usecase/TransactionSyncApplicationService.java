package com.groupe2cs.bizyhub.transactions.application.usecase;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;


@Service
@RequiredArgsConstructor
public class TransactionSyncApplicationService {

	private final CommandGateway commandGateway;
	public void syncTransaction(TransactionSyncRequest request,
MetaRequest metaRequest

) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {

CreateTransactionCommand command = CreateTransactionCommand.builder()
		.name(TransactionName.create(d.getName()))
		.amount(TransactionAmount.create(d.getAmount()))
		.details(TransactionDetails.create(d.getDetails()))
		.isActive(TransactionIsActive.create(d.getIsActive()))
		.account(TransactionAccount.create(d.getAccount()))
		.category(TransactionCategory.create(d.getCategory()))
		.typeTransactionRaw(TransactionTypeTransactionRaw.create(d.getTypeTransactionRaw()))
		.dateTransaction(TransactionDateTransaction.create(d.getDateTransaction()))
		.updatedAt(TransactionUpdatedAt.create(d.getUpdatedAt()))
		.reference(TransactionReference.create(d.getReference()))
.build();
		if(metaRequest.getTenantId() != null) {
			command.setTenant(TransactionTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			command.setCreatedBy( TransactionCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
							command
				);

		}
				case "UPDATE" -> {
		UpdateTransactionCommand update = UpdateTransactionCommand.builder()
			.id(TransactionId.create(d.getId()))
			.name(TransactionName.create(d.getName()))
			.amount(TransactionAmount.create(d.getAmount()))
			.details(TransactionDetails.create(d.getDetails()))
			.isActive(TransactionIsActive.create(d.getIsActive()))
			.account(TransactionAccount.create(d.getAccount()))
			.category(TransactionCategory.create(d.getCategory()))
			.typeTransactionRaw(TransactionTypeTransactionRaw.create(d.getTypeTransactionRaw()))
			.dateTransaction(TransactionDateTransaction.create(d.getDateTransaction()))
			.updatedAt(TransactionUpdatedAt.create(d.getUpdatedAt()))
			.reference(TransactionReference.create(d.getReference()))
		.build();

		if(metaRequest.getTenantId() != null) {
			//update.setTenant(TransactionTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			//update.setCreatedBy( TransactionCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
		update
				);

		}
		case "DELETE" -> {
				DeleteTransactionCommand delete = DeleteTransactionCommand.builder()
					.id(TransactionId.create(d.getId()) )
					.build();

				if(metaRequest.getTenantId() != null) {
					//delete.setTenant(TransactionTenant.create(metaRequest.getTenantId()));
				}

				if(metaRequest.getUserId() != null) {
					//delete.setCreatedBy( TransactionCreatedBy.create(metaRequest.getUserId()));
				}
				commandGateway.sendAndWait(
				delete
				 );
				}
			}
		}
	}
}
