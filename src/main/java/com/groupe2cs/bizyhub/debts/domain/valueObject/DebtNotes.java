package com.groupe2cs.bizyhub.debts.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtRemoteIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtLocalIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtCodeNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtNotesNotValid;

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
public class DebtNotes implements Serializable {

private String notes;

public DebtNotes(String notes) {
this.notes = notes;
}

public static DebtNotes create(String notes) {

	return new DebtNotes(notes);
}

public String value() {
return this.notes;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof DebtNotes that)) return false;
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
