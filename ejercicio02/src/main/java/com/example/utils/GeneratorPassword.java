package com.example.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.Random;

public class GeneratorPassword {
    
    private static final String specialCharacterPool = "@!._-#";
    private int specialCharacterCount;
    private int passwordLength;

    public GeneratorPassword() {
        specialCharacterCount = 2; // contador de caracteres especiales
        passwordLength = 10; // longitud de password
    }

    /*
     * Método generador de contraseña
     */

    public String passwordGenerator() {
        try {
            String baseString = getBaseString();
            String password = setSpecialCharacters(baseString);
            return password;
        } catch (Exception e) {
            e.printStackTrace();
            return ""; // Manejo básico de excepciones, podrías mejorar el manejo de errores según tu aplicación
        }
    }

    private String getBaseString() throws Exception {
        String timestampString = getTimestampAsString();
        String md5HashString = getMD5Hash(timestampString);
        return md5HashString.substring(0, passwordLength - specialCharacterCount);
    }

    private String getMD5Hash(String seed) throws Exception {
        MessageDigest mD = MessageDigest.getInstance("MD5");
        mD.reset();
        mD.update(seed.getBytes());
        byte[] digest = mD.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashString = bigInt.toString(16);
        return hashString;
    }

    private String getTimestampAsString() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
    }

    private String setSpecialCharacters(String baseString) {
        for (int i = 0; i < specialCharacterCount; i++) {
            Random r = new Random();
            char spChar = getRandomSpecialCharacter();
            int newPosition = r.nextInt(baseString.length());
            baseString = baseString.substring(0, newPosition) + spChar + baseString.substring(newPosition);
        }
        return baseString;
    }

    private char getRandomSpecialCharacter() {
        Random r = new Random();
        int newPosition = r.nextInt(specialCharacterPool.length());
        return specialCharacterPool.charAt(newPosition);
    }
}
