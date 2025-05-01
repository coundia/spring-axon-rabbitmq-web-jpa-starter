package com.groupe2cs.bizyhub.settings.domain.valueObject;

import com.groupe2cs.bizyhub.settings.domain.exception.SettingIsActiveNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SettingIsActive implements Serializable {

	private Boolean isActive;

	public SettingIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public static SettingIsActive create(Boolean isActive) {
		if (isActive == null) {
			throw new SettingIsActiveNotValid("IsActive is invalid");
		}
		return new SettingIsActive(isActive);
	}

	public Boolean value() {
		return this.isActive;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SettingIsActive that)) return false;
		return this.isActive.equals(that.isActive);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(isActive);
	}

	@Override
	public String toString() {
		return String.valueOf(isActive);
	}
}
