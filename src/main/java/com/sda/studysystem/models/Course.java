package com.sda.studysystem.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Course model
 *
 * @author Vinod John
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Course extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Double durationHours;
    private boolean isActive;
}
