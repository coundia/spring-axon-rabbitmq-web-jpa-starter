package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelRemoteIdNotValid;

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
public class StockLevelRemoteId implements Serializable {

private String remoteId;

public StockLevelRemoteId(String remoteId) {
this.remoteId = remoteId;
}

public static StockLevelRemoteId create(String remoteId) {

	return new StockLevelRemoteId(remoteId);
}

public String value() {
return this.remoteId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockLevelRemoteId that)) return false;
return this.remoteId.equals(that.remoteId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(remoteId);
}

@Override
public String toString() {
return String.valueOf(remoteId);
}
}
