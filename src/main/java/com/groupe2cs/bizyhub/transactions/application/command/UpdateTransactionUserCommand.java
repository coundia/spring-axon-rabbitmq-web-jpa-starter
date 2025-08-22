package com.groupe2cs.bizyhub.transactions.application.command;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;

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
public class UpdateTransactionUserCommand implements Serializable {
@TargetAggregateIdentifier
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
