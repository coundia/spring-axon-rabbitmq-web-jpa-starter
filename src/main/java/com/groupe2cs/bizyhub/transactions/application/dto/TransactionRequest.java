package com.groupe2cs.bizyhub.transactions.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TransactionRequest", description = "Request payload for Transaction operations")
public class TransactionRequest implements Serializable {

	@Schema(description = "", example = "")
	private String reference;
	@Schema(description = "", example = "")
	private Double amount;

	public static TransactionRequest random() {
		TransactionRequest request = new TransactionRequest();
		request.setReference(UUID.randomUUID().toString());
		request.setAmount(2333.2);
		return request;
	}
}
