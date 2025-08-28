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

		@Schema(description = "", example = "bf1adea4-00d9-4c66-9ad8-e906b2476a52")
		private String remoteId;
		@Schema(description = "", example = "efc40e2d-bb22-4caf-a5ff-b2f6d5d1d5b2")
		private String localId;
		@Schema(description = "", example = "96cded50-4e45-4a16-b768-00efb6edb802")
		private String code;
		@Schema(description = "", example = "fdde0585-2b57-4b6e-9abc-585069ffc09a")
		private String firstName;
		@Schema(description = "", example = "1e58f7d9-ea3b-4153-bb90-d6a572f9be71")
		private String lastName;
		@Schema(description = "", example = "0db95f44-a360-4f3d-95f3-a0c120184a58")
		private String fullName;
		@Schema(description = "", example = "3922.76")
		private Double balance;
		@Schema(description = "", example = "4845.39")
		private Double balanceDebt;
		@Schema(description = "", example = "5c50b6a2-aaf7-469c-ab1b-effbc1466ec3")
		private String phone;
		@Schema(description = "", example = "9fe8648f-af11-4e0a-8f97-230e987393e1")
		private String email;
		@Schema(description = "", example = "ba62a125-feeb-4a94-a6d6-73473f56f486")
		private String notes;
		@Schema(description = "", example = "218dff3a-2841-4538-b957-bddbe1971ff5")
		private String status;
		@Schema(description = "", example = "ef1bd711-1309-4d37-aa9b-01b3c98bbe52")
		private String account;
		@Schema(description = "", example = "109890be-7764-49f6-918a-0b606bdf70ae")
		private String company;
		@Schema(description = "", example = "ef6f8ea5-a5c0-4dd5-a91a-aa6dc2b1b6b9")
		private String addressLine1;
		@Schema(description = "", example = "c3c00b10-5fcf-4ca4-8cd9-ecbef9679f75")
		private String addressLine2;
		@Schema(description = "", example = "80632ae7-81b4-421d-9f9d-377106d05829")
		private String city;
		@Schema(description = "", example = "699ec175-1568-49f5-9868-260eb74e33ce")
		private String region;
		@Schema(description = "", example = "b2d74657-8188-4144-9794-6b19342af8dd")
		private String country;
		@Schema(description = "", example = "e8058b73-f912-42a7-b6f0-8a1459a94303")
		private String postalCode;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
