package de.alexf99.yasw.security;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Encrypt {

    public static String generateHashValueBCrypt(int length, String text){
        return BCrypt.withDefaults().hashToString(length, text.toCharArray());
    }
}
