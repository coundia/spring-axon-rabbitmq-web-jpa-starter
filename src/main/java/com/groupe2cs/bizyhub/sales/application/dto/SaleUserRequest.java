package com.groupe2cs.bizyhub.sales.application.dto;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import java.util.UUID;
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
@Schema(name = "SaleUserRequest", description = "Request payload for SaleUser operations")
public class SaleUserRequest implements Serializable {

	@Schema(description = "", example = "abd48b50-2561-4394-90e7-21a6be72487b")
	private String sales;

	@Schema(description = "", example = "a9c656b5-3119-4d26-b125-e867ffff1fb2")
	private String users;

	@Schema(description = "", example = "246bf094-add8-4a57-9c00-a0cf9b000d0c")
	private String username;

	@Schema(description = "", example = "e359de98-b347-40c9-83f7-2b411c37187c")
	private String email;

	@Schema(description = "", example = "fc0607dc-9516-4792-a116-21fa2abcca3d")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "8fedd776-220d-4d13-859e-ea56adbe5404")
	private String reference;


}
