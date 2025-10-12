package com.groupe2cs.bizyhub.security.domain.event;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

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
public class UserUpdatedEvent implements Serializable {

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
