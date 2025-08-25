package com.groupe2cs.bizyhub.customers.application.dto;

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
@Schema(name = "CustomerDeltaDto", description = "Delta DTO for customer changes")
public class CustomerDeltaDto implements Serializable {

    @Schema(description = "Identifier of the customer", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "0b3c1ac0-9d45-44e0-a80f-91bd900aa240")
		private String remoteId;
		@Schema(description = "", example = "6b152002-b5db-4b7c-972f-1fcaaadaf829")
		private String localId;
		@Schema(description = "", example = "6b69d70f-830a-430d-9cb9-aa59429f6030")
		private String code;
		@Schema(description = "", example = "426bee0c-8425-4643-92b4-6eda6f7a42b1")
		private String firstName;
		@Schema(description = "", example = "b02ea011-375a-40b7-b2f0-02a410c8000e")
		private String lastName;
		@Schema(description = "", example = "5ebd4c10-53fa-4a48-9b15-e9408eed249e")
		private String fullName;
		@Schema(description = "", example = "1108.22")
		private Double balance;
		@Schema(description = "", example = "7753.76")
		private Double balanceDebt;
		@Schema(description = "", example = "e658c3c6-da72-4bd3-867a-f4e2be5832f4")
		private String phone;
		@Schema(description = "", example = "bae05241-dd8a-4442-abda-d23ce43f7ccf")
		private String email;
		@Schema(description = "", example = "6a7daa78-34c3-4547-bff5-ab21d2b61295")
		private String notes;
		@Schema(description = "", example = "f6abb9ec-ea70-4cb6-a6e7-f24366acc062")
		private String status;
		@Schema(description = "", example = "a95bd8f2-b1c6-4a15-985c-f7201c2c7cdf")
		private String company;
		@Schema(description = "", example = "c7ea33b7-f340-4277-9974-7413b51a94bd")
		private String addressLine1;
		@Schema(description = "", example = "00e0baae-4d2c-4bf5-8096-2284f0f72d6c")
		private String addressLine2;
		@Schema(description = "", example = "d9c06dbf-a8bc-4b54-ac5e-5cdfdac442e3")
		private String city;
		@Schema(description = "", example = "40bf55f2-640f-4b05-8e78-383177ae3e24")
		private String region;
		@Schema(description = "", example = "d6e7afb2-ed2f-4550-8769-e7015e92850b")
		private String country;
		@Schema(description = "", example = "5e19fe97-7997-4d9b-9ab2-d080fe2bf766")
		private String postalCode;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
