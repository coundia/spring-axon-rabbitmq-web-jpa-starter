package com.groupe2cs.bizyhub.fileManager.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerDetailsNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerObjectIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerObjectNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerOriginalNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerMimeTypeNotValid;

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
public class FileManagerMimeType implements Serializable {

	private String mimeType;

	public FileManagerMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public static FileManagerMimeType create(String mimeType) {

		return new FileManagerMimeType(mimeType);
	}

	public String value() {
		return this.mimeType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FileManagerMimeType that)) return false;
		return this.mimeType.equals(that.mimeType);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(mimeType);
	}

	@Override
	public String toString() {
		return String.valueOf(mimeType);
	}
}
