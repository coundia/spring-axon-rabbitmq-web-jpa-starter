package com.groupe2cs.bizyhub.fileManager.domain.valueObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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
