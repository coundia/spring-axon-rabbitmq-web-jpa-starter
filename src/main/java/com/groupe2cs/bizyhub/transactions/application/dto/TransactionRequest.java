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

	@Schema(description = "", example = "0f874f06-871c-4820-9c2a-518296e18370")
	private String reference;

	@Schema(description = "", example = "4460.08")
	private Double amount;


}
