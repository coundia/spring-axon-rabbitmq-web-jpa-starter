package com.groupe2cs.bizyhub.transactions.infrastructure.entity;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transactions {

	@Id
	private String id;
	@Column(nullable = false)
	private String reference;
	@Column(nullable = false)
	private Double amount;

	public Transactions(String id) {
		this.id = id;
	}

}
