package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionItemCommand;
import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionItemCommand;
import com.groupe2cs.bizyhub.transactions.application.command.UpdateTransactionItemCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemSyncRequest;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionItemSyncApplicationService {

	private final TransactionItemGate gateService;
	private final CommandGateway commandGateway;

	public void syncTransactionItem(TransactionItemSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateTransactionItemCommand command = CreateTransactionItemCommand.builder()
							.transaction(TransactionItemTransaction.create(d.getTransaction()))
							.product(TransactionItemProduct.create(d.getProduct()))
							.label(TransactionItemLabel.create(d.getLabel()))
							.quantity(TransactionItemQuantity.create(d.getQuantity()))
							.unit(TransactionItemUnit.create(d.getUnit()))
							.account(TransactionItemAccount.create(d.getAccount()))
							.remoteId(TransactionItemRemoteId.create(d.getRemoteId()))
							.localId(TransactionItemLocalId.create(d.getLocalId()))
							.syncAt(TransactionItemSyncAt.create(d.getSyncAt()))
							.unitPrice(TransactionItemUnitPrice.create(d.getUnitPrice()))
							.total(TransactionItemTotal.create(d.getTotal()))
							.notes(TransactionItemNotes.create(d.getNotes()))
							.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(TransactionItemTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(TransactionItemCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update TransactionItem with id " + d.getId());
					}

					UpdateTransactionItemCommand update = UpdateTransactionItemCommand.builder()
							.id(TransactionItemId.create(d.getId()))
							.transaction(TransactionItemTransaction.create(d.getTransaction()))
							.product(TransactionItemProduct.create(d.getProduct()))
							.label(TransactionItemLabel.create(d.getLabel()))
							.quantity(TransactionItemQuantity.create(d.getQuantity()))
							.unit(TransactionItemUnit.create(d.getUnit()))
							.account(TransactionItemAccount.create(d.getAccount()))
							.remoteId(TransactionItemRemoteId.create(d.getRemoteId()))
							.localId(TransactionItemLocalId.create(d.getLocalId()))
							.syncAt(TransactionItemSyncAt.create(d.getSyncAt()))
							.unitPrice(TransactionItemUnitPrice.create(d.getUnitPrice()))
							.total(TransactionItemTotal.create(d.getTotal()))
							.notes(TransactionItemNotes.create(d.getNotes()))
							.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete TransactionItem with id " + d.getId());
					}

					DeleteTransactionItemCommand delete = DeleteTransactionItemCommand.builder()
							.id(TransactionItemId.create(d.getId()))
							.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
