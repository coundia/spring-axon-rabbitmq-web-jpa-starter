package com.groupe2cs.bizyhub.chats.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatIdNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatMessagesNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatResponsesJsonNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatResponsesNotValid;

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
public class ChatResponses implements Serializable {

private String responses;

public ChatResponses(String responses) {
this.responses = responses;
}

public static ChatResponses create(String responses) {

	return new ChatResponses(responses);
}

public String value() {
return this.responses;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChatResponses that)) return false;
return this.responses.equals(that.responses);
}

@Override
public int hashCode() {
return java.util.Objects.hash(responses);
}

@Override
public String toString() {
return String.valueOf(responses);
}
}
