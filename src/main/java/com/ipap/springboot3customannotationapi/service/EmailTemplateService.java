package com.ipap.springboot3customannotationapi.service;

import com.ipap.springboot3customannotationapi.annotation.CallerContext;
import com.ipap.springboot3customannotationapi.entity.EmailTemplate;
import com.ipap.springboot3customannotationapi.repository.EmailTemplateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmailTemplateService {

    private final EmailTemplateRepository emailTemplateRepository;

    public EmailTemplateService(EmailTemplateRepository emailTemplateRepository) {
        this.emailTemplateRepository = emailTemplateRepository;
    }

    public EmailTemplate saveTemplate(EmailTemplate template) {
        String callerName = CallerContext.getCallerName();
        template.setCallerId(callerName);
        return emailTemplateRepository.save(template);
    }

    public EmailTemplate updateTemplate(Long id, EmailTemplate updatedTemplate) {
        String callerName = CallerContext.getCallerName();
        EmailTemplate existingTemplate = emailTemplateRepository.findByIdAndCallerId(id, callerName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Not allowed to modify this template"));

        existingTemplate.setTemplateName(updatedTemplate.getTemplateName());
        existingTemplate.setTemplateContent(updatedTemplate.getTemplateContent());

        return emailTemplateRepository.save(existingTemplate);
    }

    public Iterable<EmailTemplate> getAllTemplates() {
        return emailTemplateRepository.findAll();
    }
}

