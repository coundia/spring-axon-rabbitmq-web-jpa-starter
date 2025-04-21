package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserPassword;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserUsername;
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
	private UserId id;
	private UserUsername username;
	private UserPassword password;

	public CreateUserCommand(

			UserUsername username,
			UserPassword password
	) {
		this.id = UserId.create(UUID.randomUUID().toString());

		this.username = username;
		this.password = password;
	}


}
