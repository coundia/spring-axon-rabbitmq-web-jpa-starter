package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeNotesNotValid;

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
public class VerificationCodeNotes implements Serializable {

private String notes;

public VerificationCodeNotes(String notes) {
this.notes = notes;
}

public static VerificationCodeNotes create(String notes) {

	return new VerificationCodeNotes(notes);
}

public String value() {
return this.notes;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof VerificationCodeNotes that)) return false;
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
