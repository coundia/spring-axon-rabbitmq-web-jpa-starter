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
@Schema(name = "TransactionRequest", description = "Request payload for Transaction operations")
public class TransactionRequest implements Serializable {

	@Schema(description = "", example = "eb35da05-f399-4ff6-9a21-e1bcb6f6c5a6")
	private String remoteId;
	@Schema(description = "", example = "e2f4bdda-606d-4bf4-87fd-806ed8c1f3c1")
	private String localId;
	@Schema(description = "", example = "db5ac95e-95a3-4a03-9a2a-590f0b7f9181")
	private String code;
	@Schema(description = "", example = "7a2f947e-583c-4df8-913e-68243ca6497e")
	private String description;
	@Schema(description = "", example = "9877.92")
	private Double amount;
	@Schema(description = "", example = "f30ffa76-c646-4685-be79-cd13e0963a72")
	private String typeEntry;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;
	@Schema(description = "", example = "32ae8ef3-c510-4cca-bc17-e422b1c7a9c5")
	private String status;
	@Schema(description = "", example = "0a37bda6-63cc-4066-b578-0ed71e17bac8")
	private String entityName;
	@Schema(description = "", example = "2b3611e3-4059-4ce9-b856-8b92c5526222")
	private String entityId;
	@Schema(description = "", example = "85641c07-8270-4064-8108-6078e69f15c6")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "10f6fc1a-3ef2-4859-b8bc-1ae12bfc4889")
	private String category;
	@Schema(description = "", example = "d45124c1-3be0-4b67-a2cb-33f78a3e0c40")
	private String company;
	@Schema(description = "", example = "2997c4b9-1d69-46e2-82aa-d16a2a930975")
	private String customer;
	@Schema(description = "", example = "ed560e76-26d3-442a-a1ee-d7b556ae2ca1")
	private String debt;

}
