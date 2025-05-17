package com.groupe2cs.bizyhub.chats.infrastructure.repository;

import com.groupe2cs.bizyhub.chats.infrastructure.entity.Chat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat, String> {

	@Query("SELECT e FROM Chat e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<Chat> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM Chat e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByIdAndTenantId(String id, String tenantId);

	Page<Chat> findByCreatedById(String createdById, Pageable pageable);

	Page<Chat> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM Chat e WHERE e.messages = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Chat> findByMessagesAndCreatedById(String messages, String createdById);


	@Query("SELECT e FROM Chat e WHERE e.messages = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Chat> findByMessages(String messages);

	@Query("SELECT e FROM Chat e WHERE e.messages = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByMessagesAndTenantName(String messages, String tenantName);

	@Query("SELECT e FROM Chat e WHERE e.messages = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByMessagesAndTenantId(String messages, String tenantId);

	@Query("SELECT e FROM Chat e WHERE e.responsesJson = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Chat> findByResponsesJsonAndCreatedById(String responsesJson, String createdById);


	@Query("SELECT e FROM Chat e WHERE e.responsesJson = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Chat> findByResponsesJson(String responsesJson);

	@Query("SELECT e FROM Chat e WHERE e.responsesJson = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByResponsesJsonAndTenantName(String responsesJson, String tenantName);

	@Query("SELECT e FROM Chat e WHERE e.responsesJson = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByResponsesJsonAndTenantId(String responsesJson, String tenantId);

	@Query("SELECT e FROM Chat e WHERE e.responses = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Chat> findByResponsesAndCreatedById(String responses, String createdById);


	@Query("SELECT e FROM Chat e WHERE e.responses = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Chat> findByResponses(String responses);

	@Query("SELECT e FROM Chat e WHERE e.responses = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByResponsesAndTenantName(String responses, String tenantName);

	@Query("SELECT e FROM Chat e WHERE e.responses = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByResponsesAndTenantId(String responses, String tenantId);

	@Query("SELECT e FROM Chat e WHERE e.state = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Chat> findByStateAndCreatedById(String state, String createdById);


	@Query("SELECT e FROM Chat e WHERE e.state = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Chat> findByState(String state);

	@Query("SELECT e FROM Chat e WHERE e.state = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByStateAndTenantName(String state, String tenantName);

	@Query("SELECT e FROM Chat e WHERE e.state = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByStateAndTenantId(String state, String tenantId);

	@Query("SELECT e FROM Chat e WHERE e.account.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Chat> findByAccountIdAndCreatedById(String account, String createdById);


	@Query("SELECT e FROM Chat e WHERE e.account.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Chat> findByAccountId(String account);

	@Query("SELECT e FROM Chat e WHERE e.account.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByAccountIdAndTenantName(String account, String tenantName);

	@Query("SELECT e FROM Chat e WHERE e.account.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByAccountIdAndTenantId(String account, String tenantId);

	@Query("SELECT e FROM Chat e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Chat> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);


	@Query("SELECT e FROM Chat e WHERE e.updatedAt = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Chat> findByUpdatedAt(java.time.Instant updatedAt);

	@Query("SELECT e FROM Chat e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM Chat e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);

	@Query("SELECT e FROM Chat e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Chat> findByReferenceAndCreatedById(String reference, String createdById);


	@Query("SELECT e FROM Chat e WHERE e.reference = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Chat> findByReference(String reference);

	@Query("SELECT e FROM Chat e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM Chat e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByReferenceAndTenantId(String reference, String tenantId);

	@Query("SELECT e FROM Chat e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Chat> findByCreatedByIdAndCreatedById(String createdBy, String createdById);


	@Query("SELECT e FROM Chat e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Chat> findByCreatedById(String createdBy);

	@Query("SELECT e FROM Chat e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Chat e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Chat e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Chat> findByTenantIdAndCreatedById(String tenant, String createdById);


	@Query("SELECT e FROM Chat e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Chat> findByTenantId(String tenant);

	@Query("SELECT e FROM Chat e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Chat e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Chat> findByTenantIdAndTenantId(String tenant, String tenantId);


}
