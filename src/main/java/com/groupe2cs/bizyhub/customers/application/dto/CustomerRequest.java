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

	@Schema(description = "", example = "b307c14d-ba71-40c6-9bfa-4a0fa8f1a8c2")
	private String remoteId;
	@Schema(description = "", example = "5e95f217-92cf-48ab-ba58-55f6ea0b4aa4")
	private String code;
	@Schema(description = "", example = "27498fcc-1055-480e-bf0b-d633e53e43c3")
	private String firstName;
	@Schema(description = "", example = "2ed5a71a-eb2e-44b1-b294-584ce207a347")
	private String lastName;
	@Schema(description = "", example = "014d1d76-953e-44e4-83f9-e8b54b5c3e62")
	private String fullName;
	@Schema(description = "", example = "6448.51")
	private Double balance;
	@Schema(description = "", example = "4224.41")
	private Double balanceDebt;
	@Schema(description = "", example = "e675ee31-f384-44c8-9085-3f187fdfc07e")
	private String phone;
	@Schema(description = "", example = "23c54836-4dbf-410d-b790-ffd523880620")
	private String email;
	@Schema(description = "", example = "1b88c410-ae5a-4e38-87fd-e69ba1d6b3dc")
	private String notes;
	@Schema(description = "", example = "808c5a84-6291-4426-9339-b0370105694b")
	private String status;
	@Schema(description = "", example = "2e2a9141-886e-45b4-a49e-8e87399bb60d")
	private String company;
	@Schema(description = "", example = "2bceaa3b-4a3c-4c9e-9e96-87da2a5b30b5")
	private String addressLine1;
	@Schema(description = "", example = "8a8fb4cc-e302-4756-bc4c-2e46bc3f2f3e")
	private String addressLine2;
	@Schema(description = "", example = "67fa6e1c-dced-4e03-8e05-4acb34cc885d")
	private String city;
	@Schema(description = "", example = "0dfee92f-c603-4f66-ae79-704a8b2a3a6d")
	private String region;
	@Schema(description = "", example = "78246963-23ed-4af9-808b-d2b91c370f01")
	private String country;
	@Schema(description = "", example = "6e7b7fd8-c829-4722-a2c7-0cfa54580ece")
	private String postalCode;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
