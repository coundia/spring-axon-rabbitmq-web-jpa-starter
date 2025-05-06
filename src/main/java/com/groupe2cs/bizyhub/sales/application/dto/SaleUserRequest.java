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

	@Schema(description = "", example = "4bfbe81d-ee9d-4f0f-b696-cbdfe861b202")
	private String sales;

	@Schema(description = "", example = "df6fba4d-fa05-4f59-b85c-80abae23e273")
	private String users;

	@Schema(description = "", example = "f0b322fa-480a-44ec-aa97-e67145150eae")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "9d480208-19ab-400e-878d-5f647f422aa4")
	private String reference;


}
