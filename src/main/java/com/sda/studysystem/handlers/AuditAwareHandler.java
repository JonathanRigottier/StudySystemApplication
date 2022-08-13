package com.sda.studysystem.handlers;

import com.sda.studysystem.utils.Constants;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * Custon handler to implement AuditorAware
 *
 * @author Vinod John
 */
public class AuditAwareHandler implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            } else {
            username = principal.toString();
        }

        return username.isEmpty() ? Optional.of(Constants.Audit.DEFAULT_AUDITOR) : Optional.of(username);
    }
}
