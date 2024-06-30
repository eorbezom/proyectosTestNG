package com.example;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

    @BeforeGroups("usuario")
    public void beforeGroups(){
        System.out.println("AppTest.beforeGroups(eres usuario del grupo)");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("AppTest.beforeMethod()");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("AppTest.beforeClass()");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("AppTest.beforeSuite()");
    }
        

    @BeforeTest
    public void beforeTest(){
        System.out.println("AppTest.beforeTest()");
    }


    @Test 
    public void testMethod(){
        System.out.println("AppTest.ffeefef(ERMENIGILDO)");
        Assert.assertEquals(1, 1);
    }
    @Test (groups={"usuario"})
    public void testNameUser(){
        System.out.println("AppTest.testNameUser(ERMENIGILDO Orbezo)");
        
    }
    @Test (groups={"roles"})
    public void testNameRoles(){
        System.out.println("AppTest.testNameRoles(tu cargo  o lo que haces)");
        
    }


    @AfterSuite
    public void afterSuite (){
        System.out.println("AppTest.afterSuite()");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AppTest.afterMethod()");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AppTest.afterClass()");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AppTest.afterTest()");
    }
    @AfterGroups("roles")
    public void afterGroups(){
        System.out.println("AppTest.afterGroups(es tu rol)");
    }

    
}