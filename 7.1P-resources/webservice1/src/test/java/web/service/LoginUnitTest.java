package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginUnitTest {

    @Test
    public void testValidLogin() {
        assertTrue(LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(LoginService.login("wronguser", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(LoginService.login("ahsan", "wrongpass", "2000-01-01"));
    }

    @Test
    public void testInvalidDob() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "1999-01-01"));
    }

    @Test
    public void testNullUsername() {
        assertFalse(LoginService.login(null, "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void testNullPassword() {
        assertFalse(LoginService.login("ahsan", null, "2000-01-01"));
    }

    @Test
    public void testNullDob() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", null));
    }

    @Test
    public void testEmptyUsername() {
        assertFalse(LoginService.login("", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void testEmptyPassword() {
        assertFalse(LoginService.login("ahsan", "", "2000-01-01"));
    }

    @Test
    public void testEmptyDob() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", ""));
    }

    @Test
    public void testUsernameWithSpaces() {
        assertTrue(LoginService.login("  ahsan  ", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void testPasswordWithSpaces() {
        assertTrue(LoginService.login("ahsan", "  ahsan_pass  ", "2000-01-01"));
    }

    @Test
    public void testDobWithSpaces() {
        assertTrue(LoginService.login("ahsan", "ahsan_pass", " 2000-01-01 "));
    }
}