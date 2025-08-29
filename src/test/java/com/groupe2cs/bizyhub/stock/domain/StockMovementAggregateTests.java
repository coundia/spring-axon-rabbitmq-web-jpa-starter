package com.groupe2cs.bizyhub.stock.domain;

import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.stock.domain.exception.*;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import org.junit.jupiter.api.Test;


public class StockMovementAggregateTests extends BaseUnitTests {

@Test
void it_should_create_stockMovement_with_valid_values() {
	StockMovementId id = StockMovementId.create(UUID.randomUUID().toString());
	StockMovementTypeStockMovement typeStockMovement = StockMovementTypeStockMovement.create(UUID.randomUUID().toString());
	StockMovementQuantity quantity = StockMovementQuantity.create(93);
	StockMovementRemoteId remoteId = StockMovementRemoteId.create(UUID.randomUUID().toString());
	StockMovementLocalId localId = StockMovementLocalId.create(UUID.randomUUID().toString());
	StockMovementAccount account = StockMovementAccount.create(UUID.randomUUID().toString());
	StockMovementCompany company = StockMovementCompany.create(UUID.randomUUID().toString());
	StockMovementSyncAt syncAt = StockMovementSyncAt.create(java.time.Instant.now().plusSeconds(3600));
	StockMovementProductVariant productVariant = StockMovementProductVariant.create(UUID.randomUUID().toString());
	StockMovementOrderLineId orderLineId = StockMovementOrderLineId.create(UUID.randomUUID().toString());
	StockMovementDiscriminator discriminator = StockMovementDiscriminator.create(UUID.randomUUID().toString());
	StockMovementCreatedBy createdBy = StockMovementCreatedBy.create(UUID.randomUUID().toString());
	StockMovementTenant tenant = StockMovementTenant.create(UUID.randomUUID().toString());
	StockMovementAggregate aggregateStockMovementAggregate = new StockMovementAggregate(id, typeStockMovement, quantity, remoteId, localId, account, company, syncAt, productVariant, orderLineId, discriminator, createdBy, tenant);
	assertThat(aggregateStockMovementAggregate.getId()).isNotNull();
	assertThat(aggregateStockMovementAggregate.getId()).isEqualTo(id);
	assertThat(aggregateStockMovementAggregate.getTypeStockMovement()).isEqualTo(typeStockMovement);
	assertThat(aggregateStockMovementAggregate.getQuantity()).isEqualTo(quantity);
	assertThat(aggregateStockMovementAggregate.getRemoteId()).isEqualTo(remoteId);
	assertThat(aggregateStockMovementAggregate.getLocalId()).isEqualTo(localId);
	assertThat(aggregateStockMovementAggregate.getAccount()).isEqualTo(account);
	assertThat(aggregateStockMovementAggregate.getCompany()).isEqualTo(company);
	assertThat(aggregateStockMovementAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateStockMovementAggregate.getProductVariant()).isEqualTo(productVariant);
	assertThat(aggregateStockMovementAggregate.getOrderLineId()).isEqualTo(orderLineId);
	assertThat(aggregateStockMovementAggregate.getDiscriminator()).isEqualTo(discriminator);
	assertThat(aggregateStockMovementAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateStockMovementAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		StockMovementIdNotValid error = assertThrows(StockMovementIdNotValid.class, () -> StockMovementId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_typeStockMovement_is_invalid() {
		StockMovementTypeStockMovementNotValid error = assertThrows(StockMovementTypeStockMovementNotValid.class, () -> StockMovementTypeStockMovement.create(""));
		assertThat(error.getMessage()).isEqualTo("TypeStockMovement is invalid");
		}
		@Test
		void it_should_throw_when_quantity_is_invalid() {
		StockMovementQuantityNotValid error = assertThrows(StockMovementQuantityNotValid.class, () -> StockMovementQuantity.create(-1));
		assertThat(error.getMessage()).isEqualTo("Quantity is invalid");
		}

}
