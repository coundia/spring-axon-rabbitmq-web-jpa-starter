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
public class MessageIsDefault implements Serializable {

private Boolean isDefault;

public MessageIsDefault(Boolean isDefault) {
this.isDefault = isDefault;
}

public static MessageIsDefault create(Boolean isDefault) {

	return new MessageIsDefault(isDefault);
}

public Boolean value() {
return this.isDefault;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof MessageIsDefault that)) return false;
return this.isDefault.equals(that.isDefault);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isDefault);
}

@Override
public String toString() {
return String.valueOf(isDefault);
}
}
