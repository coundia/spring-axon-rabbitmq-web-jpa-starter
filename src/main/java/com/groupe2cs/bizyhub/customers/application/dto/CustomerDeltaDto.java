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

		@Schema(description = "", example = "b4cc1309-b0dc-4a24-aa63-270af5bcedbb")
		private String remoteId;
		@Schema(description = "", example = "dc8e0a00-0300-432f-bad6-57074bc57e01")
		private String code;
		@Schema(description = "", example = "8a2915b9-9a46-46cf-b8a1-e38bcad9b09b")
		private String firstName;
		@Schema(description = "", example = "622edc05-479f-4f27-b292-6a6aa8f97f73")
		private String lastName;
		@Schema(description = "", example = "a70505a8-3812-44ea-aaa7-8f994130a56f")
		private String fullName;
		@Schema(description = "", example = "4201.78")
		private Double balance;
		@Schema(description = "", example = "4906.93")
		private Double balanceDebt;
		@Schema(description = "", example = "8ee77b25-2921-4d63-8ccd-95994adf0f96")
		private String phone;
		@Schema(description = "", example = "303e1780-ad92-4b88-9df5-ce65f36c5294")
		private String email;
		@Schema(description = "", example = "14e6c7d0-0e01-4439-b897-0929393dc334")
		private String notes;
		@Schema(description = "", example = "221bb6c9-c20e-4e49-b561-568e9518dd53")
		private String status;
		@Schema(description = "", example = "ee7ee82d-e304-4913-9db9-29c0410430e7")
		private String company;
		@Schema(description = "", example = "28049981-13c3-4891-81e2-48a240cd66c1")
		private String addressLine1;
		@Schema(description = "", example = "eff274a8-e208-434c-bc61-9d9fbb10a157")
		private String addressLine2;
		@Schema(description = "", example = "d4b584dc-dfb2-4579-a8c7-0ddbcd22031e")
		private String city;
		@Schema(description = "", example = "a4d0581b-3357-4776-8d4a-bd733789cc3f")
		private String region;
		@Schema(description = "", example = "b4876bb2-9d3a-41bc-851a-f03531f05927")
		private String country;
		@Schema(description = "", example = "afe13a1e-5328-43f5-8c2b-5d6f4d294cd0")
		private String postalCode;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
