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
import com.groupe2cs.bizyhub.chats.domain.exception.ChatCreatedByNotValid;
import com.groupe2cs.bizyhub.chats.domain.exception.ChatTenantNotValid;

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
public class ChatTenant implements Serializable {

private String tenant;

public ChatTenant(String tenant) {
this.tenant = tenant;
}

public static ChatTenant create(String tenant) {

	return new ChatTenant(tenant);
}

public String value() {
return this.tenant;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ChatTenant that)) return false;
return this.tenant.equals(that.tenant);
}

@Override
public int hashCode() {
return java.util.Objects.hash(tenant);
}

@Override
public String toString() {
return String.valueOf(tenant);
}
}
