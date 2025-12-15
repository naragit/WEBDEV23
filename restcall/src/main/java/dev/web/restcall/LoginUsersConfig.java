package dev.web.restcall;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class LoginUsersConfig
{

    @Bean
    public PasswordEncoder getPwdEncoder()
    {
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager defaultUsers()
    {
        UserDetails u1 = User.builder()
                .username("nara")
                .password(getPwdEncoder().encode("nara123"))
                .roles("ADMIN")
                .build();

        UserDetails u2 = User.builder()
                .username("admin")
                .password(getPwdEncoder().encode("admin123"))
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(u1,u2);
    }

    @Bean
    public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(req ->
                req.requestMatchers("/greet/**").permitAll()
                        .requestMatchers("/list/**").hasRole("MANAGER")
                        .requestMatchers("/").hasAnyRole("ADMIN","MANAGER")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

}
