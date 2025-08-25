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

	@Schema(description = "", example = "6bd10e7b-268c-44fc-8288-32f257d63f2b")
	private String remoteId;
	@Schema(description = "", example = "2d9b6112-bae0-4cf8-9e11-2cf9b89a5db5")
	private String localId;
	@Schema(description = "", example = "133fb457-8a75-4a3c-bc4c-74d3f102fbee")
	private String code;
	@Schema(description = "", example = "7e0efc98-85f7-484a-a8a5-b4609c3545d0")
	private String firstName;
	@Schema(description = "", example = "cc9be2c1-225f-429c-b818-cb4935b6e3f7")
	private String lastName;
	@Schema(description = "", example = "5948ae99-2998-4eae-84ba-c6a5aba40fe9")
	private String fullName;
	@Schema(description = "", example = "5003.24")
	private Double balance;
	@Schema(description = "", example = "815.92")
	private Double balanceDebt;
	@Schema(description = "", example = "6d9c9d1a-4063-4036-94be-2e7f537a0f6b")
	private String phone;
	@Schema(description = "", example = "fc3ec4a4-a4a3-49d5-9223-60f69762f76b")
	private String email;
	@Schema(description = "", example = "ca340f99-c44c-406b-acf7-a4b05e178e56")
	private String notes;
	@Schema(description = "", example = "80ea3dd5-899f-46ac-9106-709db8a91b3e")
	private String status;
	@Schema(description = "", example = "11658f77-e1e8-43ba-897d-4313cae3eb20")
	private String company;
	@Schema(description = "", example = "49542fe5-f981-48fb-8245-f8ed3dcfb302")
	private String addressLine1;
	@Schema(description = "", example = "953a1f1b-f8e5-4b02-beec-f9d457ea71cd")
	private String addressLine2;
	@Schema(description = "", example = "c8218d03-e4cc-4c4b-9178-b84aad38b24d")
	private String city;
	@Schema(description = "", example = "73dd88a5-4042-4165-b377-7fb566b1a1b0")
	private String region;
	@Schema(description = "", example = "68faf917-abd5-474e-a53c-8757716bf77b")
	private String country;
	@Schema(description = "", example = "0c206b66-3505-4b0d-82c1-f4a6d5b27717")
	private String postalCode;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
