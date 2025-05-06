package com.groupe2cs.bizyhub.products.domain.event;

	import com.groupe2cs.bizyhub.products.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdatedEvent implements Serializable {

	private ProductId id;
	private ProductName name;
	private ProductPrice price;
	private ProductDetails details;
	private ProductIsActive isActive;
	private ProductUpdatedAt updatedAt;
	private ProductReference reference;
	private ProductCreatedBy createdBy;
	private ProductTenant tenant;



}
