package com.groupe2cs.bizyhub.accounts.domain.event;

	import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreatedEvent implements Serializable {

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
