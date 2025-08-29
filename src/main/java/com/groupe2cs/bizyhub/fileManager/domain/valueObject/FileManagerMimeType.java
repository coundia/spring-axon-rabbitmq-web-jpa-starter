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
