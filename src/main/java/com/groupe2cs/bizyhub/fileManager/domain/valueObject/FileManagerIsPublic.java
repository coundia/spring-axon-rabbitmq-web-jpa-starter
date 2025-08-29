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
