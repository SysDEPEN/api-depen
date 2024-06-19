package com.br.depen.api_depen.listeners;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.data.domain.Auditable;

import java.util.Date;

public class AuditListener {

    @PrePersist
    public void setCreatedOn(Object entity) {
        if (entity instanceof Auditable) {
            ((Auditable) entity).setCreatedAt(new Date());
            ((Auditable) entity).setUpdatedAt(new Date());
        }
    }

    @PreUpdate
    public void setUpdatedOn(Object entity) {
        if (entity instanceof Auditable) {
            ((Auditable) entity).setUpdatedAt(new Date());
        }
    }
}
