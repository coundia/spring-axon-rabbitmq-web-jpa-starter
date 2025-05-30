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
public class FileManagerUri implements Serializable {

	private String uri;

	public FileManagerUri(String uri) {
		this.uri = uri;
	}

	public static FileManagerUri create(String uri) {

		return new FileManagerUri(uri);
	}

	public String value() {
		return this.uri;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FileManagerUri that)) return false;
		return this.uri.equals(that.uri);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uri);
	}

	@Override
	public String toString() {
		return String.valueOf(uri);
	}
}
