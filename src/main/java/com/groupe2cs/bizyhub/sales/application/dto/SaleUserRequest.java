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

	@Schema(description = "", example = "4120db42-2d10-45ad-bfb6-9a93cd13b9bc")
	private String name;

	@Schema(description = "", example = "ca356b46-da1c-48cd-8a58-d2e7c89a026f")
	private String sales;

	@Schema(description = "", example = "00fe48d5-8e37-4f80-a58c-cce398308b82")
	private String users;

	@Schema(description = "", example = "fa2b7545-0d44-45d1-8161-bc0d654fb713")
	private String username;

	@Schema(description = "", example = "e4b02cae-df45-401f-aa66-21ae3ec62f22")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "0c459bd3-4c7e-4bbd-b6bb-60b536b5b62e")
	private String reference;


}
