package com.sda.studysystem.models;

import com.sda.studysystem.utils.constraints.ValidCourse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

/**
 * Course model
 *
 * @author Vinod John
 */
@Data
@Entity
@ValidCourse
@EqualsAndHashCode(callSuper = true)
public class Course extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotBlank(message = "{messages.constraints.blank-course-name}")
    private String name;
    private Double durationHours;
    private boolean isActive;
}
