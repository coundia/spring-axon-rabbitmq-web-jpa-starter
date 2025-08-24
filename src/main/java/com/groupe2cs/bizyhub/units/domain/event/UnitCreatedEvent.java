package com.groupe2cs.bizyhub.units.domain.event;

	import com.groupe2cs.bizyhub.units.domain.valueObject.*;

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
public class UnitCreatedEvent implements Serializable {

	private UnitId id;
	private UnitRemoteId remoteId;
	private UnitLocalId localId;
	private UnitCode code;
	private UnitName name;
	private UnitSyncAt syncAt;
	private UnitDescription description;
	private UnitCreatedBy createdBy;
	private UnitTenant tenant;



}
