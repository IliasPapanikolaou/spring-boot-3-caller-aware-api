package com.ipap.springboot3senderawareapi.controller;

import com.ipap.springboot3senderawareapi.annotation.CallerCheck;
import com.ipap.springboot3senderawareapi.entity.EmailTemplate;
import com.ipap.springboot3senderawareapi.service.EmailTemplateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/templates")
public class EmailTemplateController {

    private final EmailTemplateService emailTemplateService;

    public EmailTemplateController(EmailTemplateService emailTemplateService) {
        this.emailTemplateService = emailTemplateService;
    }

    @PostMapping
    @CallerCheck
    public ResponseEntity<EmailTemplate> createTemplate(@RequestBody EmailTemplate template) {
        EmailTemplate createdTemplate = emailTemplateService.saveTemplate(template);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTemplate);
    }

    @PutMapping("/{id}")
    @CallerCheck
    public ResponseEntity<EmailTemplate> updateTemplate(@PathVariable Long id, @RequestBody EmailTemplate template) {
        EmailTemplate updatedTemplate = emailTemplateService.updateTemplate(id, template);
        return ResponseEntity.ok(updatedTemplate);
    }

    @GetMapping
    @CallerCheck
    public Iterable<EmailTemplate> getAllTemplates() {
        return emailTemplateService.getAllTemplates();
    }
}

