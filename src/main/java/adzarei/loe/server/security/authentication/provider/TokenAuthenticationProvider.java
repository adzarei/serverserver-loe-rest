package adzarei.loe.server.security.authentication.provider;

import adzarei.loe.server.security.authentication.services.UUIDAuthenticationService;
import adzarei.loe.server.security.authentication.services.UserAuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Optional;

//Class responsible of finding the user by it's authentication TOKEN.
@Component
@AllArgsConstructor
public final class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @NotNull UserAuthenticationService userAuthenticationService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {}

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        final Object token = authentication.getCredentials();
        return Optional
                .ofNullable(token)
                .map(String::valueOf)
                .flatMap(userAuthenticationService::findLoginUserByToken)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with token="+token));
    }
}