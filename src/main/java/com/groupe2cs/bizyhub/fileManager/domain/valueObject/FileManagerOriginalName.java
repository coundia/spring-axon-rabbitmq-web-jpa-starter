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
public class FileManagerOriginalName implements Serializable {

	private String originalName;

	public FileManagerOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public static FileManagerOriginalName create(String originalName) {

		return new FileManagerOriginalName(originalName);
	}

	public String value() {
		return this.originalName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FileManagerOriginalName that)) return false;
		return this.originalName.equals(that.originalName);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(originalName);
	}

	@Override
	public String toString() {
		return String.valueOf(originalName);
	}
}
