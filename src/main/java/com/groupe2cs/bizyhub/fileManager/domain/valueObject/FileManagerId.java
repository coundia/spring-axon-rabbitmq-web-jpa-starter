package com.groupe2cs.bizyhub.fileManager.domain.valueObject;

import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class FileManagerId implements Serializable {

	private String id;

	public FileManagerId(String id) {
		this.id = id;
	}

	public static FileManagerId create(String id) {

		if (id == null || id.isBlank()) {
			throw new FileManagerIdNotValid("Id is invalid");
		}
		return new FileManagerId(id);
	}

	public String value() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FileManagerId that)) return false;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
