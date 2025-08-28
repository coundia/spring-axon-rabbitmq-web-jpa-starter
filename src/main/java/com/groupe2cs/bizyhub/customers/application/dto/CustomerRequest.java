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

	@Schema(description = "", example = "fa635672-9399-4763-b069-f4aba8595a4e")
	private String remoteId;
	@Schema(description = "", example = "1c7061f7-c206-4eb1-b362-cb22be522fb5")
	private String localId;
	@Schema(description = "", example = "1865e251-bdd3-4de2-8a5c-010f94615e77")
	private String code;
	@Schema(description = "", example = "64fbb57a-74d9-4ac4-9316-109a66a64b93")
	private String firstName;
	@Schema(description = "", example = "10cc28d5-aa12-411d-ac2f-290dcb28937d")
	private String lastName;
	@Schema(description = "", example = "d4a2162d-7ad2-42a5-b616-5d6d491eb0d0")
	private String fullName;
	@Schema(description = "", example = "8277.86")
	private Double balance;
	@Schema(description = "", example = "242.1")
	private Double balanceDebt;
	@Schema(description = "", example = "7a0543db-f942-4f4c-a5b5-9eb7cba931d8")
	private String phone;
	@Schema(description = "", example = "12db14e3-b272-446d-805e-494935229e52")
	private String email;
	@Schema(description = "", example = "78c94323-6450-4246-8f9b-8f8d11536c89")
	private String notes;
	@Schema(description = "", example = "2ff60539-807a-40f1-a3ba-7072f9007ab1")
	private String status;
	@Schema(description = "", example = "1ffc4592-7321-4dac-978c-c4da329e60fd")
	private String account;
	@Schema(description = "", example = "f47afb22-5e83-41cf-b90e-534276d19c46")
	private String company;
	@Schema(description = "", example = "c57f1568-833d-4d02-9f11-8b87e4d6ac65")
	private String addressLine1;
	@Schema(description = "", example = "53b30f1b-f317-4ef9-b2d7-1d865170929b")
	private String addressLine2;
	@Schema(description = "", example = "4ba795de-ead4-4884-9866-72232294187d")
	private String city;
	@Schema(description = "", example = "7df53d3e-8be2-48b9-8c19-a600467b9891")
	private String region;
	@Schema(description = "", example = "e7eb3893-088f-4774-84c2-8c0e195dec38")
	private String country;
	@Schema(description = "", example = "5af4d174-27fd-4037-8a76-8ada75454a3e")
	private String postalCode;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
