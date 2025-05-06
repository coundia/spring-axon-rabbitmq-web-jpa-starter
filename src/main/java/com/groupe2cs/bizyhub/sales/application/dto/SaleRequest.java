package com.groupe2cs.bizyhub.sales.application.dto;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
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
@Schema(name = "SaleRequest", description = "Request payload for Sale operations")
public class SaleRequest implements Serializable {

	@Schema(description = "", example = "937b2086-87ff-41a9-bd37-5bc673f64303")
	private String name;

	@Schema(description = "", example = "3052.64")
	private Double amount;

	@Schema(description = "", example = "749bcc5b-7e5c-4e45-8c08-d1748656130e")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "71fbcdbc-3469-4dbf-89c4-3b24dec7455c")
	private String product;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "5fe4232b-f20c-4f55-a2f9-5fd98efa6450")
	private String reference;


}
