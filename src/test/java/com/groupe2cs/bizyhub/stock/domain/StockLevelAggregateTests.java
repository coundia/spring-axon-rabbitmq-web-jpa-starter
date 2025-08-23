package com.groupe2cs.bizyhub.stock.domain;

import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.stock.domain.exception.*;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import org.junit.jupiter.api.Test;


public class StockLevelAggregateTests extends BaseUnitTests {

@Test
void it_should_create_stockLevel_with_valid_values() {
	StockLevelId id = StockLevelId.create(UUID.randomUUID().toString());
	StockLevelStockOnHand stockOnHand = StockLevelStockOnHand.create(35);
	StockLevelStockAllocated stockAllocated = StockLevelStockAllocated.create(19);
	StockLevelProductVariant productVariant = StockLevelProductVariant.create(UUID.randomUUID().toString());
	StockLevelSyncAt syncAt = StockLevelSyncAt.create(java.time.Instant.now().plusSeconds(3600));
	StockLevelCompany company = StockLevelCompany.create(UUID.randomUUID().toString());
	StockLevelCreatedBy createdBy = StockLevelCreatedBy.create(UUID.randomUUID().toString());
	StockLevelTenant tenant = StockLevelTenant.create(UUID.randomUUID().toString());
	StockLevelAggregate aggregateStockLevelAggregate = new StockLevelAggregate(id, stockOnHand, stockAllocated, productVariant, syncAt, company, createdBy, tenant);
	assertThat(aggregateStockLevelAggregate.getId()).isNotNull();
	assertThat(aggregateStockLevelAggregate.getId()).isEqualTo(id);
	assertThat(aggregateStockLevelAggregate.getStockOnHand()).isEqualTo(stockOnHand);
	assertThat(aggregateStockLevelAggregate.getStockAllocated()).isEqualTo(stockAllocated);
	assertThat(aggregateStockLevelAggregate.getProductVariant()).isEqualTo(productVariant);
	assertThat(aggregateStockLevelAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateStockLevelAggregate.getCompany()).isEqualTo(company);
	assertThat(aggregateStockLevelAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateStockLevelAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		StockLevelIdNotValid error = assertThrows(StockLevelIdNotValid.class, () -> StockLevelId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_productVariant_is_invalid() {
		StockLevelProductVariantNotValid error = assertThrows(StockLevelProductVariantNotValid.class, () -> StockLevelProductVariant.create(""));
		assertThat(error.getMessage()).isEqualTo("ProductVariant is invalid");
		}
		@Test
		void it_should_throw_when_company_is_invalid() {
		StockLevelCompanyNotValid error = assertThrows(StockLevelCompanyNotValid.class, () -> StockLevelCompany.create(""));
		assertThat(error.getMessage()).isEqualTo("Company is invalid");
		}

}
