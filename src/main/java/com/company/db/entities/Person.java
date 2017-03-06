package com.company.db.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(
        indexes = {
                @Index(columnList = "id")
        })
@Data
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long internalId;

    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;

    @Version
    private Integer version;
}
