package com.sda.studysystem.repositories;

import com.sda.studysystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository to handle user related queries
 *
 * @author Vinod John
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUserName(String userName);

    Optional<User> findByUserNameAndPassword(String userName, String password);
}
