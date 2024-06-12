package com.ipap.springboot3senderawareapi.entity;

import jakarta.persistence.*;

@Entity
public class EmailTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String callerId; // Caller ID to identify the owner

    private String templateName;

    @Lob
    private String templateContent;

    public EmailTemplate(Long id, String callerId, String templateName, String templateContent) {
        this.id = id;
        this.callerId = callerId;
        this.templateName = templateName;
        this.templateContent = templateContent;
    }

    public EmailTemplate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }
}
