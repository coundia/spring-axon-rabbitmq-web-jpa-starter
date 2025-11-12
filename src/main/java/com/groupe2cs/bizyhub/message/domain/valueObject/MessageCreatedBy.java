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
import com.groupe2cs.bizyhub.message.domain.exception.MessageCreatedByNotValid;

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
public class MessageCreatedBy implements Serializable {

private String createdBy;

public MessageCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static MessageCreatedBy create(String createdBy) {

	return new MessageCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof MessageCreatedBy that)) return false;
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
