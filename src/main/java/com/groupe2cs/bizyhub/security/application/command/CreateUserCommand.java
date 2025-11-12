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

	public CreateUserCommand(

			UserUsername username,
			UserPassword password,
			UserFirstName firstName,
			UserLastName lastName,
			UserEmail email,
			UserTelephone telephone,
			UserLimitPerDay limitPerDay,
			UserIsPremium isPremium,
			UserEnabled enabled,
			UserIsBan isBan,
			UserMessage message,
			UserCreatedBy createdBy,
			UserTenant tenant
	) {
		this.id = UserId.create(UUID.randomUUID().toString());

		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.telephone = telephone;
		this.limitPerDay = limitPerDay;
		this.isPremium = isPremium;
		this.enabled = enabled;
		this.isBan = isBan;
		this.message = message;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
