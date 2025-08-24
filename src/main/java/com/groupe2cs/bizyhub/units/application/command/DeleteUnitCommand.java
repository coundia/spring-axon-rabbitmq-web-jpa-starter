package com.groupe2cs.bizyhub.units.application.command;

import com.groupe2cs.bizyhub.units.domain.valueObject.*;

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
public class DeleteUnitCommand implements Serializable {
@TargetAggregateIdentifier
	private UnitId id;
 	
 	
 	
 	
 	
 	
 	
 	


}
