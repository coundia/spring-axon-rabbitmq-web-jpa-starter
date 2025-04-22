package com.groupe2cs.bizyhub.security.domain.event;

import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDeletedEvent implements Serializable {


	private UserId id;

}
