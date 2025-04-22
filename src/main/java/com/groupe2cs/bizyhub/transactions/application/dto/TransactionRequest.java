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

	@Schema(description = "", example = "d92dd41b-6ed4-4b2c-a4ed-2dd2704d11e3")
	private String reference;

	@Schema(description = "", example = "5664.63")
	private Double amount;


}
