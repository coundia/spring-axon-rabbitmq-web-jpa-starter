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
import com.groupe2cs.bizyhub.chats.domain.exception.ChatFilesNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatDateTransactionNotValid;

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
public class ChatDateTransaction implements Serializable {

private java.time.Instant dateTransaction;

public ChatDateTransaction(java.time.Instant dateTransaction) {
this.dateTransaction = dateTransaction;
}

public static ChatDateTransaction create(java.time.Instant dateTransaction) {

	return new ChatDateTransaction(dateTransaction);
}

public java.time.Instant value() {
return this.dateTransaction;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChatDateTransaction that)) return false;
return this.dateTransaction.equals(that.dateTransaction);
}

@Override
public int hashCode() {
return java.util.Objects.hash(dateTransaction);
}

@Override
public String toString() {
return String.valueOf(dateTransaction);
}
}
