package com.groupe2cs.bizyhub.debts.application.usecase;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.debts.application.command.*;
import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.debts.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class DebtSyncApplicationService {

	private final DebtGate gateService;
	private final CommandGateway commandGateway;

	public void syncDebt(DebtSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateDebtCommand command = CreateDebtCommand.builder()
								.remoteId(DebtRemoteId.create(d.getRemoteId()))
								.localId(DebtLocalId.create(d.getLocalId()))
								.code(DebtCode.create(d.getCode()))
								.notes(DebtNotes.create(d.getNotes()))
								.balance(DebtBalance.create(d.getBalance()))
								.balanceDebt(DebtBalanceDebt.create(d.getBalanceDebt()))
								.dueDate(DebtDueDate.create(d.getDueDate()))
								.statuses(DebtStatuses.create(d.getStatuses()))
								.account(DebtAccount.create(d.getAccount()))
								.syncAt(DebtSyncAt.create(d.getSyncAt()))
								.customer(DebtCustomer.create(d.getCustomer()))
								.isActive(DebtIsActive.create(d.getIsActive()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(DebtTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(DebtCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Debt with id " + d.getId());
					}

					UpdateDebtCommand update = UpdateDebtCommand.builder()
							.id(DebtId.create(d.getId()))
							.remoteId(DebtRemoteId.create(d.getRemoteId()))
							.localId(DebtLocalId.create(d.getLocalId()))
							.code(DebtCode.create(d.getCode()))
							.notes(DebtNotes.create(d.getNotes()))
							.balance(DebtBalance.create(d.getBalance()))
							.balanceDebt(DebtBalanceDebt.create(d.getBalanceDebt()))
							.dueDate(DebtDueDate.create(d.getDueDate()))
							.statuses(DebtStatuses.create(d.getStatuses()))
							.account(DebtAccount.create(d.getAccount()))
							.syncAt(DebtSyncAt.create(d.getSyncAt()))
							.customer(DebtCustomer.create(d.getCustomer()))
							.isActive(DebtIsActive.create(d.getIsActive()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Debt with id " + d.getId());
					}

					DeleteDebtCommand delete = DeleteDebtCommand.builder()
						.id(DebtId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
