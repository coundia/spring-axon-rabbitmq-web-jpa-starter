package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelRemoteIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelLocalIdNotValid;

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
public class StockLevelLocalId implements Serializable {

private String localId;

public StockLevelLocalId(String localId) {
this.localId = localId;
}

public static StockLevelLocalId create(String localId) {

	return new StockLevelLocalId(localId);
}

public String value() {
return this.localId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockLevelLocalId that)) return false;
return this.localId.equals(that.localId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(localId);
}

@Override
public String toString() {
return String.valueOf(localId);
}
}
