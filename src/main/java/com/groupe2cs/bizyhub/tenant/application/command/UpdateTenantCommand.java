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
public class UpdateTenantCommand implements Serializable {
@TargetAggregateIdentifier
	private TenantId id;
        private TenantName name;
        private TenantDescription description;
        private TenantDomain domain;
        private TenantLanguage language;
        private TenantActive active;
        private TenantTenant tenant;
        private TenantCreatedBy createdBy;


}
