package com.groupe2cs.bizyhub.products.domain.event;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDeletedEvent implements Serializable {

    private ProductId id;
}
