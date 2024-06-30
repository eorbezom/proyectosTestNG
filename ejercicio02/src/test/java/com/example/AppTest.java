package com.example;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.utils.GeneratorPassword;

public class AppTest {
    
    GeneratorPassword generatorPassword;

    @BeforeClass
    public void setUp(){
        generatorPassword = new GeneratorPassword();
    }

    @Test
    public void testPasswordLengthIsTen(){
        //GIVEN
        int expectedLength = 10;

        //WHEN
        String password = generatorPassword.passwordGenerator();

        //THEN
        Assert.assertEquals(password.length(), expectedLength);
    }
    //debe contener al menos dos caracteres especiales  (@!._-#).

    @Test
    public void testPasswordHastAtLeastTwoSpecialCharacters(){
        //GIVEN
        String specialCharacterPool = "@!._-#";

        //WHEN
        String password = generatorPassword.passwordGenerator();

        //THEN
        int specialCharacterCount = 0;
        for (int i = 0; i < password.length(); i++){
            char ch = password.charAt(i);
            if (specialCharacterPool.contains(String.valueOf(ch))) {
                specialCharacterCount++;
            }
        }
        Assert.assertTrue(specialCharacterCount >= 2);
    }
    //debe contener al menos un letra.

    @Test (invocationCount = 100)
    public void testPasswordHastAtLeastOneLetter(){
        //GIVEN
        

        //WHEN
        String password = generatorPassword.passwordGenerator();

        //THEN
        int letterCount = 0;
        for (int i = 0; i < password.length(); i++){            
            if ('a' <= password.charAt(i) && password.charAt(i) <= 'z') {
                letterCount++;
            }
            if ('A' <= password.charAt(i) && password.charAt(i) <= 'Z') {
                letterCount++;
            }
        }
        Assert.assertTrue(letterCount >=1);

    }
    //debe contener al menos un numero.
}
