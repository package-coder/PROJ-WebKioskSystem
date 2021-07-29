package com.company.helpers;

import java.util.regex.Pattern;

public class PasswordValidator {
    private static final int PASSWORD_LENGTH = 6;
    private static final Pattern PASSWORD_REGEX =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{" + PASSWORD_LENGTH + ",}$",
                    Pattern.CASE_INSENSITIVE);

    public static boolean validate(String password){
        var  matcher = PASSWORD_REGEX.matcher(password);
        return matcher.matches();
    }
}
