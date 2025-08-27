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

	@Schema(description = "", example = "e075cede-5c5b-4a65-a92c-4ba9be72da79")
	private String remoteId;
	@Schema(description = "", example = "7b9029a3-5713-42bf-a089-eb9f9f1d1899")
	private String localId;
	@Schema(description = "", example = "73e34faa-970c-4d60-a5d0-470fad2919a6")
	private String code;
	@Schema(description = "", example = "d7eb179c-3477-4ed6-8356-691667af1f7d")
	private String name;
	@Schema(description = "", example = "6fb3df38-22e4-4c01-bc52-8e90070a4d9b")
	private String description;
	@Schema(description = "", example = "b94388ba-0138-47d5-b926-749adfe11391")
	private String barcode;
	@Schema(description = "", example = "17e01db2-1484-41e8-a5b8-4fb9cf72710e")
	private String unit;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "f4dc6268-4f19-46b8-af94-6a4d509cea89")
	private String category;
	@Schema(description = "", example = "3587.86")
	private Double defaultPrice;
	@Schema(description = "", example = "e913026e-0d8f-4c99-a841-1ba73bc92e9e")
	private String statuses;
	@Schema(description = "", example = "6940.71")
	private Double purchasePrice;

}
