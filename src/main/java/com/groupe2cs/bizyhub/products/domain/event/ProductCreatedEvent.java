package com.groupe2cs.bizyhub.products.domain.event;

	import com.groupe2cs.bizyhub.products.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvent implements Serializable {

	private ProductId id;
	private ProductName name;
	private ProductPrice price;



}
