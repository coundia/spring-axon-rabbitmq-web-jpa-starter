package com.groupe2cs.bizyhub.message.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.message.domain.exception.MessageIdNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageCodeNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageEmailNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessagePhoneNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageContentNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessagePlateformeNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageSourceNotValid;

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
public class MessageSource implements Serializable {

private String source;

public MessageSource(String source) {
this.source = source;
}

public static MessageSource create(String source) {

	return new MessageSource(source);
}

public String value() {
return this.source;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof MessageSource that)) return false;
return this.source.equals(that.source);
}

@Override
public int hashCode() {
return java.util.Objects.hash(source);
}

@Override
public String toString() {
return String.valueOf(source);
}
}
