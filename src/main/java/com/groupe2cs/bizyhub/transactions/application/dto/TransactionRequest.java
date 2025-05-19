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

	@Schema(description = "", example = "8e7deae3-134e-4969-8d29-387b0810c798")
	private String name;

	@Schema(description = "", example = "672.0")
	private Double amount;

	@Schema(description = "", example = "71b236ca-82d1-40ef-8028-78bd432ab31d")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "d4b331c9-84f2-4c8e-9fa7-610436bb3b28")
	private String account;

	@Schema(description = "", example = "2c483ef4-73f4-44bc-ace6-d1aa2c6b5af8")
	private String category;

	@Schema(description = "", example = "209e1445-36b9-4ced-9b00-f59cb76cb1e3")
	private String typeTransactionRaw;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "daf447c4-e125-4394-a499-476610e8d940")
	private String reference;


}
