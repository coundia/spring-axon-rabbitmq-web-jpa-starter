package com.groupe2cs.bizyhub.order.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.order.domain.exception.OrderIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderProductIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderUserIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderIdentifiantNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderTelephoneNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderMailNotValid;

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
public class OrderMail implements Serializable {

private String mail;

public OrderMail(String mail) {
this.mail = mail;
}

public static OrderMail create(String mail) {

	return new OrderMail(mail);
}

public String value() {
return this.mail;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof OrderMail that)) return false;
return this.mail.equals(that.mail);
}

@Override
public int hashCode() {
return java.util.Objects.hash(mail);
}

@Override
public String toString() {
return String.valueOf(mail);
}
}
