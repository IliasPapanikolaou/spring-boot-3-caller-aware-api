package com.ipap.springboot3senderawareapi.entity;

import jakarta.persistence.*;

@Entity
public class EmailTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caller; // Caller Name to identify the owner

    private String templateName;

    @Lob
    private String templateContent;

    public EmailTemplate(Long id, String caller, String templateName, String templateContent) {
        this.id = id;
        this.caller = caller;
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

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
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
