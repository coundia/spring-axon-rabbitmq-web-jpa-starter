package com.groupe2cs.bizyhub.transactions.infrastructure.repository;

import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

	//Page<Transaction> findAll(Pageable pageable);

	//Optional<Transaction> findById(String id);

	Optional<Transaction> findByIdAndCreatedById(String id, String createdById);

	Page<Transaction> findByCreatedById(Pageable pageable, String createdById);

	Page<Transaction> findAllByTenantId(Pageable pageable, String tenantId);


	Optional<Transaction> findByReference(String reference);

	Optional<Transaction> findByReferenceAndCreatedById(String reference, String createdById);

	Optional<Transaction> findByReferenceAndTenantName(String reference, String tenantName);

	Optional<Transaction> findByReferenceAndTenantId(String reference, String tenantId);

	List<Transaction> findByAmountAndCreatedById(Double amount, String createdById);

	Optional<Transaction> findByAmountAndTenantName(Double amount, String tenantName);

	Optional<Transaction> findByAmountAndTenantId(Double amount, String tenantId);

	List<Transaction> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	Optional<Transaction> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	Optional<Transaction> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	List<Transaction> findByTenantIdAndCreatedById(String tenant, String createdById);

	Optional<Transaction> findByTenantIdAndTenantName(String tenant, String tenantName);

	Optional<Transaction> findByTenantIdAndTenantId(String tenant, String tenantId);


}
