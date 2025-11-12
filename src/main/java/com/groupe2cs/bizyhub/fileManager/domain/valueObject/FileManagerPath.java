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
