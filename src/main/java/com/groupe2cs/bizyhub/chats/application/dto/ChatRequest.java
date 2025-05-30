package com.groupe2cs.bizyhub.chats.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ChatRequest", description = "Request payload for Chat operations")
public class ChatRequest implements Serializable {

	@Schema(description = "", example = "6ba6f9d7-b5bc-4f22-bf88-f38dcc2c0f94")
	private String messages;
	@Schema(description = "", example = "5c796e95-084c-42a5-bc17-c55c466b6198")
	private String responsesJson;
	@Schema(description = "", example = "e44be172-86ce-4540-8540-2c7d3c690920")
	private String responses;
	@Schema(description = "", example = "45136662-0f19-411c-bc3f-c2b104ad67fd")
	private String state;
	@Schema(description = "", example = "1eea9c20-f294-4878-8acc-3cfe7d098d10")
	private String account;

}
