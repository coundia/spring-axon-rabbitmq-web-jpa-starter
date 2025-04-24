package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.command.UpdateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionSyncRequest;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionAmount;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionCreatedBy;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionReference;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionSyncApplicationService {

	private final CommandGateway commandGateway;

	public void syncTransaction(TransactionSyncRequest request, String userId) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {

					CreateTransactionCommand command = CreateTransactionCommand.builder()
							.reference(TransactionReference.create(d.getReference()))
							.amount(TransactionAmount.create(d.getAmount()))
							.build();

					if (userId != null) {
						command.setCreatedBy(TransactionCreatedBy.create(userId));
					}

					commandGateway.sendAndWait(
							command
					);

				}
				case "UPDATE" -> {
					UpdateTransactionCommand update = UpdateTransactionCommand.builder()
							.id(TransactionId.create(d.getId()))
							.reference(TransactionReference.create(d.getReference()))
							.amount(TransactionAmount.create(d.getAmount()))
							.build();

					if (userId != null) {
						//update.setUpdatedBy(TransactionUpdatedBy.create(userId));
					}

					commandGateway.sendAndWait(
							update
					);

				}
				case "DELETE" -> {
					DeleteTransactionCommand delete = DeleteTransactionCommand.builder()
							.id(TransactionId.create(d.getId()))
							.build();

					if (userId != null) {
						//delete.setDeletedBy(TransactionDeletedBy.create(userId));
					}
					commandGateway.sendAndWait(
							delete
					);
				}
			}
		}
	}
}
