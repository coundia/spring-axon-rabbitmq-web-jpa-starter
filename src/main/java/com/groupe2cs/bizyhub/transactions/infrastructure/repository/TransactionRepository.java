package com.groupe2cs.bizyhub.transactions.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

	@Query("SELECT t FROM Transaction t ")
	Page<Transaction> findAll(Pageable pageable);

	@Query("SELECT t FROM Transaction t WHERE t.id = :id")
	Optional<Transaction> findById(Transaction id);

	@Query("SELECT t FROM Transaction t WHERE t.reference = :reference")
	Optional<Transaction> findByReference(String reference);

	@Query("SELECT t FROM Transaction t WHERE t.amount = :amount")
	List<Transaction> findByAmount(Double amount);

	@Query("SELECT t FROM Transaction t WHERE t.createdBy = :createdBy")
	List<Transaction> findByCreatedBy(String createdBy);

	@Query("SELECT t FROM Transaction t WHERE t.tenant = :tenant")
	List<Transaction> findByTenant(String tenant);

	Optional<Transaction> findByCreatedByAndTenant(User createdBy, Tenant tenant);
}
