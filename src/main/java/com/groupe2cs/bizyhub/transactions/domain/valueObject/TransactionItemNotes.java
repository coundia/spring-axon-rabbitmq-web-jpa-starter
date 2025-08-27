package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemProductNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLabelNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemQuantityNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemSyncAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitPriceNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTotalNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemNotesNotValid;

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
public class TransactionItemNotes implements Serializable {

private String notes;

public TransactionItemNotes(String notes) {
this.notes = notes;
}

public static TransactionItemNotes create(String notes) {

	return new TransactionItemNotes(notes);
}

public String value() {
return this.notes;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionItemNotes that)) return false;
return this.notes.equals(that.notes);
}

@Override
public int hashCode() {
return java.util.Objects.hash(notes);
}

@Override
public String toString() {
return String.valueOf(notes);
}
}
