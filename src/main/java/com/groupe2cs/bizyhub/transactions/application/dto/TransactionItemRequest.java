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
@Schema(name = "TransactionItemRequest", description = "Request payload for TransactionItem operations")
public class TransactionItemRequest implements Serializable {

	@Schema(description = "", example = "180a070f-651f-4887-b18c-aea2278729f7")
	private String transaction;
	@Schema(description = "", example = "32723d8e-c287-453e-b9d5-ed04d7405ecd")
	private String product;
	@Schema(description = "", example = "53c4abd8-cdcc-4695-8bde-689411ee8fb4")
	private String label;
	@Schema(description = "", example = "31")
	private Integer quantity;
	@Schema(description = "", example = "6b60f57a-bc26-4789-9b2b-1e817b59e1fe")
	private String unit;
	@Schema(description = "", example = "f3ea05b1-e83d-4031-a95d-5ebf2cefafb1")
	private String remoteId;
	@Schema(description = "", example = "e33f8244-2cb3-4829-a37e-974fc36c019c")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "2915.2")
	private Double unitPrice;
	@Schema(description = "", example = "3770.07")
	private Double total;
	@Schema(description = "", example = "5b1c1111-9b2b-44cf-9ba1-510b145ea805")
	private String notes;

}
