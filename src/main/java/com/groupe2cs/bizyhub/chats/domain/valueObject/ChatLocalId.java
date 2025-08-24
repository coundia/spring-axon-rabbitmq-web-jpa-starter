package com.groupe2cs.bizyhub.chats.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatIdNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatMessagesNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatResponsesJsonNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatResponsesNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatStateNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatSyncAtNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatRemoteIdNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatLocalIdNotValid;

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
public class ChatLocalId implements Serializable {

private String localId;

public ChatLocalId(String localId) {
this.localId = localId;
}

public static ChatLocalId create(String localId) {

	return new ChatLocalId(localId);
}

public String value() {
return this.localId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChatLocalId that)) return false;
return this.localId.equals(that.localId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(localId);
}

@Override
public String toString() {
return String.valueOf(localId);
}
}
