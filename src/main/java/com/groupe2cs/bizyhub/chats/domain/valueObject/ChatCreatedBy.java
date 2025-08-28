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
import com.groupe2cs.bizyhub.chats.domain.exception.ChatAccountNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatDateTransactionNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatCreatedByNotValid;

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
public class ChatCreatedBy implements Serializable {

private String createdBy;

public ChatCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static ChatCreatedBy create(String createdBy) {

	return new ChatCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChatCreatedBy that)) return false;
return this.createdBy.equals(that.createdBy);
}

@Override
public int hashCode() {
return java.util.Objects.hash(createdBy);
}

@Override
public String toString() {
return String.valueOf(createdBy);
}
}
