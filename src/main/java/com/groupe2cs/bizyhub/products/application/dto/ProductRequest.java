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

	@Schema(description = "", example = "4fa84045-2901-415a-8c58-c3d45b3fb2e0")
	private String remoteId;
	@Schema(description = "", example = "7420d6e9-b2fb-402e-b258-f42d27354e43")
	private String localId;
	@Schema(description = "", example = "398e009e-b368-41de-b8b7-edfb0fbcfcbe")
	private String code;
	@Schema(description = "", example = "42cf60f4-e5cc-49b4-882f-bc0083641acc")
	private String name;
	@Schema(description = "", example = "d80b404e-a12d-4d9d-a205-176768224990")
	private String description;
	@Schema(description = "", example = "d9e66453-fd5a-4a22-ad0c-127032714b45")
	private String barcode;
	@Schema(description = "", example = "eaa2d49e-7854-44e5-b1e3-67048594b037")
	private String unit;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "b15f630d-9a77-4788-886a-35ac92017f18")
	private String category;
	@Schema(description = "", example = "012f0210-21aa-4cd2-aeaf-dcefb653d138")
	private String account;
	@Schema(description = "", example = "8380.49")
	private Double defaultPrice;
	@Schema(description = "", example = "56330eec-4179-4961-92fb-86c1bc0621c7")
	private String statuses;
	@Schema(description = "", example = "8433.27")
	private Double purchasePrice;

}
