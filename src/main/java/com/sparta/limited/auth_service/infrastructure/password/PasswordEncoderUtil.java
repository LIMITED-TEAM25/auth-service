package com.sparta.limited.auth_service.infrastructure.password;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoderUtil {

    public static String encode(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static void isMatched(String rawPassword, String password) {
        if (!BCrypt.checkpw(rawPassword, password)) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다");
        }
    }

}
