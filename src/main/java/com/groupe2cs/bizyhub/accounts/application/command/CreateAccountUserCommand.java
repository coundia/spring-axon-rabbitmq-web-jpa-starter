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
public class CreateAccountUserCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private AccountUserId id = AccountUserId.create(UUID.randomUUID().toString());
	private AccountUserName name;
	private AccountUserAccount account;
	private AccountUserUser user;
	private AccountUserUsername username;
	private AccountUserDetails details;
	private AccountUserIsActive isActive;
	private AccountUserUpdatedAt updatedAt;
	private AccountUserReference reference;
	private AccountUserCreatedBy createdBy;
	private AccountUserTenant tenant;

	public CreateAccountUserCommand(

			AccountUserName name,
			AccountUserAccount account,
			AccountUserUser user,
			AccountUserUsername username,
			AccountUserDetails details,
			AccountUserIsActive isActive,
			AccountUserUpdatedAt updatedAt,
			AccountUserReference reference,
			AccountUserCreatedBy createdBy,
			AccountUserTenant tenant
	) {
		this.id = AccountUserId.create(UUID.randomUUID().toString());

		this.name = name;
		this.account = account;
		this.user = user;
		this.username = username;
		this.details = details;
		this.isActive = isActive;
		this.updatedAt = updatedAt;
		this.reference = reference;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
