package com.sparta.limited.auth_service.infrastructure.password;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoderUtil {

    public static String encode(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
