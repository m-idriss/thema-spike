package com.dime.thema.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(locations = "classpath:webSecurityConfig.xml")
class SecurityConfigTest {

    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    void testAuthentication() {
        assertThat(userDetailsService.loadUserByUsername("dev")).isNotNull();
        assertThat(userDetailsService.loadUserByUsername("user")).isNotNull();
        assertThat(userDetailsService.loadUserByUsername("admin")).isNotNull();
    }

    @Test
    void testAuthorization() {
        // Test authorized access for a user with ROLE_DEV
        // Implement your authorization test here
        assertTrue(true);
    }

    @Test
    void testUnknownUser() {
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("unknown"));
    }
}
