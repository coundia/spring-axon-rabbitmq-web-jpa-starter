package com.groupe2cs.bizyhub.transactions.application.usecase;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;

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
		.amount(TransactionAmount.create(d.getAmount()))
		.dateOperation(TransactionDateOperation.create(d.getDateOperation()))
		.description(TransactionDescription.create(d.getDescription()))
		.reference(TransactionReference.create(d.getReference()))
		.isRecurring(TransactionIsRecurring.create(d.getIsRecurring()))
		.isExcluToRapport(TransactionIsExcluToRapport.create(d.getIsExcluToRapport()))
		.status(TransactionStatus.create(d.getStatus()))
		.balance(TransactionBalance.create(d.getBalance()))
		.category(TransactionCategory.create(d.getCategory()))
		.updatedAt(TransactionUpdatedAt.create(d.getUpdatedAt()))
		.createdAt(TransactionCreatedAt.create(d.getCreatedAt()))
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
			.amount(TransactionAmount.create(d.getAmount()))
			.dateOperation(TransactionDateOperation.create(d.getDateOperation()))
			.description(TransactionDescription.create(d.getDescription()))
			.reference(TransactionReference.create(d.getReference()))
			.isRecurring(TransactionIsRecurring.create(d.getIsRecurring()))
			.isExcluToRapport(TransactionIsExcluToRapport.create(d.getIsExcluToRapport()))
			.status(TransactionStatus.create(d.getStatus()))
			.balance(TransactionBalance.create(d.getBalance()))
			.category(TransactionCategory.create(d.getCategory()))
			.updatedAt(TransactionUpdatedAt.create(d.getUpdatedAt()))
			.createdAt(TransactionCreatedAt.create(d.getCreatedAt()))
		.build();

		if(metaRequest.getTenantId() != null) {
			//command.setTenant(TransactionTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			//command.setCreatedBy( TransactionCreatedBy.create(metaRequest.getUserId()));
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
