package com.groupe2cs.bizyhub.tenant.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TenantRequest", description = "Request payload for Tenant operations")
public class TenantRequest implements Serializable {

	@Schema(description = "", example = "5b33c71e-1a07-44c8-89b4-a9767d51365a")
	private String name;

	@Schema(description = "", example = "57423691-4993-4746-b20a-506c4825e346")
	private String description;

	@Schema(description = "", example = "44f3dac7-1d1a-4cc0-8e1a-7c937384b105")
	private String domain;

	@Schema(description = "", example = "fff71b9b-ffe5-4079-bc07-41c4fc202810")
	private String language;

	@Schema(description = "", example = "true")
	private Boolean active;


}
