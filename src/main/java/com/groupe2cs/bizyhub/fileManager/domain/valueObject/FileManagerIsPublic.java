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
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerUriNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerIsPublicNotValid;

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
public class FileManagerIsPublic implements Serializable {

	private Boolean isPublic;

	public FileManagerIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public static FileManagerIsPublic create(Boolean isPublic) {

		return new FileManagerIsPublic(isPublic);
	}

	public Boolean value() {
		return this.isPublic;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FileManagerIsPublic that)) return false;
		return this.isPublic.equals(that.isPublic);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isPublic);
	}

	@Override
	public String toString() {
		return String.valueOf(isPublic);
	}
}
