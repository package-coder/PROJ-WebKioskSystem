package com.company.helpers;

import com.company.interfaces.Hashable;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class PasswordHashable extends Hashable {

    private final static String ALGORITHM = "PBKDF2WithHmacSHA1";
    private final static int ITERATION_COUNT = 65536;
    private final static int KEY_LENGTH = 128;

    @Override
    public byte[] hash(char[] chars) {
        var salt = generateSalt();
        return encode(chars, salt);
    }

    @Override
    public byte[] hash(char[] chars, byte[] salt) {
        return encode(chars, salt);
    }

    public Base64.Encoder getEncoder(){
        return Base64.getEncoder();
    }

    private byte[] encode(char[] chars, byte[] salt){
        try{
            var keySpec = new PBEKeySpec(chars, salt, ITERATION_COUNT, KEY_LENGTH);
            var instance = SecretKeyFactory.getInstance(ALGORITHM);
            return instance.generateSecret(keySpec).getEncoded();
        }catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }
}
