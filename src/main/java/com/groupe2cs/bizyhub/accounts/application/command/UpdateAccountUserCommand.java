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
public class UpdateAccountUserCommand implements Serializable {
	@TargetAggregateIdentifier
	private AccountUserId id;
	private AccountUserName name;
	private AccountUserAccount account;
	private AccountUserUser user;
	private AccountUserUsername username;
	private AccountUserDetails details;
	private AccountUserIsActive isActive;
	private AccountUserCreatedBy createdBy;
	private AccountUserTenant tenant;


}
