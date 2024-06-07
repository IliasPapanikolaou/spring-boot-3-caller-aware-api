package com.ipap.springboot3customannotationapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "external")
public class CallerProperties {
    private List<Caller> callers = new ArrayList<>();

    public List<Caller> getCallers() {
        return callers;
    }

    public void setCallers(List<Caller> callers) {
        this.callers = callers;
    }

    public static class Caller {
        private String id; // Random ID
        private String name; // Actual caller name

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Caller{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
