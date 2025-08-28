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

	@Schema(description = "", example = "81904978-654c-4ed5-8ed2-688d22153647")
	private String remoteId;
	@Schema(description = "", example = "5850bb3b-3588-42d3-87bc-4cbff3b39af9")
	private String localId;
	@Schema(description = "", example = "afbe7f67-b282-44af-b7d7-e76a2e2fc42a")
	private String code;
	@Schema(description = "", example = "b256216e-afaa-49e4-9012-4dad1c54332e")
	private String description;
	@Schema(description = "", example = "1010.79")
	private Double amount;
	@Schema(description = "", example = "ad3fdb0c-cd20-44b1-ab99-328ca4045f25")
	private String typeEntry;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;
	@Schema(description = "", example = "2f3b321a-8fe8-4a40-9621-fb1a250cc612")
	private String status;
	@Schema(description = "", example = "87662f3d-4a0c-47d8-baa3-6ea6fdd2d113")
	private String entityName;
	@Schema(description = "", example = "2b36374f-c416-450f-9893-3b3060442b70")
	private String entityId;
	@Schema(description = "", example = "8da3b09b-c72f-4581-a353-f2f3b32bae45")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "5448be07-375a-4cc4-8b5b-a912c695839e")
	private String category;
	@Schema(description = "", example = "e4ea237f-44ba-430a-991f-69b0390e55c5")
	private String company;
	@Schema(description = "", example = "ba3e5d1f-c17a-4ebd-ac2d-4d4e83a1a097")
	private String customer;
	@Schema(description = "", example = "862a4958-4a75-469f-878e-0c480638ed20")
	private String debt;

}
