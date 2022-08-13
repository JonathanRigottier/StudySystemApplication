package com.sda.studysystem.services.implementations;

import com.sda.studysystem.exceptions.AuthorityNotFoundException;
import com.sda.studysystem.models.Authority;
import com.sda.studysystem.repositories.AuthorityRepository;
import com.sda.studysystem.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of Authority Service
 *
 * @author Vinod John
 */
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void createAuthority(Authority authority) {
        authorityRepository.save(authority);
    }

    @Override
    public Authority findAuthorityByName(String name) throws AuthorityNotFoundException {
        Optional<Authority> optionalAuthority = authorityRepository.findByName(name);

        if(optionalAuthority.isEmpty()) {
            throw new AuthorityNotFoundException(name);
        }

        return optionalAuthority.get();
    }

    @Override
    public List<Authority> findAllAuthorities() {
        return authorityRepository.findAll();
    }
}
