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
public class FileManagerObjectName implements Serializable {

	private String objectName;

	public FileManagerObjectName(String objectName) {
		this.objectName = objectName;
	}

	public static FileManagerObjectName create(String objectName) {

		return new FileManagerObjectName(objectName);
	}

	public String value() {
		return this.objectName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FileManagerObjectName that)) return false;
		return this.objectName.equals(that.objectName);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(objectName);
	}

	@Override
	public String toString() {
		return String.valueOf(objectName);
	}
}
