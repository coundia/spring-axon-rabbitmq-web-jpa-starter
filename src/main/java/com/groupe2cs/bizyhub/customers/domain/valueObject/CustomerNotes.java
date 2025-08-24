package com.groupe2cs.bizyhub.customers.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerRemoteIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerLocalIdNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerCodeNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerFirstNameNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerLastNameNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerFullNameNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerBalanceNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerBalanceDebtNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerPhoneNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerEmailNotValid;
import com.groupe2cs.bizyhub.customers.domain.exception.CustomerNotesNotValid;

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
public class CustomerNotes implements Serializable {

private String notes;

public CustomerNotes(String notes) {
this.notes = notes;
}

public static CustomerNotes create(String notes) {

	return new CustomerNotes(notes);
}

public String value() {
return this.notes;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CustomerNotes that)) return false;
return this.notes.equals(that.notes);
}

@Override
public int hashCode() {
return java.util.Objects.hash(notes);
}

@Override
public String toString() {
return String.valueOf(notes);
}
}
