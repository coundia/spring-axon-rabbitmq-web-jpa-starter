package com.groupe2cs.bizyhub.companies.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "CompanyDeltaDto", description = "Delta DTO for company changes")
public class CompanyDeltaDto implements Serializable {

    @Schema(description = "Identifier of the company", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "9c1b0256-dbe1-4595-9a1c-21fb3662a9fd")
		private String remoteId;
		@Schema(description = "", example = "b8361052-bf10-48f2-833b-121e80d5f68f")
		private String localId;
		@Schema(description = "", example = "4e0e81cc-0e27-4278-8ab7-9f640456fff6")
		private String code;
		@Schema(description = "", example = "a2b7a896-396e-47ec-abfe-323a395c082f")
		private String name;
		@Schema(description = "", example = "6434c449-0f61-4e55-b6b6-31837a265df9")
		private String description;
		@Schema(description = "", example = "46d1c496-6e0a-4d26-9614-3902ca692ddb")
		private String phone;
		@Schema(description = "", example = "2b7669be-4621-427b-aa95-fb9a46d5cfd3")
		private String email;
		@Schema(description = "", example = "6f3c4795-68f3-499c-b7f8-605062bd7adc")
		private String website;
		@Schema(description = "", example = "3b0fa9c6-31dd-4f67-b089-ed5e9f49a717")
		private String taxId;
		@Schema(description = "", example = "ac509990-72df-4a52-ae80-290b3c4ad62c")
		private String currency;
		@Schema(description = "", example = "9516c21b-01eb-4381-be5a-3ce232f14bfa")
		private String addressLine1;
		@Schema(description = "", example = "c1a8b519-6af0-4024-915b-2f451d0c86f6")
		private String addressLine2;
		@Schema(description = "", example = "334db9d3-4ec3-491c-9c02-dfe456ca9afb")
		private String city;
		@Schema(description = "", example = "16749707-74ad-4910-9a11-43c0ce8881e8")
		private String region;
		@Schema(description = "", example = "f66ad045-e94d-458b-a172-7009b6f91688")
		private String country;
		@Schema(description = "", example = "29cb7964-4d80-45b6-9da0-a1ec1d21caea")
		private String account;
		@Schema(description = "", example = "7f5f3222-0b3c-4ca2-9842-f83b77cd4d1d")
		private String postalCode;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "false")
		private Boolean isDefault;

}
