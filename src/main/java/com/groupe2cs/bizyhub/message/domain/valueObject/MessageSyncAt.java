package com.groupe2cs.bizyhub.message.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.message.domain.exception.MessageIdNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageCodeNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageEmailNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessagePhoneNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageContentNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessagePlateformeNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageSourceNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageAgentNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageStatusNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageDescriptionNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageIsActiveNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageIsDefaultNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageRemoteIdNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageLocalIdNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageDepotAtNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageSyncAtNotValid;

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
public class MessageSyncAt implements Serializable {

private java.time.Instant syncAt;

public MessageSyncAt(java.time.Instant syncAt) {
this.syncAt = syncAt;
}

public static MessageSyncAt create(java.time.Instant syncAt) {

	return new MessageSyncAt(syncAt);
}

public java.time.Instant value() {
return this.syncAt;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof MessageSyncAt that)) return false;
return this.syncAt.equals(that.syncAt);
}

@Override
public int hashCode() {
return java.util.Objects.hash(syncAt);
}

@Override
public String toString() {
return String.valueOf(syncAt);
}
}
