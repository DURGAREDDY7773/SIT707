package web.service;

public class LoginService {

    public static boolean login(String username, String password, String dob) {

        if (username == null || password == null || dob == null) {
            return false;
        }

        username = username.trim();
        password = password.trim();
        dob = dob.trim();

        if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
            return false;
        }

        String validUsername = "ahsan";
        String validPassword = "ahsan_pass";
        String validDob = "2000-01-01";

        return validUsername.equals(username)
                && validPassword.equals(password)
                && validDob.equals(dob);
    }
}