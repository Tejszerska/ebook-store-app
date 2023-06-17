package pl.ebookstore.app;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Component
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests()
//                .antMatchers("/ebooks", "/details/**", "/cart/**").permitAll()
                .antMatchers("/admin/**").authenticated()
                .antMatchers("/h2").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/orders").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .logout()
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().disable()
                .cors();


        httpSecurity.logout(logout -> logout.logoutSuccessUrl("/ebooks"));

        return httpSecurity.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(" https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css.", "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js.")); // Dodaj dozwolone adresy URL
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE")); // Dodaj dozwolone metody HTTP
//        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type")); // Dodaj dozwolone nagłówki
        configuration.setAllowCredentials(true); // Włącz przesyłanie danych uwierzytelnienia
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
