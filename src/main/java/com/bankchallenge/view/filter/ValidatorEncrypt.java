package com.bankchallenge.view.filter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

@Getter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class ValidatorEncrypt {

    public static boolean checkPass(final String password, final String hashPassword) {
        return BCrypt.checkpw(password,
                hashPassword);
    }

    public static String hashPassword(final String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
