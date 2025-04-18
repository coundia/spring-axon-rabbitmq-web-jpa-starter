package com.groupe2cs.bizyhub.transactions.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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

	@Column(nullable = false)
	private String reference;
	@Column(nullable = false)
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
