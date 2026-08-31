package com.vault.repositories;

import com.vault.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface DocRepo extends JpaRepository<Document, UUID> {
    List<Document> findByDepartment(String department);
    List<Document> findByOwnerId(UUID ownerId);
    
}
