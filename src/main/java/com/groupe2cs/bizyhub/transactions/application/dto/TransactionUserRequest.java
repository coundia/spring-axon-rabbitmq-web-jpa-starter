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

	@Schema(description = "", example = "ba061eea-c2c2-4fcb-b28e-7f7cdaf1fa4b")
	private String name;

	@Schema(description = "", example = "b167af27-0f22-434b-b459-6260143f3713")
	private String transaction;

	@Schema(description = "", example = "b10c77c2-2781-4f79-b2fa-63a5240b83a8")
	private String user;

	@Schema(description = "", example = "7e83f4cc-3366-4740-9ebf-eda7dbc781d8")
	private String username;

	@Schema(description = "", example = "7a208209-2d1d-47cd-aa51-63be03dbeaa7")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "fb1877ae-b61c-4045-9775-829c9e4e1d9f")
	private String reference;


}
