package com.sda.studysystem.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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
@EqualsAndHashCode(callSuper = true)
public class Teacher extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.MERGE)
    private School school;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses;

    private boolean isActive;

    private LocalDate joinDate;
}
