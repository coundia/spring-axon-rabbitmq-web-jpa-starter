package com.groupe2cs.bizyhub.fileManager.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerNameNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerDetailsNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerObjectIdNotValid;

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
public class FileManagerObjectId implements Serializable {

	private String objectId;

	public FileManagerObjectId(String objectId) {
		this.objectId = objectId;
	}

	public static FileManagerObjectId create(String objectId) {

		return new FileManagerObjectId(objectId);
	}

	public String value() {
		return this.objectId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FileManagerObjectId that)) return false;
		return this.objectId.equals(that.objectId);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(objectId);
	}

	@Override
	public String toString() {
		return String.valueOf(objectId);
	}
}
