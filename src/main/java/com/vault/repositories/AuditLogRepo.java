package com.vault.repositories;

import com.vault.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface AuditLogRepo extends JpaRepository<AuditLog, Long>{
    List<AuditLog> findByUserId(UUID userId);
    
}
