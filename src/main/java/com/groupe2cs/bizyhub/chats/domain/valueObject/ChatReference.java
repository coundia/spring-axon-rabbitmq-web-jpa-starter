package com.groupe2cs.bizyhub.chats.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatIdNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatMessagesNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatResponsesJsonNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatResponsesNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatStateNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatAccountNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatUpdatedAtNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatReferenceNotValid;

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
public class ChatReference implements Serializable {

private String reference;

public ChatReference(String reference) {
this.reference = reference;
}

public static ChatReference create(String reference) {

	return new ChatReference(reference);
}

public String value() {
return this.reference;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChatReference that)) return false;
return this.reference.equals(that.reference);
}

@Override
public int hashCode() {
return java.util.Objects.hash(reference);
}

@Override
public String toString() {
return String.valueOf(reference);
}
}
