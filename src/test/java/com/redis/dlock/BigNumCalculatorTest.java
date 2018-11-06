package com.redis.dlock;

import org.junit.Assert;
import org.junit.Test;

public class BigNumCalculatorTest {

    @Test
    public void test() {
        String result = BigNumCalculator.plus("999999999999990987654321", "987654321");
        Assert.assertEquals("999999999999991975308642", result);
    }
}