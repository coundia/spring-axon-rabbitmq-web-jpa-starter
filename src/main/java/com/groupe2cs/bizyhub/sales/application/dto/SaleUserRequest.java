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

	@Schema(description = "", example = "1107d6b2-539f-4714-bc20-1da67d87e509")
	private String name;

	@Schema(description = "", example = "a4ceaa43-bc48-49ef-9f76-e105a8d1ef39")
	private String sale;

	@Schema(description = "", example = "33179b63-cc83-43c7-9750-7b2add01b2a6")
	private String user;

	@Schema(description = "", example = "c8aea8b3-eaba-45f5-8880-fa10fe6a2dee")
	private String username;

	@Schema(description = "", example = "53fce01f-fb81-4687-8762-1e841ae3d03e")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "3c2ab370-0ded-4e07-b80f-b269907dc002")
	private String reference;


}
