package com.mcode.fisco.backend.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class GenericModel {
    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;
}
