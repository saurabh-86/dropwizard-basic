package com.company.db.entities;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long internalId;

    @NaturalId
    private UUID id;

    private String name;

    @Version
    private Integer version;
}
