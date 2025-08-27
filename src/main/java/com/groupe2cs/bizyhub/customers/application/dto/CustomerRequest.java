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

	@Schema(description = "", example = "95a2c8de-98b1-44f2-ac77-781613e5e464")
	private String remoteId;
	@Schema(description = "", example = "f968d85a-1481-4555-adf3-4358dc92687e")
	private String localId;
	@Schema(description = "", example = "fd7e475c-1a0a-4c44-8ca7-c33a17b39259")
	private String code;
	@Schema(description = "", example = "21ac4a11-712c-43e0-9ff7-d731f2ea5d1d")
	private String firstName;
	@Schema(description = "", example = "8cbdb412-6403-4c02-a382-898478ca714c")
	private String lastName;
	@Schema(description = "", example = "5dca79b8-8248-47c9-9dc5-a8301f2835d7")
	private String fullName;
	@Schema(description = "", example = "8055.89")
	private Double balance;
	@Schema(description = "", example = "9781.96")
	private Double balanceDebt;
	@Schema(description = "", example = "f6d7f1c6-a701-46f4-a2bd-3dc4facc5ca3")
	private String phone;
	@Schema(description = "", example = "c7c4e313-032e-42f4-a226-4feaff28befe")
	private String email;
	@Schema(description = "", example = "177b5c17-4860-473c-8a20-c1e4231d3224")
	private String notes;
	@Schema(description = "", example = "553cee0d-7595-44ad-ae6c-f38b22d377ee")
	private String status;
	@Schema(description = "", example = "8b3520ab-cd1f-49d1-8896-fc7141ab439d")
	private String company;
	@Schema(description = "", example = "136364ca-55a0-4c0e-a52a-4c1db5f9add8")
	private String addressLine1;
	@Schema(description = "", example = "ed466f5c-ca51-47b5-8a1e-a4ce0751e034")
	private String addressLine2;
	@Schema(description = "", example = "e581a0ac-6eed-4dc6-8d14-0d6149c20783")
	private String city;
	@Schema(description = "", example = "72ff182e-08c0-4f06-8cc4-e2c6eedd1f06")
	private String region;
	@Schema(description = "", example = "afc287ff-2368-4a7a-aff4-8a36e3e8e9e5")
	private String country;
	@Schema(description = "", example = "f6b906d6-3751-4e0b-951a-4e969830b400")
	private String postalCode;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
