package com.groupe2cs.bizyhub.message.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.message.domain.exception.MessageIdNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageCodeNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageEmailNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessagePhoneNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageContentNotValid;

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
public class MessageContent implements Serializable {

private String content;

public MessageContent(String content) {
this.content = content;
}

public static MessageContent create(String content) {

	return new MessageContent(content);
}

public String value() {
return this.content;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof MessageContent that)) return false;
return this.content.equals(that.content);
}

@Override
public int hashCode() {
return java.util.Objects.hash(content);
}

@Override
public String toString() {
return String.valueOf(content);
}
}
