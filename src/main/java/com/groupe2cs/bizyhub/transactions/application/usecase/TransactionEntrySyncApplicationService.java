package com.groupe2cs.bizyhub.transactions.application.usecase;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TransactionEntrySyncApplicationService {

	private final TransactionEntryGate gateService;
	private final CommandGateway commandGateway;

	public void syncTransactionEntry(TransactionEntrySyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateTransactionEntryCommand command = CreateTransactionEntryCommand.builder()
								.remoteId(TransactionEntryRemoteId.create(d.getRemoteId()))
								.code(TransactionEntryCode.create(d.getCode()))
								.description(TransactionEntryDescription.create(d.getDescription()))
								.amount(TransactionEntryAmount.create(d.getAmount()))
								.typeEntry(TransactionEntryTypeEntry.create(d.getTypeEntry()))
								.dateTransaction(TransactionEntryDateTransaction.create(d.getDateTransaction()))
								.status(TransactionEntryStatus.create(d.getStatus()))
								.entityName(TransactionEntryEntityName.create(d.getEntityName()))
								.entityId(TransactionEntryEntityId.create(d.getEntityId()))
								.account(TransactionEntryAccount.create(d.getAccount()))
								.syncAt(TransactionEntrySyncAt.create(d.getSyncAt()))
								.category(TransactionEntryCategory.create(d.getCategory()))
								.company(TransactionEntryCompany.create(d.getCompany()))
								.customer(TransactionEntryCustomer.create(d.getCustomer()))
								.debt(TransactionEntryDebt.create(d.getDebt()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(TransactionEntryTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(TransactionEntryCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update TransactionEntry with id " + d.getId());
					}

					UpdateTransactionEntryCommand update = UpdateTransactionEntryCommand.builder()
							.id(TransactionEntryId.create(d.getId()))
							.remoteId(TransactionEntryRemoteId.create(d.getRemoteId()))
							.code(TransactionEntryCode.create(d.getCode()))
							.description(TransactionEntryDescription.create(d.getDescription()))
							.amount(TransactionEntryAmount.create(d.getAmount()))
							.typeEntry(TransactionEntryTypeEntry.create(d.getTypeEntry()))
							.dateTransaction(TransactionEntryDateTransaction.create(d.getDateTransaction()))
							.status(TransactionEntryStatus.create(d.getStatus()))
							.entityName(TransactionEntryEntityName.create(d.getEntityName()))
							.entityId(TransactionEntryEntityId.create(d.getEntityId()))
							.account(TransactionEntryAccount.create(d.getAccount()))
							.syncAt(TransactionEntrySyncAt.create(d.getSyncAt()))
							.category(TransactionEntryCategory.create(d.getCategory()))
							.company(TransactionEntryCompany.create(d.getCompany()))
							.customer(TransactionEntryCustomer.create(d.getCustomer()))
							.debt(TransactionEntryDebt.create(d.getDebt()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete TransactionEntry with id " + d.getId());
					}

					DeleteTransactionEntryCommand delete = DeleteTransactionEntryCommand.builder()
						.id(TransactionEntryId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
