package com.groupe2cs.bizyhub.accounts.application.command;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAccountCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private AccountId id = AccountId.create(UUID.randomUUID().toString());
	private AccountName name;
	private AccountCurrency currency;
	private AccountCurrentBalance currentBalance;
	private AccountPreviousBalance previousBalance;
	private AccountDetails details;
	private AccountIsActive isActive;
	private AccountCreatedBy createdBy;
	private AccountTenant tenant;

	public CreateAccountCommand(

			AccountName name,
			AccountCurrency currency,
			AccountCurrentBalance currentBalance,
			AccountPreviousBalance previousBalance,
			AccountDetails details,
			AccountIsActive isActive,
			AccountCreatedBy createdBy,
			AccountTenant tenant
	) {
		this.id = AccountId.create(UUID.randomUUID().toString());

		this.name = name;
		this.currency = currency;
		this.currentBalance = currentBalance;
		this.previousBalance = previousBalance;
		this.details = details;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
