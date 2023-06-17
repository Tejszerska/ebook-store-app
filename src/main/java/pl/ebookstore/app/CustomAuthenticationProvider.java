package pl.ebookstore.app;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.ebookstore.app.entities.Customer;
import pl.ebookstore.app.model.enums.Role;
import pl.ebookstore.app.repository.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        Customer customerByEmail = customerRepository.findCustomerByEmail(email);
        if (customerByEmail == null){
            throw new IllegalArgumentException("User not found or user is disabled");
        }

       if (passwordEncoder.matches(password, customerByEmail.getPassword())) {

           String authority = customerByEmail.getRole().toString();

//           userByUsername.setLastLoginDate(LocalDateTime.now());
//           customerRepository.save(userByUsername);

           List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(authority));
           return new UsernamePasswordAuthenticationToken(email, password, authorities);
       } else {
           throw new IllegalArgumentException("Password mismatch");
       }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
