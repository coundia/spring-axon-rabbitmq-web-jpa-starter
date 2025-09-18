package com.groupe2cs.bizyhub.security.application.dto;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
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
@Schema(name = "RoleResponse", description = "Response payload for Role")
public class RoleResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String name;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
