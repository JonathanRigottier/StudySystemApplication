package com.sda.studysystem.repositories;

import com.sda.studysystem.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository to handle Authority related queries
 *
 * @author Vinod John
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, UUID> {
    Optional<Authority> findByName (String name);
}
