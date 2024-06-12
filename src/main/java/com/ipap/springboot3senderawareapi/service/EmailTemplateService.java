package com.ipap.springboot3senderawareapi.service;

import com.ipap.springboot3senderawareapi.annotation.CallerContext;
import com.ipap.springboot3senderawareapi.entity.EmailTemplate;
import com.ipap.springboot3senderawareapi.repository.EmailTemplateRepository;
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
        template.setCaller(callerName);
        return emailTemplateRepository.save(template);
    }

    public EmailTemplate updateTemplate(Long id, EmailTemplate updatedTemplate) {
        String callerName = CallerContext.getCallerName();
        EmailTemplate existingTemplate = emailTemplateRepository.findByIdAndCaller(id, callerName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Not allowed to modify this template"));

        existingTemplate.setTemplateName(updatedTemplate.getTemplateName());
        existingTemplate.setTemplateContent(updatedTemplate.getTemplateContent());

        return emailTemplateRepository.save(existingTemplate);
    }

    public Iterable<EmailTemplate> getAllTemplates() {
        String callerName = CallerContext.getCallerName();
        return emailTemplateRepository.findEmailTemplateByCaller(callerName);
    }
}

