package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementTypeStockMovementNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementQuantityNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementRemoteIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementLocalIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementAccountNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementCompanyNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementSyncAtNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementProductVariantNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementOrderLineIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementDiscriminatorNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class StockMovementDiscriminator implements Serializable {

private String discriminator;

public StockMovementDiscriminator(String discriminator) {
this.discriminator = discriminator;
}

public static StockMovementDiscriminator create(String discriminator) {

	return new StockMovementDiscriminator(discriminator);
}

public String value() {
return this.discriminator;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockMovementDiscriminator that)) return false;
return this.discriminator.equals(that.discriminator);
}

@Override
public int hashCode() {
return java.util.Objects.hash(discriminator);
}

@Override
public String toString() {
return String.valueOf(discriminator);
}
}
