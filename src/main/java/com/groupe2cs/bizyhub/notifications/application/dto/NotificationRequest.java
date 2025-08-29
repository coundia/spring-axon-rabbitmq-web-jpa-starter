package com.groupe2cs.bizyhub.notifications.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "NotificationRequest", description = "Request payload for Notification operations")
public class NotificationRequest implements Serializable {

	@Schema(description = "", example = "2943e884-e12e-4f81-8238-3f9a403f67d4")
	private String deviceToken;
	@Schema(description = "", example = "200e4b8b-289a-4498-9b4a-910f524714de")
	private String title;
	@Schema(description = "", example = "4b8fda15-40cb-4a03-a4ac-58f5cde01e44")
	private String message;
	@Schema(description = "", example = "111bfe60-dae7-4f8a-a543-7e10d59211aa")
	private String status;
	@Schema(description = "", example = "dfbc87c3-ca2e-410e-a227-e703603f717d")
	private String remoteId;
	@Schema(description = "", example = "0fda2471-1151-4ca6-b7cc-c0174c12aba1")
	private String account;
	@Schema(description = "", example = "78c8ed2f-fe67-4972-8c6b-9f6535aef661")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "92c0764f-7038-4e3a-92d4-53e4ac3679cb")
	private String reserved;
	@Schema(description = "", example = "0a24f41b-6d22-47c1-a279-7d4e5c6de154")
	private String errorMessage;

}
