package com.sda.studysystem.models;

import com.sda.studysystem.utils.constraints.ValidTeacher;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Teacher model
 *
 * @author Vinod John
 */
@Data
@Entity
@ValidTeacher
@EqualsAndHashCode(callSuper = true)
public class Teacher extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String firstName;
    private String lastName;
    private String address;
    @NotBlank(message = "{messages.constraints.blank-teacher-email}")
    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.MERGE)
    private School school;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses;

    private boolean isActive;

    private LocalDate joinDate;
}
