package testng.basic;

import org.testng.annotations.*;

public class AnnotationsExample {

    @BeforeMethod
    public void setup(){
        System.out.println("Before Method");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @Test
    public void case1(){
        System.out.println("Case 1");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }
}
