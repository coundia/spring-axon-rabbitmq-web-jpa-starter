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
@Schema(name = "TransactionUserRequest", description = "Request payload for TransactionUser operations")
public class TransactionUserRequest implements Serializable {

	@Schema(description = "", example = "dc5f7bbf-2d06-4764-988a-5ebe767fe319")
	private String name;
	@Schema(description = "", example = "5053de62-8af0-4b6e-a78f-2925ce9d1f0d")
	private String transaction;
	@Schema(description = "", example = "98859261-d7b2-4c5a-acf1-b0bbf0f02007")
	private String user;
	@Schema(description = "", example = "f38478ba-44e6-4fbe-bb08-f3f57af9856b")
	private String username;
	@Schema(description = "", example = "6cc688ee-dcd1-42a0-a5d5-9aced06026d8")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
