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
@Schema(name = "TransactionsRequest", description = "Request payload for Transactions operations")
public class TransactionsRequest implements Serializable {

	@Schema(description = "", example = "")
	private String reference;
	@Schema(description = "", example = "")
	private Double amount;

	public static TransactionsRequest random() {
	TransactionsRequest request = new TransactionsRequest();
	request.setReference(UUID.randomUUID().toString());
	request.setAmount(3422.3);
	return request;
}
}
