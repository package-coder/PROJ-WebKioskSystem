package com.company.interfaces;

import java.security.SecureRandom;

public abstract class Hashable {

    private final static int DEF_SALT_LENGTH = 16;

    private final static SecureRandom random = new SecureRandom();

    public byte[] generateSalt(){
        return generateSalt(DEF_SALT_LENGTH);
    }

    public byte[] generateSalt(final int saltLength){
        byte[] salt = new byte[saltLength];
        random.nextBytes(salt);
        return salt;
    }

    public abstract byte[] hash(char[] chars);
    public abstract byte[] hash(char[] chars, byte[] salt);
}
