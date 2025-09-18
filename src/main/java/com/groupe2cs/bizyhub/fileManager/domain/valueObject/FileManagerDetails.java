package com.groupe2cs.bizyhub.fileManager.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerDetailsNotValid;

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
public class FileManagerDetails implements Serializable {

private String details;

public FileManagerDetails(String details) {
this.details = details;
}

public static FileManagerDetails create(String details) {

	return new FileManagerDetails(details);
}

public String value() {
return this.details;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof FileManagerDetails that)) return false;
return this.details.equals(that.details);
}

@Override
public int hashCode() {
return java.util.Objects.hash(details);
}

@Override
public String toString() {
return String.valueOf(details);
}
}
