package com.groupe2cs.bizyhub.balances.application.usecase;

import com.groupe2cs.bizyhub.balances.application.command.CreateBalanceCommand;
import com.groupe2cs.bizyhub.balances.application.command.DeleteBalanceCommand;
import com.groupe2cs.bizyhub.balances.application.command.UpdateBalanceCommand;
import com.groupe2cs.bizyhub.balances.application.dto.BalanceSyncRequest;
import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceSyncApplicationService {

	private final CommandGateway commandGateway;

	public void syncBalance(BalanceSyncRequest request,
							MetaRequest metaRequest

	) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {

					CreateBalanceCommand command = CreateBalanceCommand.builder()
							.name(BalanceName.create(d.getName()))
							.currency(BalanceCurrency.create(d.getCurrency()))
							.currentBalance(BalanceCurrentBalance.create(d.getCurrentBalance()))
							.previousBalance(BalancePreviousBalance.create(d.getPreviousBalance()))
							.lastUpdated(BalanceLastUpdated.create(d.getLastUpdated()))
							.isDefault(BalanceIsDefault.create(d.getIsDefault()))
							.ordre(BalanceOrdre.create(d.getOrdre()))
							.isArchived(BalanceIsArchived.create(d.getIsArchived()))
							.isAllowDebit(BalanceIsAllowDebit.create(d.getIsAllowDebit()))
							.isAllowCredit(BalanceIsAllowCredit.create(d.getIsAllowCredit()))
							.isExcluTotal(BalanceIsExcluTotal.create(d.getIsExcluTotal()))
							.activateNotification(BalanceActivateNotification.create(d.getActivateNotification()))
							.syncedAt(BalanceSyncedAt.create(d.getSyncedAt()))
							.build();
					if (metaRequest.getTenantId() != null) {
						command.setTenant(BalanceTenant.create(metaRequest.getTenantId()));
					}
					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(BalanceCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(
							command
					);

				}
				case "UPDATE" -> {
					UpdateBalanceCommand update = UpdateBalanceCommand.builder()
							.id(BalanceId.create(d.getId()))
							.name(BalanceName.create(d.getName()))
							.currency(BalanceCurrency.create(d.getCurrency()))
							.currentBalance(BalanceCurrentBalance.create(d.getCurrentBalance()))
							.previousBalance(BalancePreviousBalance.create(d.getPreviousBalance()))
							.lastUpdated(BalanceLastUpdated.create(d.getLastUpdated()))
							.isDefault(BalanceIsDefault.create(d.getIsDefault()))
							.ordre(BalanceOrdre.create(d.getOrdre()))
							.isArchived(BalanceIsArchived.create(d.getIsArchived()))
							.isAllowDebit(BalanceIsAllowDebit.create(d.getIsAllowDebit()))
							.isAllowCredit(BalanceIsAllowCredit.create(d.getIsAllowCredit()))
							.isExcluTotal(BalanceIsExcluTotal.create(d.getIsExcluTotal()))
							.activateNotification(BalanceActivateNotification.create(d.getActivateNotification()))
							.syncedAt(BalanceSyncedAt.create(d.getSyncedAt()))
							.build();

					if (metaRequest.getTenantId() != null) {
						//command.setTenant(BalanceTenant.create(metaRequest.getTenantId()));
					}
					if (metaRequest.getUserId() != null) {
						//command.setCreatedBy( BalanceCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(
							update
					);

				}
				case "DELETE" -> {
					DeleteBalanceCommand delete = DeleteBalanceCommand.builder()
							.id(BalanceId.create(d.getId()))
							.build();

					if (metaRequest.getTenantId() != null) {
						//delete.setTenant(BalanceTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						//delete.setCreatedBy( BalanceCreatedBy.create(metaRequest.getUserId()));
					}
					commandGateway.sendAndWait(
							delete
					);
				}
			}
		}
	}
}
