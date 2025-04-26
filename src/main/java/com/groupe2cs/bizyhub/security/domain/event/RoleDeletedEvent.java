package com.groupe2cs.bizyhub.security.domain.event;

import com.groupe2cs.bizyhub.security.domain.valueObject.RoleId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDeletedEvent implements Serializable {


	private RoleId id;

}
