package com.groupe2cs.bizyhub.transactions.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TransactionUserRequest", description = "Request payload for TransactionUser operations")
public class TransactionUserRequest implements Serializable {

	@Schema(description = "", example = "a1072c71-a6a1-4cc3-8e3c-ad55dda689a3")
	private String name;
	@Schema(description = "", example = "13124d85-3136-4ca1-94e3-dadab8481eaf")
	private String remoteId;
	@Schema(description = "", example = "2677e3bd-67df-406a-8cdc-30d8257f6adb")
	private String localId;
	@Schema(description = "", example = "8aa4f72f-23e7-4f45-a734-8e54c468cb20")
	private String transaction;
	@Schema(description = "", example = "cf297bc3-6acd-4cd0-81ab-f3312d97f8e0")
	private String user;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "40bca2f5-ee31-4709-963d-dcf4ff4c9e5b")
	private String username;
	@Schema(description = "", example = "cc8d8db4-f7ac-4615-9474-85a9b66e859e")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
