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

		@Schema(description = "", example = "5b9ef6a0-6c57-4829-8dc6-5c3a14558bdb")
		private String remoteId;
		@Schema(description = "", example = "75bfeb7d-427d-4e5e-82bd-5fb15b94f0a5")
		private String localId;
		@Schema(description = "", example = "63325eed-12ad-46a2-b998-f50c37c0299a")
		private String code;
		@Schema(description = "", example = "20fda47f-62f0-42e6-be6e-ed54b0825d66")
		private String firstName;
		@Schema(description = "", example = "b0b0cd64-a0b0-45ab-847a-0ee90422f6b5")
		private String lastName;
		@Schema(description = "", example = "9b177b07-7f57-4a4a-92a4-728976733e7d")
		private String fullName;
		@Schema(description = "", example = "1984.0")
		private Double balance;
		@Schema(description = "", example = "2085.91")
		private Double balanceDebt;
		@Schema(description = "", example = "bd42f5fc-ae08-49e3-b8bf-1fbd931f06a7")
		private String phone;
		@Schema(description = "", example = "fc8e3c8d-740f-4941-b325-44ab3c1f2964")
		private String email;
		@Schema(description = "", example = "e666cb4f-751d-4500-8f7c-6f81b5ab1bbb")
		private String notes;
		@Schema(description = "", example = "d097d3af-e043-4625-b144-f1095fcc4d2d")
		private String status;
		@Schema(description = "", example = "c839c984-954d-4e96-8635-73b40a265397")
		private String company;
		@Schema(description = "", example = "d8bc5de5-c0ca-49da-ab49-9c884b37c54a")
		private String addressLine1;
		@Schema(description = "", example = "ca86aa3b-045c-4b4a-96a5-fd05dfb52f08")
		private String addressLine2;
		@Schema(description = "", example = "442154ab-2cee-4e54-8bed-caf0df1513c5")
		private String city;
		@Schema(description = "", example = "598ed33b-a8a7-43ce-aa26-075ae4a9e0e8")
		private String region;
		@Schema(description = "", example = "b81b7fc3-6807-4893-931a-8ff4a02c4a00")
		private String country;
		@Schema(description = "", example = "a5b2dbf4-ffab-4f93-95a1-229bc932ed37")
		private String postalCode;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
