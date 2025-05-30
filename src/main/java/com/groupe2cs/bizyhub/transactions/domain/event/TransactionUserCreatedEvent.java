package com.groupe2cs.bizyhub.transactions.domain.event;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionUserCreatedEvent implements Serializable {

	private TransactionUserId id;
	private TransactionUserName name;
	private TransactionUserTransaction transaction;
	private TransactionUserUser user;
	private TransactionUserUsername username;
	private TransactionUserDetails details;
	private TransactionUserIsActive isActive;
	private TransactionUserCreatedBy createdBy;
	private TransactionUserTenant tenant;


}
