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

		@Schema(description = "", example = "d57d9dc6-e1e0-4bc9-96de-542318697fa2")
		private String remoteId;
		@Schema(description = "", example = "271aec59-e06b-4d4d-beb4-fc7b1435cc68")
		private String localId;
		@Schema(description = "", example = "a468c862-2c93-489c-9054-962f0538a5d8")
		private String code;
		@Schema(description = "", example = "80c10423-11eb-4b5f-add1-3e2008a2b3b7")
		private String firstName;
		@Schema(description = "", example = "739763e4-e846-479a-8f3c-9508efde3b26")
		private String lastName;
		@Schema(description = "", example = "7a720ad3-b62d-45a0-af97-01eb5e4f85bd")
		private String fullName;
		@Schema(description = "", example = "7484.65")
		private Double balance;
		@Schema(description = "", example = "8390.7")
		private Double balanceDebt;
		@Schema(description = "", example = "cd886b38-bdc3-4faa-9a63-35e940603056")
		private String phone;
		@Schema(description = "", example = "f82a821c-2f13-427d-8f34-fe72447adc66")
		private String email;
		@Schema(description = "", example = "38f4d99c-51f3-48ad-a079-429373ea78b1")
		private String notes;
		@Schema(description = "", example = "77238733-bf23-46ff-93ad-e48edf40ee03")
		private String status;
		@Schema(description = "", example = "00c6eb6e-899a-4746-a5dc-d231561a0084")
		private String company;
		@Schema(description = "", example = "4826eee7-8ea0-461c-9012-d1b9a2224277")
		private String addressLine1;
		@Schema(description = "", example = "49b11668-a47b-4bea-9ea6-6ed6cf037b8c")
		private String addressLine2;
		@Schema(description = "", example = "f64f6ad6-8f96-4551-8567-b36985524633")
		private String city;
		@Schema(description = "", example = "6b47f149-3c24-4118-ae79-118d806b7113")
		private String region;
		@Schema(description = "", example = "019630cd-bd09-40f5-873a-ccb8bebe5ced")
		private String country;
		@Schema(description = "", example = "6008273e-c72e-4b8e-9908-bc6a6cb8db8b")
		private String postalCode;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
