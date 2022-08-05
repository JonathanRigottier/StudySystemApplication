package com.sda.studysystem.repositories;

import com.sda.studysystem.models.Course;
import com.sda.studysystem.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * To handle course related DB operations
 *
 * @author Vinod John
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    Optional<Course> findByName(String name);
}
