package com.groupe2cs.bizyhub.customers.application.dto;

import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
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
@Schema(name = "CustomerRequest", description = "Request payload for Customer operations")
public class CustomerRequest implements Serializable {

	@Schema(description = "", example = "bda2fb6e-2195-429b-96cb-afa7e656a08c")
	private String remoteId;
	@Schema(description = "", example = "d1e17650-4372-4002-b3e9-cf45873c4809")
	private String code;
	@Schema(description = "", example = "092762dd-03cc-4f7a-bf65-9615ab2c7b1d")
	private String firstName;
	@Schema(description = "", example = "11dd0271-eae5-4ffc-b39c-8b3d92a5286b")
	private String lastName;
	@Schema(description = "", example = "3daf4598-1d8c-481d-a932-a4be8f76ea9e")
	private String fullName;
	@Schema(description = "", example = "1045.65")
	private Double balance;
	@Schema(description = "", example = "9453.04")
	private Double balanceDebt;
	@Schema(description = "", example = "8b1ab226-3a7a-4800-8c2b-941bab491aad")
	private String phone;
	@Schema(description = "", example = "0da4d8df-8878-4802-8f96-ec9bd14ff7e1")
	private String email;
	@Schema(description = "", example = "b2a3646c-5484-4efb-bbe6-65346d35294d")
	private String notes;
	@Schema(description = "", example = "94409e25-94f3-4737-bbcc-179165f09e37")
	private String status;
	@Schema(description = "", example = "169c82dd-f730-407a-97de-2c20790c5643")
	private String company;
	@Schema(description = "", example = "8dabf799-4d30-4ede-b9f3-7be5e7de8993")
	private String addressLine1;
	@Schema(description = "", example = "2957d211-a6d3-4f68-b6ce-59a91ded0d77")
	private String addressLine2;
	@Schema(description = "", example = "904835c4-0134-40cc-b905-860e4adb7fa7")
	private String city;
	@Schema(description = "", example = "594914ec-a1c0-436a-af54-1719088dd17d")
	private String region;
	@Schema(description = "", example = "cd61413d-2f03-483c-b448-0875fbe16c5b")
	private String country;
	@Schema(description = "", example = "63491165-7f4d-49c1-9971-9540a1026cb7")
	private String postalCode;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
