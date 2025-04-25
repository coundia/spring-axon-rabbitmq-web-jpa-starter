package com.groupe2cs.bizyhub.security.domain.event;

	import com.groupe2cs.bizyhub.security.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedEvent implements Serializable {

	private UserId id;
	private UserUsername username;
	private UserPassword password;
	private UserCreatedBy createdBy;
	private UserTenant tenant;



}
