package com.groupe2cs.bizyhub.accounts.domain.event;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountUserCreatedEvent implements Serializable {

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
