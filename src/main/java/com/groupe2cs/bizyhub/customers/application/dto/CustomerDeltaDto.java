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

		@Schema(description = "", example = "0f8daa9e-828d-4f85-8c73-2ecbe4ef3b16")
		private String remoteId;
		@Schema(description = "", example = "a7de332f-7f84-40fd-983c-f61f1b5ffe1a")
		private String code;
		@Schema(description = "", example = "1ff89472-ef65-4153-bcba-f9f15879bfac")
		private String firstName;
		@Schema(description = "", example = "4f630c38-be33-4276-ac77-112ae5dc7e6f")
		private String lastName;
		@Schema(description = "", example = "933530fb-7e88-4614-b3e9-da433c053864")
		private String fullName;
		@Schema(description = "", example = "3852.55")
		private Double balance;
		@Schema(description = "", example = "4076.86")
		private Double balanceDebt;
		@Schema(description = "", example = "0f0a95f4-1986-4d96-9b3b-6e534023a3a7")
		private String phone;
		@Schema(description = "", example = "b5c1449c-a668-4378-acec-732d7b24f21b")
		private String email;
		@Schema(description = "", example = "ccf831ce-f4d3-41f5-9a6c-c12fe8cedb76")
		private String notes;
		@Schema(description = "", example = "1870cb3d-56e3-4229-9c29-f4979cdf3f9b")
		private String status;
		@Schema(description = "", example = "d8b54acc-66b7-4343-aa82-c37a944db2ce")
		private String company;
		@Schema(description = "", example = "324c7226-1808-43e1-ba7e-408289a153cb")
		private String addressLine1;
		@Schema(description = "", example = "f08db0ed-8cc1-4e02-817d-44d60a69f587")
		private String addressLine2;
		@Schema(description = "", example = "cec86752-f69d-4db9-bbb9-1ac800165b15")
		private String city;
		@Schema(description = "", example = "630ba6e7-a64a-45fc-8072-87afdd15be8b")
		private String region;
		@Schema(description = "", example = "c174103f-5613-42af-9381-1fa437b5e744")
		private String country;
		@Schema(description = "", example = "5a1b70cb-1159-4ebe-bb18-422564e30b60")
		private String postalCode;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
