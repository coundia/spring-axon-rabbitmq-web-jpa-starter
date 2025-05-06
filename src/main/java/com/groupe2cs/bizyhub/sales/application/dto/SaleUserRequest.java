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

	@Schema(description = "", example = "02e7af4e-9656-4d83-b13c-66cedfc285df")
	private String sales;

	@Schema(description = "", example = "343fb0d6-1651-43b2-a787-7fcfb525fa31")
	private String users;

	@Schema(description = "", example = "80caf626-feac-4bae-bb1b-99356a77c979")
	private String username;

	@Schema(description = "", example = "8644bcbc-d044-47a4-8ff5-0a7eed2c3985")
	private String email;

	@Schema(description = "", example = "9f78e924-4163-4fb3-b621-dc77dea3e07f")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "48215749-547d-44de-ba7f-e447aa29c519")
	private String reference;


}
