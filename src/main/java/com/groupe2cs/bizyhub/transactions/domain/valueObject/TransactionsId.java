package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionsIdNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionsId implements Serializable {

private String id;

public TransactionsId(String id) {
this.id = id;
}

public static TransactionsId create(String id) {
if (id == null || id.isBlank()) {
throw new TransactionsIdNotValid("Id is invalid");
}
return new TransactionsId(id);
}

public String value() {
return this.id;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionsId that)) return false;
return this.id.equals(that.id);
}

@Override
public int hashCode() {
return java.util.Objects.hash(id);
}

@Override
public String toString() {
return String.valueOf(id);
}
}
