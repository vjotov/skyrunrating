package com.jotov.skyrunrating.entity;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

//@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public abstract class AEntity {
    protected Date modificationTime;
    protected Date creationTime;

    @PreUpdate
    public void preUpdate() {
        this.modificationTime = new Date();
    }

    @PrePersist
    public void getCreationTime() {
        Date now = new Date();
        this.creationTime = now;
        this.modificationTime = now;
    }
}
