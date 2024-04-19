package com.fottecmis.Authenticate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthControllerTest {
    private AuthController authController;

    @BeforeEach
    void setUp() {
        authController = new AuthController();
    }

    @Test
    void testAuthenticateUserWithCorrectCredentials() {
        assertTrue(authController.authenticateUser("ishan123@gmail.com", "4000"));
    }

    @Test
    void testAuthenticateUserWithIncorrectCredentials() {
        assertFalse(authController.authenticateUser("incorrectEmail@example.com", "incorrectPassword"));
    }


}