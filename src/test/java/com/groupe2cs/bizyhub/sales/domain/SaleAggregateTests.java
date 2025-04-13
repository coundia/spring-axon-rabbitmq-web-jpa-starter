package com.groupe2cs.bizyhub.sales.domain;

import com.groupe2cs.bizyhub.sales.domain.exception.SaleFactureNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleQuantityNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleTotal_priceNotValid;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleFacture;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleId;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleQuantity;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleTotal_price;
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
        SaleAggregate sale = new SaleAggregate(id, quantity, total_price, facture);
        assertThat(sale.getId()).isNotNull();
        assertThat(sale.getId()).isEqualTo(id);
        assertThat(sale.getQuantity()).isEqualTo(quantity);
        assertThat(sale.getTotal_price()).isEqualTo(total_price);
        assertThat(sale.getFacture()).isEqualTo(facture);
    }

    @Test
    void it_should_throw_when_id_is_invalid() {
        SaleIdNotValid error = assertThrows(SaleIdNotValid.class, () -> SaleId.create(""));
        assertThat(error.getMessage()).isEqualTo("Id is invalid");
    }

    @Test
    void it_should_throw_when_quantity_is_invalid() {
        SaleQuantityNotValid error =
                assertThrows(SaleQuantityNotValid.class, () -> SaleQuantity.create(-1));
        assertThat(error.getMessage()).isEqualTo("Quantity is invalid");
    }

    @Test
    void it_should_throw_when_total_price_is_invalid() {
        SaleTotal_priceNotValid error =
                assertThrows(SaleTotal_priceNotValid.class, () -> SaleTotal_price.create(null));
        assertThat(error.getMessage()).isEqualTo("Total_price is invalid");
    }

    @Test
    void it_should_throw_when_facture_is_invalid() {
        SaleFactureNotValid error =
                assertThrows(SaleFactureNotValid.class, () -> SaleFacture.create(""));
        assertThat(error.getMessage()).isEqualTo("Facture is invalid");
    }
}
