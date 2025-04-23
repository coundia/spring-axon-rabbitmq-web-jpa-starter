package com.groupe2cs.bizyhub.security.domain.event;

import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenExpiration;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenToken;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenUsername;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenCreatedEvent implements Serializable {

	private RefreshTokenId id;
	private RefreshTokenToken token;
	private RefreshTokenUsername username;
	private RefreshTokenExpiration expiration;


}
