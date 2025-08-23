package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;


import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateVerificationCodeCommand implements Serializable {
@TargetAggregateIdentifier
	private VerificationCodeId id;
 	private VerificationCodeToken token;
 	private VerificationCodeUsername username;
 	private VerificationCodePhone phone;
 	private VerificationCodeEmail email;
 	private VerificationCodeCode code;
 	private VerificationCodeStatus status;
 	private VerificationCodeSource source;
 	private VerificationCodeExpiration expiration;
 	private VerificationCodeCreatedBy createdBy;
 	private VerificationCodeTenant tenant;


}
