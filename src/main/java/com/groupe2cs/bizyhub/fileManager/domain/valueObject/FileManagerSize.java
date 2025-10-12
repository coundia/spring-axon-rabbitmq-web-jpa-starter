package com.groupe2cs.bizyhub.fileManager.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerDetailsNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerObjectIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerObjectNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerOriginalNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerMimeTypeNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerSizeNotValid;

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
public class FileManagerSize implements Serializable {

	private Long size;

	public FileManagerSize(Long size) {
		this.size = size;
	}

	public static FileManagerSize create(Long size) {

		return new FileManagerSize(size);
	}

	public Long value() {
		return this.size;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FileManagerSize that)) return false;
		return this.size.equals(that.size);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(size);
	}

	@Override
	public String toString() {
		return String.valueOf(size);
	}
}
