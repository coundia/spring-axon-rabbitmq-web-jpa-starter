package com.groupe2cs.bizyhub.accounts.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "AccountRequest", description = "Request payload for Account operations")
public class AccountRequest implements Serializable {

	@Schema(description = "", example = "ff72a391-0cc2-4ac8-84f3-1a712f37a66f")
	private String name;

	@Schema(description = "", example = "33fae8aa-6125-4e1a-99d7-42ca4fe43ed7")
	private String currency;

	@Schema(description = "", example = "5177.48")
	private Double currentBalance;

	@Schema(description = "", example = "2918.11")
	private Double previousBalance;

	@Schema(description = "", example = "02435a4b-9042-4ff8-9145-aaab1f4b13f6")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "47958368-ba82-4aa5-a6b6-0b3a6d6099c7")
	private String reference;


}
