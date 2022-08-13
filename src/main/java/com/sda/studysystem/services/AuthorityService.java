package com.sda.studysystem.services;

import com.sda.studysystem.exceptions.AuthorityNotFoundException;
import com.sda.studysystem.models.Authority;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle authority related operations
 *
 * @author Vinod John
 */
public interface AuthorityService {

    /**
     *  To create a new authority
     *
     * @param authority Authority
     */
    void createAuthority(Authority authority);

    /**
     * To find authority by name
     *
     * @param name Authority name
     * @return optional of Authority
     */
    Authority findAuthorityByName(String name) throws AuthorityNotFoundException;

    /**
     * To find all authorities
     *
     * @return List of authorities
     */
    List<Authority> findAllAuthorities();
}
