package com.ipap.springboot3customannotationapi.repository;

import com.ipap.springboot3customannotationapi.entity.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
    Optional<EmailTemplate> findByIdAndCallerId(Long id, String callerId);
}
