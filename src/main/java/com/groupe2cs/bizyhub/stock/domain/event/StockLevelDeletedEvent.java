package com.groupe2cs.bizyhub.stock.domain.event;

import com.groupe2cs.bizyhub.stock.domain.valueObject.StockLevelId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockLevelDeletedEvent implements Serializable {


	private StockLevelId id;

}
