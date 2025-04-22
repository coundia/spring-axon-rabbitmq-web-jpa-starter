package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserPassword;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserUsername;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserCommand implements Serializable {
	@TargetAggregateIdentifier
	private UserId id;
	private UserUsername username;
	private UserPassword password;


}
