package testng.basic;

import org.testng.annotations.Test;

public class InvocationCountParameter {

    @Test(invocationCount = 100000, invocationTimeOut = 10)
    public void testCheckExample() {
        System.out.println("Test Check Example....");
    }
}
