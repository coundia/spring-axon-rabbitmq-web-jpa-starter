package com.groupe2cs.bizyhub.products.domain;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.groupe2cs.bizyhub.products.domain.exception.*;


public class ProductAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_product_with_valid_values() {
		ProductId id = ProductId.create(UUID.randomUUID().toString());
		ProductRemoteId remoteId = ProductRemoteId.create(UUID.randomUUID().toString());
		ProductLocalId localId = ProductLocalId.create(UUID.randomUUID().toString());
		ProductCode code = ProductCode.create(UUID.randomUUID().toString());
		ProductName name = ProductName.create(UUID.randomUUID().toString());
		ProductDescription description = ProductDescription.create(UUID.randomUUID().toString());
		ProductStatus status = ProductStatus.create(UUID.randomUUID().toString());
		ProductIsPublic isPublic = ProductIsPublic.create(true);
		ProductHasSold hasSold = ProductHasSold.create(true);
		ProductHasPrice hasPrice = ProductHasPrice.create(true);
		ProductLevel level = ProductLevel.create(UUID.randomUUID().toString());
		ProductQuantity quantity = ProductQuantity.create(6);
		ProductBarcode barcode = ProductBarcode.create(UUID.randomUUID().toString());
		ProductCompany company = ProductCompany.create(UUID.randomUUID().toString());
		ProductUnit unit = ProductUnit.create(UUID.randomUUID().toString());
		ProductSyncAt syncAt = ProductSyncAt.create(java.time.Instant.now().plusSeconds(3600));
		ProductCategory category = ProductCategory.create(UUID.randomUUID().toString());
		ProductAccount account = ProductAccount.create(UUID.randomUUID().toString());
		ProductDefaultPrice defaultPrice = ProductDefaultPrice.create(5066.99);
		ProductStatuses statuses = ProductStatuses.create(UUID.randomUUID().toString());
		ProductPurchasePrice purchasePrice = ProductPurchasePrice.create(4623.7);
		ProductCreatedBy createdBy = ProductCreatedBy.create(UUID.randomUUID().toString());
		ProductTenant tenant = ProductTenant.create(UUID.randomUUID().toString());
		ProductAggregate
				aggregateProductAggregate =
				new ProductAggregate(id,
						remoteId,
						localId,
						code,
						name,
						description,
						status,
						isPublic,
						hasSold,
						hasPrice,
						level,
						quantity,
						barcode,
						company,
						unit,
						syncAt,
						category,
						account,
						defaultPrice,
						statuses,
						purchasePrice,
						createdBy,
						tenant);
		assertThat(aggregateProductAggregate.getId()).isNotNull();
		assertThat(aggregateProductAggregate.getId()).isEqualTo(id);
		assertThat(aggregateProductAggregate.getRemoteId()).isEqualTo(remoteId);
		assertThat(aggregateProductAggregate.getLocalId()).isEqualTo(localId);
		assertThat(aggregateProductAggregate.getCode()).isEqualTo(code);
		assertThat(aggregateProductAggregate.getName()).isEqualTo(name);
		assertThat(aggregateProductAggregate.getDescription()).isEqualTo(description);
		assertThat(aggregateProductAggregate.getStatus()).isEqualTo(status);
		assertThat(aggregateProductAggregate.getIsPublic()).isEqualTo(isPublic);
		assertThat(aggregateProductAggregate.getHasSold()).isEqualTo(hasSold);
		assertThat(aggregateProductAggregate.getHasPrice()).isEqualTo(hasPrice);
		assertThat(aggregateProductAggregate.getLevel()).isEqualTo(level);
		assertThat(aggregateProductAggregate.getQuantity()).isEqualTo(quantity);
		assertThat(aggregateProductAggregate.getBarcode()).isEqualTo(barcode);
		assertThat(aggregateProductAggregate.getCompany()).isEqualTo(company);
		assertThat(aggregateProductAggregate.getUnit()).isEqualTo(unit);
		assertThat(aggregateProductAggregate.getSyncAt()).isEqualTo(syncAt);
		assertThat(aggregateProductAggregate.getCategory()).isEqualTo(category);
		assertThat(aggregateProductAggregate.getAccount()).isEqualTo(account);
		assertThat(aggregateProductAggregate.getDefaultPrice()).isEqualTo(defaultPrice);
		assertThat(aggregateProductAggregate.getStatuses()).isEqualTo(statuses);
		assertThat(aggregateProductAggregate.getPurchasePrice()).isEqualTo(purchasePrice);
		assertThat(aggregateProductAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateProductAggregate.getTenant()).isEqualTo(tenant);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		ProductIdNotValid error = assertThrows(ProductIdNotValid.class, () -> ProductId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_code_is_invalid() {
		ProductCodeNotValid error = assertThrows(ProductCodeNotValid.class, () -> ProductCode.create(""));
		assertThat(error.getMessage()).isEqualTo("Code is invalid");
	}

	@Test
	void it_should_throw_when_name_is_invalid() {
		ProductNameNotValid error = assertThrows(ProductNameNotValid.class, () -> ProductName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
	}

	@Test
	void it_should_throw_when_defaultPrice_is_invalid() {
		ProductDefaultPriceNotValid
				error =
				assertThrows(ProductDefaultPriceNotValid.class, () -> ProductDefaultPrice.create(null));
		assertThat(error.getMessage()).isEqualTo("DefaultPrice is invalid");
	}

	@Test
	void it_should_throw_when_purchasePrice_is_invalid() {
		ProductPurchasePriceNotValid
				error =
				assertThrows(ProductPurchasePriceNotValid.class, () -> ProductPurchasePrice.create(null));
		assertThat(error.getMessage()).isEqualTo("PurchasePrice is invalid");
	}

}
