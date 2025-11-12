package com.groupe2cs.bizyhub.message.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.message.domain.exception.MessageIdNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageCodeNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageEmailNotValid;

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
public class MessageEmail implements Serializable {

private String email;

public MessageEmail(String email) {
this.email = email;
}

public static MessageEmail create(String email) {

	return new MessageEmail(email);
}

public String value() {
return this.email;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof MessageEmail that)) return false;
return this.email.equals(that.email);
}

@Override
public int hashCode() {
return java.util.Objects.hash(email);
}

@Override
public String toString() {
return String.valueOf(email);
}
}
