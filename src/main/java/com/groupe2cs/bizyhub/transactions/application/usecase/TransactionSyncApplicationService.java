package com.groupe2cs.bizyhub.transactions.application.usecase;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TransactionSyncApplicationService {

	private final CommandGateway commandGateway;

	public void syncTransaction(TransactionSyncRequest request) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> commandGateway.sendAndWait(
					CreateTransactionCommand.builder()
								.reference(TransactionReference.create(d.getReference()))
								.amount(TransactionAmount.create(d.getAmount()))
						.build()
		);
		case "UPDATE" -> commandGateway.sendAndWait(
					UpdateTransactionCommand.builder()
								.id(TransactionId.create(d.getId()))
								.reference(TransactionReference.create(d.getReference()))
								.amount(TransactionAmount.create(d.getAmount()))
						.build()
		);
		case "DELETE" -> commandGateway.sendAndWait(
					DeleteTransactionCommand.builder()
									.id(TransactionId.create(d.getId()) )
									.build()
				);
			}
		}
	}
}
