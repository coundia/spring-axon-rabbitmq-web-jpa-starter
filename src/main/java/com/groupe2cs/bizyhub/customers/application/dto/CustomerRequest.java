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

	@Schema(description = "", example = "da409eef-8ae3-4429-bf8f-12f006118cdc")
	private String remoteId;
	@Schema(description = "", example = "b91666af-4e61-4460-b241-00a9f22ba9e7")
	private String localId;
	@Schema(description = "", example = "637e8a1f-04bf-4d9f-9c8d-b1e6af1dd7f4")
	private String code;
	@Schema(description = "", example = "15b4e1a8-02b5-48eb-8b86-d54dc60f2081")
	private String firstName;
	@Schema(description = "", example = "3758b32c-2086-4274-a0a3-c766c40c260a")
	private String lastName;
	@Schema(description = "", example = "13c97731-1716-4ec3-b04e-af9c33fbed00")
	private String fullName;
	@Schema(description = "", example = "2659.11")
	private Double balance;
	@Schema(description = "", example = "2342.9")
	private Double balanceDebt;
	@Schema(description = "", example = "8fc9a5b9-828d-4c0d-9ea0-b14769e4414c")
	private String phone;
	@Schema(description = "", example = "c37ca43c-8640-417a-8ea4-df0a115296a1")
	private String email;
	@Schema(description = "", example = "43601934-cc55-4131-b804-a8331384c4ce")
	private String notes;
	@Schema(description = "", example = "1ab6fb29-395b-476a-b373-14dac06084d7")
	private String status;
	@Schema(description = "", example = "cc9092e3-eb67-42ae-bd67-11f1bd32fe88")
	private String company;
	@Schema(description = "", example = "02595e4d-0617-4d68-ac6f-011107cd2c11")
	private String addressLine1;
	@Schema(description = "", example = "fc59f7d2-39c1-4598-ba88-be528991a73a")
	private String addressLine2;
	@Schema(description = "", example = "be558ccb-6c8f-4cf0-ad8e-ff2c4fad5ddb")
	private String city;
	@Schema(description = "", example = "ef44d909-9dce-4ff3-8cc7-eba748a8a38a")
	private String region;
	@Schema(description = "", example = "bc6d0a99-5a37-483c-adee-f96e4d16f6b8")
	private String country;
	@Schema(description = "", example = "d5d26a94-48df-4d14-9a8f-44f115a68913")
	private String postalCode;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
