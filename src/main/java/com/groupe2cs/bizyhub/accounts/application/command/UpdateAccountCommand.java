package com.groupe2cs.bizyhub.accounts.application.command;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAccountCommand implements Serializable {
	@TargetAggregateIdentifier
	private AccountId id;
	private AccountName name;
	private AccountCurrency currency;
	private AccountCurrentBalance currentBalance;
	private AccountPreviousBalance previousBalance;
	private AccountDetails details;
	private AccountIsActive isActive;
	private AccountUpdatedAt updatedAt;
	private AccountReference reference;
	private AccountCreatedBy createdBy;
	private AccountTenant tenant;


}
