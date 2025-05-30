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

	@Schema(description = "", example = "19b7f6c0-485d-45f5-a780-d15607d489ef")
	private String name;
	@Schema(description = "", example = "7685.63")
	private Double amount;
	@Schema(description = "", example = "2d6a22c2-9a91-45cf-8ab5-2f91bb20381b")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "3a971f04-381f-4aea-bd2f-66c97c7dd71f")
	private String account;
	@Schema(description = "", example = "0f9ad342-6299-4464-8fc0-2dd67cc8fc99")
	private String category;
	@Schema(description = "", example = "3e61754c-9a42-4797-8992-302f8b855723")
	private String typeTransactionRaw;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

}
