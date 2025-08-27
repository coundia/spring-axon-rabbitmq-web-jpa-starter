package com.groupe2cs.bizyhub.transactions.application.dto;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
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
@Schema(name = "TransactionRequest", description = "Request payload for Transaction operations")
public class TransactionRequest implements Serializable {

	@Schema(description = "", example = "50ceeff6-bfda-4c2d-acc8-0956358d954e")
	private String remoteId;
	@Schema(description = "", example = "ccbea101-2540-4d65-9028-94228e0991b2")
	private String localId;
	@Schema(description = "", example = "8a9545b5-ee52-422e-90a1-c5dacd7266af")
	private String code;
	@Schema(description = "", example = "e3066c46-cdb7-4d6c-8266-a85674b97fd8")
	private String description;
	@Schema(description = "", example = "8053.06")
	private Double amount;
	@Schema(description = "", example = "262f99b9-b736-4789-a8e1-85bd662be6ae")
	private String typeEntry;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;
	@Schema(description = "", example = "2e0f6ea9-aa52-4d0f-8dc4-b248824f9533")
	private String status;
	@Schema(description = "", example = "37abab3f-06e3-4c9d-9c10-29cf4c1f9f40")
	private String entityName;
	@Schema(description = "", example = "81a9e07b-9903-4861-bf4d-d486d82b527d")
	private String entityId;
	@Schema(description = "", example = "9e7e6697-e7cc-4612-8b31-19c814dd9661")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "d5374b68-6de8-46bd-af23-1a39e2966a13")
	private String category;
	@Schema(description = "", example = "1f18d59c-e608-4a0b-b711-4d83481d2656")
	private String company;
	@Schema(description = "", example = "04d7b7c1-63c1-46cc-a1a9-3ab3967254e6")
	private String customer;
	@Schema(description = "", example = "18a74013-ffbc-440f-b5d0-15b554c35565")
	private String debt;

}
