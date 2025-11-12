package com.groupe2cs.bizyhub.message.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.message.domain.exception.MessageIdNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageCodeNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageEmailNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessagePhoneNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessageContentNotValid;
import com.groupe2cs.bizyhub.message.domain.exception.MessagePlateformeNotValid;

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
public class MessagePlateforme implements Serializable {

private String plateforme;

public MessagePlateforme(String plateforme) {
this.plateforme = plateforme;
}

public static MessagePlateforme create(String plateforme) {

	return new MessagePlateforme(plateforme);
}

public String value() {
return this.plateforme;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof MessagePlateforme that)) return false;
return this.plateforme.equals(that.plateforme);
}

@Override
public int hashCode() {
return java.util.Objects.hash(plateforme);
}

@Override
public String toString() {
return String.valueOf(plateforme);
}
}
