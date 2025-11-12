package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
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
	private UserFirstName firstName;
	private UserLastName lastName;
	private UserEmail email;
	private UserTelephone telephone;
	private UserLimitPerDay limitPerDay;
	private UserIsPremium isPremium;
	private UserEnabled enabled;
	private UserIsBan isBan;
	private UserMessage message;
	private UserCreatedBy createdBy;
	private UserTenant tenant;


}
