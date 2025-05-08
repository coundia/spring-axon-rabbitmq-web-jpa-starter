package com.groupe2cs.bizyhub.accounts.application.command;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;


import java.time.*;
import java.util.*;

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
