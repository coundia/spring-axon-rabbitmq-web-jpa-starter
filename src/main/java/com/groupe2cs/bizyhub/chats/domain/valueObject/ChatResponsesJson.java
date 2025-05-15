package com.groupe2cs.bizyhub.chats.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatIdNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatMessagesNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatResponsesJsonNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ChatResponsesJson implements Serializable {

private String responsesJson;

public ChatResponsesJson(String responsesJson) {
this.responsesJson = responsesJson;
}

public static ChatResponsesJson create(String responsesJson) {

	return new ChatResponsesJson(responsesJson);
}

public String value() {
return this.responsesJson;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChatResponsesJson that)) return false;
return this.responsesJson.equals(that.responsesJson);
}

@Override
public int hashCode() {
return java.util.Objects.hash(responsesJson);
}

@Override
public String toString() {
return String.valueOf(responsesJson);
}
}
