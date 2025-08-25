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

	@Schema(description = "", example = "fa020279-a02e-4fca-8c68-c8bc1f942873")
	private String remoteId;
	@Schema(description = "", example = "c962e486-322c-4ba4-b57f-1d8681cca3f0")
	private String localId;
	@Schema(description = "", example = "fa3aec2e-468c-4009-9445-c9f6429066b3")
	private String code;
	@Schema(description = "", example = "babee380-8673-48c8-929f-69a8445e8696")
	private String description;
	@Schema(description = "", example = "1255.07")
	private Double amount;
	@Schema(description = "", example = "dbb22da2-e6a1-46fa-aa2a-82966e7a49bb")
	private String typeEntry;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;
	@Schema(description = "", example = "a6b1dde7-9d96-4145-942f-9b573f080c7a")
	private String status;
	@Schema(description = "", example = "33e41425-f299-4961-a808-ec642452cdc8")
	private String entityName;
	@Schema(description = "", example = "169d73b7-2032-4d54-b7a4-023c97fa7b9d")
	private String entityId;
	@Schema(description = "", example = "13e998b5-d6e7-4d94-949c-66a0530fae6b")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "f399bfea-2ecb-48a5-aa78-c8cab0766b21")
	private String category;
	@Schema(description = "", example = "1b31a695-dcf5-4901-9a7e-17f66f9e9b00")
	private String company;
	@Schema(description = "", example = "22bd38a7-b3ef-4436-a498-f5cd4b66c0ca")
	private String customer;
	@Schema(description = "", example = "4a6721ad-4aa5-4eb4-8c49-08f925d49cc3")
	private String debt;

}
