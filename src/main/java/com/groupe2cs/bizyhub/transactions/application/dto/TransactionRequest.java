package com.groupe2cs.bizyhub.transactions.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TransactionRequest", description = "Request payload for Transaction operations")
public class TransactionRequest implements Serializable {

	@Schema(description = "", example = "d1f6a5ed-e81e-4592-8f88-0163453bf9f3")
	private String reference;

	@Schema(description = "", example = "4522.08")
	private Double amount;


}
