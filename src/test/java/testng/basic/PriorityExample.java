package testng.basic;

import org.testng.annotations.Test;

public class PriorityExample {

    @Test(priority = 1)
    public void testZ() {
        System.out.println("Test Z");
    }

    @Test(priority = -2)
    public void testM() {
        System.out.println("Test M");
    }

    @Test(priority = 'C')
    public void testA() {
        System.out.println("Test A");
    }

    @Test
    public void testY() {
        System.out.println("Test Y");
    }

    @Test(priority = 5)
    public void testT() {
        
    }
}

