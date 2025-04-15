package com.groupe2cs.bizyhub.sales.domain;

import com.groupe2cs.bizyhub.sales.domain.exception.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SaleAggregateTests extends BaseUnitTests {

    @Test
    void it_should_create_sale_with_valid_values() {
        SaleId id = SaleId.create("test");
        SaleQuantity quantity = SaleQuantity.create(42);
        SaleTotal_price total_price = SaleTotal_price.create(99.99);
        SaleFacture facture = SaleFacture.create("test");
        SaleProduct Product = SaleProduct.create("test");
        SaleAggregate sale = new SaleAggregate(id, quantity, total_price, facture, Product);
        assertThat(sale.getId()).isNotNull();
        assertThat(sale.getId()).isEqualTo(id);
        assertThat(sale.getQuantity()).isEqualTo(quantity);
        assertThat(sale.getTotal_price()).isEqualTo(total_price);
        assertThat(sale.getFacture()).isEqualTo(facture);
        assertThat(sale.getProduct()).isEqualTo(Product);
    }

    @Test
    void it_should_throw_when_id_is_invalid() {
        SaleIdNotValid error = assertThrows(SaleIdNotValid.class, () -> SaleId.create(""));
        assertThat(error.getMessage()).isEqualTo("Id is invalid");
    }

    @Test
    void it_should_throw_when_quantity_is_invalid() {
        SaleQuantityNotValid error = assertThrows(SaleQuantityNotValid.class, () -> SaleQuantity.create(-1));
        assertThat(error.getMessage()).isEqualTo("Quantity is invalid");
    }

    @Test
    void it_should_throw_when_total_price_is_invalid() {
        SaleTotal_priceNotValid error = assertThrows(SaleTotal_priceNotValid.class, () -> SaleTotal_price.create(null));
        assertThat(error.getMessage()).isEqualTo("Total_price is invalid");
    }

    @Test
    void it_should_throw_when_facture_is_invalid() {
        SaleFactureNotValid error = assertThrows(SaleFactureNotValid.class, () -> SaleFacture.create(""));
        assertThat(error.getMessage()).isEqualTo("Facture is invalid");
    }

    @Test
    void it_should_throw_when_Product_is_invalid() {
        SaleProductNotValid error = assertThrows(SaleProductNotValid.class, () -> SaleProduct.create(""));
        assertThat(error.getMessage()).isEqualTo("Product is invalid");
    }

}
