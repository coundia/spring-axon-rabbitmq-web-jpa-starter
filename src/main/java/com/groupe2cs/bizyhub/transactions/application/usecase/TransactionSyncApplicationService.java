package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.command.UpdateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionSyncRequest;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionSyncApplicationService {

	private final TransactionGate gateService;
	private final CommandGateway commandGateway;

	public void syncTransaction(TransactionSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateTransactionCommand command = CreateTransactionCommand.builder()
							.remoteId(TransactionRemoteId.create(d.getRemoteId()))
							.localId(TransactionLocalId.create(d.getLocalId()))
							.code(TransactionCode.create(d.getCode()))
							.description(TransactionDescription.create(d.getDescription()))
							.amount(TransactionAmount.create(d.getAmount()))
							.typeEntry(TransactionTypeEntry.create(d.getTypeEntry()))
							.dateTransaction(TransactionDateTransaction.create(d.getDateTransaction()))
							.status(TransactionStatus.create(d.getStatus()))
							.entityName(TransactionEntityName.create(d.getEntityName()))
							.entityId(TransactionEntityId.create(d.getEntityId()))
							.account(TransactionAccount.create(d.getAccount()))
							.syncAt(TransactionSyncAt.create(d.getSyncAt()))
							.category(TransactionCategory.create(d.getCategory()))
							.company(TransactionCompany.create(d.getCompany()))
							.customer(TransactionCustomer.create(d.getCustomer()))
							.debt(TransactionDebt.create(d.getDebt()))
							.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(TransactionTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(TransactionCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Transaction with id " + d.getId());
					}

					UpdateTransactionCommand update = UpdateTransactionCommand.builder()
							.id(TransactionId.create(d.getId()))
							.remoteId(TransactionRemoteId.create(d.getRemoteId()))
							.localId(TransactionLocalId.create(d.getLocalId()))
							.code(TransactionCode.create(d.getCode()))
							.description(TransactionDescription.create(d.getDescription()))
							.amount(TransactionAmount.create(d.getAmount()))
							.typeEntry(TransactionTypeEntry.create(d.getTypeEntry()))
							.dateTransaction(TransactionDateTransaction.create(d.getDateTransaction()))
							.status(TransactionStatus.create(d.getStatus()))
							.entityName(TransactionEntityName.create(d.getEntityName()))
							.entityId(TransactionEntityId.create(d.getEntityId()))
							.account(TransactionAccount.create(d.getAccount()))
							.syncAt(TransactionSyncAt.create(d.getSyncAt()))
							.category(TransactionCategory.create(d.getCategory()))
							.company(TransactionCompany.create(d.getCompany()))
							.customer(TransactionCustomer.create(d.getCustomer()))
							.debt(TransactionDebt.create(d.getDebt()))
							.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Transaction with id " + d.getId());
					}

					DeleteTransactionCommand delete = DeleteTransactionCommand.builder()
							.id(TransactionId.create(d.getId()))
							.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
