package com.groupe2cs.bizyhub.tenant.application.command;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;

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
public class DeleteTenantCommand implements Serializable {
@TargetAggregateIdentifier
	private TenantId id;
        
        
        
        
        
        
        


}
