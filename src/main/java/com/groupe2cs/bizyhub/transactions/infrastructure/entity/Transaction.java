package com.groupe2cs.bizyhub.transactions.infrastructure.entity;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	private String id;

	@Column(nullable = true, unique = true)
	private String reference;
	@Column(nullable = false, unique = false)
	private Double amount;
	public Transaction(String id) {
	this.id = id;
}

	@Override
 public String toString() {
	return "Transaction{" +
	"id='" + id + '\'' +
		", reference=" + reference +
		", amount=" + amount +
	'}';
	}
}
