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
@Schema(name = "SaleUserRequest", description = "Request payload for SaleUser operations")
public class SaleUserRequest implements Serializable {

	@Schema(description = "", example = "bc5d008c-1c1d-4021-bbf9-6d6598a6f7c2")
	private String name;

	@Schema(description = "", example = "c64fdac2-db6c-46d2-9ec0-f259b0b0485f")
	private String sale;

	@Schema(description = "", example = "63dd7d7c-b481-480f-a4df-ef997e827522")
	private String user;

	@Schema(description = "", example = "fd992f17-b465-41bf-8935-5c4b077e99e3")
	private String username;

	@Schema(description = "", example = "b7e8cbb1-a748-4d12-a754-90b8d730e0cf")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "9757f4c1-939f-4f7c-9785-39fda9861314")
	private String reference;


}
