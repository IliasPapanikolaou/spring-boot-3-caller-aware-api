package com.ipap.springboot3senderawareapi.repository;

import com.ipap.springboot3senderawareapi.entity.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
    Optional<EmailTemplate> findByIdAndCallerId(Long id, String callerId);
    List<EmailTemplate> findEmailTemplateByCallerId(String callerId);
}
