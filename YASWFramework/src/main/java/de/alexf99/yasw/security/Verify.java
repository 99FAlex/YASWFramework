package de.alexf99.yasw.security;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Verify {
    public static boolean verifyBCrypt(String originalText, String hash){
        return BCrypt.verifyer().verify(originalText.toCharArray(), hash).verified;
    }
}
