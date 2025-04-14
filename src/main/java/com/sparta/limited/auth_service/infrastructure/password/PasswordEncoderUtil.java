package com.sparta.limited.auth_service.infrastructure.password;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoderUtil {

    public static String encode(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean isMatched(String rawPassword, String password) {
        return BCrypt.checkpw(rawPassword, password);
    }
}
