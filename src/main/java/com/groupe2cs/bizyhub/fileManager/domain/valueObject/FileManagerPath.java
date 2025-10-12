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
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerPathNotValid;

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
public class FileManagerPath implements Serializable {

	private String path;

	public FileManagerPath(String path) {
		this.path = path;
	}

	public static FileManagerPath create(String path) {

		return new FileManagerPath(path);
	}

	public String value() {
		return this.path;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FileManagerPath that)) return false;
		return this.path.equals(that.path);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(path);
	}

	@Override
	public String toString() {
		return String.valueOf(path);
	}
}
