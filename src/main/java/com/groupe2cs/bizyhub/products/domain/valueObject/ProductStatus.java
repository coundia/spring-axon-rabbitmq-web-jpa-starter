package com.groupe2cs.bizyhub.products.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.products.domain.exception.ProductIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductRemoteIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductLocalIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductCodeNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNameNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductDescriptionNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductStatusNotValid;

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
public class ProductStatus implements Serializable {

	private String status;

	public ProductStatus(String status) {
		this.status = status;
	}

	public static ProductStatus create(String status) {

		return new ProductStatus(status);
	}

	public String value() {
		return this.status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductStatus that)) return false;
		return this.status.equals(that.status);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(status);
	}

	@Override
	public String toString() {
		return String.valueOf(status);
	}
}
