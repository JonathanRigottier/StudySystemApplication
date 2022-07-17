package com.sda.studysystem.repositories;

import com.sda.studysystem.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to handle school related DB operations
 *
 * @author Vinod John
 */
@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

}
