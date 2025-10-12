package com.groupe2cs.bizyhub.tenant.domain.event;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;

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
public class TenantDeletedEvent implements Serializable {


	private TenantId id;

}
