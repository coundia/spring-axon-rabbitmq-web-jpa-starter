package com.groupe2cs.bizyhub.tenant.domain.event;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TenantDeletedEvent implements Serializable {


	private TenantId id;

}
