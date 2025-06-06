package com.groupe2cs.bizyhub.security.domain.event;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetCreatedEvent implements Serializable {

	private PasswordResetId id;
	private PasswordResetToken token;
	private PasswordResetUsername username;
	private PasswordResetExpiration expiration;
	private PasswordResetCreatedBy createdBy;
	private PasswordResetTenant tenant;


}
