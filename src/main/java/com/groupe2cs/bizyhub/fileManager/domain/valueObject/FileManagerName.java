package com.groupe2cs.bizyhub.fileManager.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerIdNotValid;
import com.groupe2cs.bizyhub.fileManager.domain.exception.FileManagerNameNotValid;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class FileManagerName implements Serializable {

	private String name;

	public FileManagerName(String name) {
		this.name = name;
	}

	public static FileManagerName create(String name) {

		if (name == null || name.isBlank()) {
			throw new FileManagerNameNotValid("Name is invalid");
		}
		return new FileManagerName(name);
	}

	public String value() {
		return this.name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FileManagerName that)) return false;
		return this.name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(name);
	}

	@Override
	public String toString() {
		return String.valueOf(name);
	}
}
