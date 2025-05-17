package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private UserId id = UserId.create(UUID.randomUUID().toString());
	private UserUsername username;
	private UserPassword password;
	private UserCreatedBy createdBy;
	private UserTenant tenant;

	public CreateUserCommand(

			UserUsername username,
			UserPassword password,
			UserCreatedBy createdBy,
			UserTenant tenant
	) {
		this.id = UserId.create(UUID.randomUUID().toString());

		this.username = username;
		this.password = password;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
