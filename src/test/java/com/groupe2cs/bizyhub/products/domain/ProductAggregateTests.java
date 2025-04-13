package com.groupe2cs.bizyhub.products.domain;

import com.groupe2cs.bizyhub.products.domain.exception.ProductIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNameNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductPriceNotValid;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;
import com.groupe2cs.bizyhub.products.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductAggregateTests extends BaseUnitTests {

    @Test
    void it_should_create_product_with_valid_values() {
        ProductId id = ProductId.create("test");
        ProductName name = ProductName.create("test");
        ProductPrice price = ProductPrice.create(99.99);
        ProductAggregate product = new ProductAggregate(id, name, price);
        assertThat(product.getId()).isNotNull();
        assertThat(product.getId()).isEqualTo(id);
        assertThat(product.getName()).isEqualTo(name);
        assertThat(product.getPrice()).isEqualTo(price);
    }

    @Test
    void it_should_throw_when_id_is_invalid() {
        ProductIdNotValid error = assertThrows(ProductIdNotValid.class, () -> ProductId.create(""));
        assertThat(error.getMessage()).isEqualTo("Id is invalid");
    }

    @Test
    void it_should_throw_when_name_is_invalid() {
        ProductNameNotValid error =
                assertThrows(ProductNameNotValid.class, () -> ProductName.create(""));
        assertThat(error.getMessage()).isEqualTo("Name is invalid");
    }

    @Test
    void it_should_throw_when_price_is_invalid() {
        ProductPriceNotValid error =
                assertThrows(ProductPriceNotValid.class, () -> ProductPrice.create(null));
        assertThat(error.getMessage()).isEqualTo("Price is invalid");
    }
}
