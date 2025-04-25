package com.groupe2cs.bizyhub.tenant.application.dto;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.*;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TenantResponse", description = "Response payload for Tenant")
public class TenantResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String name;
	@Schema(description = "", example = "")
	private String description;
	@Schema(description = "", example = "")
	private String domain;
	@Schema(description = "", example = "")
	private String language;
	@Schema(description = "", example = "")
	private Boolean active;
	@Schema(description = "", example = "")
	private String createdBy;

}
