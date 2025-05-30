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
public class FileManagerSize implements Serializable {

	private Long size;

	public FileManagerSize(Long size) {
		this.size = size;
	}

	public static FileManagerSize create(Long size) {

		return new FileManagerSize(size);
	}

	public Long value() {
		return this.size;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FileManagerSize that)) return false;
		return this.size.equals(that.size);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(size);
	}

	@Override
	public String toString() {
		return String.valueOf(size);
	}
}
