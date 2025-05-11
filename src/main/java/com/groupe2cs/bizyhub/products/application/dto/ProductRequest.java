package com.groupe2cs.bizyhub.products.application.dto;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
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
@Schema(name = "ProductRequest", description = "Request payload for Product operations")
public class ProductRequest implements Serializable {

	@Schema(description = "", example = "4c52d193-7211-4986-9145-221da33c960d")
	private String name;

	@Schema(description = "", example = "9617.56")
	private Double price;

	@Schema(description = "", example = "029800e9-b074-43f5-9c1c-9e90d4405289")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "07b5bba6-1e19-49a4-a7fc-0635dc74c310")
	private String reference;


}
