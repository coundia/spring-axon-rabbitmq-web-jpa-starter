package com.groupe2cs.bizyhub.categories.domain.valueObject;

import com.groupe2cs.bizyhub.categories.domain.exception.CategoryFilesNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryFiles implements Serializable {

	private String files;

	public CategoryFiles(String files) {
		this.files = files;
	}

	public static CategoryFiles create(String files) {

		if (files == null || files.isBlank()) {
			throw new CategoryFilesNotValid("Files is invalid");
		}
		return new CategoryFiles(files);
	}

	public String value() {
		return this.files;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryFiles that)) return false;
		return this.files.equals(that.files);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(files);
	}

	@Override
	public String toString() {
		return String.valueOf(files);
	}
}
