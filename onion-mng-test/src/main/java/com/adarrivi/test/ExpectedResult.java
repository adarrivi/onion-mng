package com.adarrivi.test;

import static org.junit.Assert.assertEquals;

public class ExpectedResult {

    private Object result;

    public void setResult(Object result) {
        this.result = result;
    }

    public void thenShouldBeEqualsTo(Object expectedResult) {
        assertEquals(expectedResult, result);
    }

}
