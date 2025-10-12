package com.groupe2cs.bizyhub.customers.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "CustomerRequest", description = "Request payload for Customer operations")
public class CustomerRequest implements Serializable {

	@Schema(description = "", example = "cb3531aa-4ca4-46e9-8bee-b5d6585b1d0b")
	private String remoteId;
	@Schema(description = "", example = "79e87a1a-d80b-4232-9883-ef2a18e9b893")
	private String localId;
	@Schema(description = "", example = "fe172006-9084-46d7-a324-8e477d5fd03a")
	private String code;
	@Schema(description = "", example = "85fc24b8-5a02-41a9-92cd-1427fe9dcd01")
	private String firstName;
	@Schema(description = "", example = "48edd8d7-2d98-4d74-be10-008bea204039")
	private String lastName;
	@Schema(description = "", example = "e2ceb0db-1e38-4f0f-a75b-f86406571070")
	private String fullName;
	@Schema(description = "", example = "692.83")
	private Double balance;
	@Schema(description = "", example = "9862.63")
	private Double balanceDebt;
	@Schema(description = "", example = "dd73343a-c6b2-4007-ab1e-f4147eb7bcc1")
	private String phone;
	@Schema(description = "", example = "69b7fdfc-ea47-4cc8-9c8e-2afef87ecdaf")
	private String email;
	@Schema(description = "", example = "19e23372-f506-4abb-a90a-d2fa5b118c16")
	private String notes;
	@Schema(description = "", example = "4223f448-a257-43ec-878d-642657a3928e")
	private String status;
	@Schema(description = "", example = "953efeb5-031f-4580-9e9c-982640401143")
	private String account;
	@Schema(description = "", example = "23f2a7c8-8812-47b9-8904-9d9beb429203")
	private String company;
	@Schema(description = "", example = "d724af73-7be5-4a49-b80c-e8277c75d1e5")
	private String addressLine1;
	@Schema(description = "", example = "c402c9fd-220c-46d7-96b2-faed42c5c39a")
	private String addressLine2;
	@Schema(description = "", example = "5b587a65-c7e2-43a2-9398-721cf10ac659")
	private String city;
	@Schema(description = "", example = "8e92002a-4d46-4cb6-a031-08fe5f669c3a")
	private String region;
	@Schema(description = "", example = "ebea6482-af6e-44d2-9026-830f4ad2b3ad")
	private String country;
	@Schema(description = "", example = "1899d593-3372-4780-aa40-2ea0f047a26c")
	private String postalCode;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
