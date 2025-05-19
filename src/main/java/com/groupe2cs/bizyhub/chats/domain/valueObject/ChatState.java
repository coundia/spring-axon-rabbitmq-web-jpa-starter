package com.groupe2cs.bizyhub.chats.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatIdNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatMessagesNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatResponsesJsonNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatResponsesNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatStateNotValid;

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
public class ChatState implements Serializable {

private String state;

public ChatState(String state) {
this.state = state;
}

public static ChatState create(String state) {

	return new ChatState(state);
}

public String value() {
return this.state;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChatState that)) return false;
return this.state.equals(that.state);
}

@Override
public int hashCode() {
return java.util.Objects.hash(state);
}

@Override
public String toString() {
return String.valueOf(state);
}
}
