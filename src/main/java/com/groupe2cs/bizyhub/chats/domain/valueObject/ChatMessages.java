package com.groupe2cs.bizyhub.chats.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatIdNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatMessagesNotValid;

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
public class ChatMessages implements Serializable {

private String messages;

public ChatMessages(String messages) {
this.messages = messages;
}

public static ChatMessages create(String messages) {

if (messages == null || messages.isBlank()) {
throw new ChatMessagesNotValid("Messages is invalid");
}
return new ChatMessages(messages);
}

public String value() {
return this.messages;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChatMessages that)) return false;
return this.messages.equals(that.messages);
}

@Override
public int hashCode() {
return java.util.Objects.hash(messages);
}

@Override
public String toString() {
return String.valueOf(messages);
}
}
