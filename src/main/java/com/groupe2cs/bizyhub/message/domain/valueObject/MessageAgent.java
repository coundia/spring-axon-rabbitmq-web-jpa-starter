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
public class MessageAgent implements Serializable {

private String agent;

public MessageAgent(String agent) {
this.agent = agent;
}

public static MessageAgent create(String agent) {

	return new MessageAgent(agent);
}

public String value() {
return this.agent;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof MessageAgent that)) return false;
return this.agent.equals(that.agent);
}

@Override
public int hashCode() {
return java.util.Objects.hash(agent);
}

@Override
public String toString() {
return String.valueOf(agent);
}
}
