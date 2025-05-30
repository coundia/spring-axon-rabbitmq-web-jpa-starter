package com.groupe2cs.bizyhub.chats.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ChatDeltaDto", description = "Delta DTO for chat changes")
public class ChatDeltaDto implements Serializable {

	@Schema(description = "Identifier of the chat", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "6079bf83-3047-49a2-9205-706d7a814c7c")
	private String messages;
	@Schema(description = "", example = "d1a146ea-eb6a-4bdf-8d3c-511acd969654")
	private String responsesJson;
	@Schema(description = "", example = "01bbeef6-1b80-44bb-837a-9fe075b0ce19")
	private String responses;
	@Schema(description = "", example = "5d03da88-bb79-40ce-8f8b-4e4ac919d903")
	private String state;
	@Schema(description = "", example = "e3ab44b1-19d0-4fa9-bdd0-16cbdde8b71b")
	private String account;

}
