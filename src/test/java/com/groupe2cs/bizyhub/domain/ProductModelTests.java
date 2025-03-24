package com.groupe2cs.bizyhub.domain;

import com.groupe2cs.bizyhub.products.domain.aggregate.ProductAggregate;
import com.groupe2cs.bizyhub.products.domain.exception.PriceNotCorrect;
import com.groupe2cs.bizyhub.products.domain.exception.PriceNotCorrectInterface;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductModelTests extends BaseUnitTests {


    @Test
    void it_should_create_product_with_valid_values() {
        ProductPrice price = ProductPrice.create(100);
        ProductName name = ProductName.create("Test Product");
        ProductAggregate product = ProductAggregate.create(price, name);
        assertThat(product.getId()).isNotNull();
        assertThat(product.getPrice()).isEqualTo(price);
        assertThat(product.getName()).isEqualTo(name);
        assertThat(product.isDeleted()).isFalse();
    }

    @Test
    void it_should_mark_product_as_deleted() {
        ProductPrice price = ProductPrice.create(100);
        ProductName name = ProductName.create("Test Product");

        ProductAggregate product = ProductAggregate.create(price, name);
        ProductAggregate deletedProduct = product.markAsDeleted();

        assertThat(deletedProduct.isDeleted()).isTrue();
        assertThat(deletedProduct.getId()).isEqualTo(product.getId());
    }

    @Test
    void it_should_create_product_with_invalid_price() {
        PriceNotCorrectInterface error = assertThrows(PriceNotCorrect.class, () -> ProductPrice.create(-1));
        assertThat(error.getMessage()).isEqualTo("Price not correct");
    }
}
