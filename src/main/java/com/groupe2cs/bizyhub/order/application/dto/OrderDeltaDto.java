package com.groupe2cs.bizyhub.order.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "OrderDeltaDto", description = "Delta DTO for order changes")
public class OrderDeltaDto implements Serializable {

    @Schema(description = "Identifier of the order", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "525b0c50-2db9-4448-9b33-f54fdf391dee")
		private String productId;
		@Schema(description = "", example = "3713e29e-65af-4a6d-be80-cb22d241b9b7")
		private String userId;
		@Schema(description = "", example = "edc2e523-0702-4569-96ef-5c7594f979a4")
		private String identifiant;
		@Schema(description = "", example = "9b6ebdeb-36d1-4c2f-ac98-21e8cb6d378c")
		private String telephone;
		@Schema(description = "", example = "322cddc0-5af3-4867-99c4-20636f0a5169")
		private String mail;
		@Schema(description = "", example = "19578de0-d3e0-4aec-a106-d1d7d3af3f89")
		private String ville;
		@Schema(description = "", example = "e720c449-6aba-4e14-b2d5-3b9939a5ed90")
		private String remoteId;
		@Schema(description = "", example = "a986704d-2721-4402-b6fb-f3236ece2f07")
		private String localId;
		@Schema(description = "", example = "fcc179f1-07c9-4094-b557-5f6f7c3e0544")
		private String status;
		@Schema(description = "", example = "c6397436-fb76-45bf-a300-3caed9c25505")
		private String buyerName;
		@Schema(description = "", example = "4fe0073b-06cc-4eba-a44e-2f3e09e9a8e5")
		private String address;
		@Schema(description = "", example = "05fba56a-cb96-4d8c-b354-53e31acf9c1f")
		private String notes;
		@Schema(description = "", example = "69a40a34-e043-4e05-98e1-1051f3a6dedb")
		private String message;
		@Schema(description = "", example = "75428aa0-7c08-4f67-a9f8-5e2e88f1c120")
		private String typeOrder;
		@Schema(description = "", example = "42856820-86fb-43e5-9810-33a129625dfa")
		private String paymentMethod;
		@Schema(description = "", example = "3d77ba83-1f6b-4569-b83a-ed5b7714b47b")
		private String deliveryMethod;
		@Schema(description = "", example = "2039.27")
		private Double amountCents;
		@Schema(description = "", example = "4")
		private Integer quantity;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateCommand;

}
