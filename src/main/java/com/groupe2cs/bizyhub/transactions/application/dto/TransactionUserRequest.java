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

	@Schema(description = "", example = "0f85dca2-932c-465a-96ef-cb06b8fac26e")
	private String name;
	@Schema(description = "", example = "aee45a31-7c06-4922-a31b-bf8c2cd85daa")
	private String transaction;
	@Schema(description = "", example = "b6410481-fc17-4b69-a0b7-b1b234488679")
	private String user;
	@Schema(description = "", example = "424c90a7-4ddb-4084-b54f-fa07c647cb8a")
	private String username;
	@Schema(description = "", example = "d28484ad-1878-4ed5-9527-d2167695435b")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
