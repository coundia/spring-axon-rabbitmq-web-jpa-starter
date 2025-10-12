package com.groupe2cs.bizyhub.customers.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

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

	@Schema(description = "", example = "54ffff15-c629-499c-9ff9-02adf4960f88")
	private String remoteId;
	@Schema(description = "", example = "d2d05a71-fe1f-4ea8-a7d6-905351809757")
	private String localId;
	@Schema(description = "", example = "d330a754-e1ca-41c9-816d-3d7f8588f8cb")
	private String code;
	@Schema(description = "", example = "2e9dc662-3181-4723-95ae-167cf19024a9")
	private String firstName;
	@Schema(description = "", example = "a395d31f-6c0d-460f-99a3-eb57c3efe878")
	private String lastName;
	@Schema(description = "", example = "80751428-fa16-4214-a7ad-600b991f2535")
	private String fullName;
	@Schema(description = "", example = "287.08")
	private Double balance;
	@Schema(description = "", example = "5958.26")
	private Double balanceDebt;
	@Schema(description = "", example = "723b9988-8372-49a5-885f-d276562a7f86")
	private String phone;
	@Schema(description = "", example = "709843f0-bb4e-4d9b-a22d-893d1fb161fe")
	private String email;
	@Schema(description = "", example = "3f20e668-c91f-474e-b9ac-b448a2aeba36")
	private String notes;
	@Schema(description = "", example = "53010c74-2fc0-49bf-b89b-d72b4f7b4cda")
	private String status;
	@Schema(description = "", example = "decf4e34-6f55-4553-a9d1-40d9b5bcd600")
	private String account;
	@Schema(description = "", example = "e3725893-91d9-4b82-be46-419446b894c5")
	private String company;
	@Schema(description = "", example = "a565fe3d-0927-48f3-985a-e74a7480627f")
	private String addressLine1;
	@Schema(description = "", example = "fc31c4fb-9503-4324-8186-f7bc5495bf34")
	private String addressLine2;
	@Schema(description = "", example = "d2b4fb11-b7e5-4f02-b42e-7bdec4401a2d")
	private String city;
	@Schema(description = "", example = "dc37a045-9de5-470d-90d4-0cd165c36e07")
	private String region;
	@Schema(description = "", example = "f22266dd-5cca-44ac-9e41-cd2ca05945ed")
	private String country;
	@Schema(description = "", example = "6f053506-94b8-4830-8812-d8dbc49d24f3")
	private String postalCode;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
