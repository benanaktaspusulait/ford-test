package com.ford.grocery.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

public class TestGrocery {

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream console = System.out;

    @Before
    public void setup() {
    }

    @Test
    public void test3Soup2Bread() throws Exception {

        runTest("soup soup soup bread bread 0");
        Assert.assertEquals("Expected total cost = 3.15;", byteArrayOutputStream.toString());
    }

    @Test
    public void test4Soup2Bread() throws Exception {

        runTest("soup soup soup soup bread bread 0");
        Assert.assertEquals("Expected total cost = 3.40;", byteArrayOutputStream.toString());
    }

    @Test
    public void test6Apple1Milk() throws Exception {

        runTest("apples apples apples apples apples apples milk 0");
        Assert.assertEquals("Expected total cost = 1.90;", byteArrayOutputStream.toString());
    }


    @Test
    public void test6Apple1Milk5DaysLater() throws Exception {

        runTest("apples apples apples apples apples apples milk 5");
        Assert.assertEquals("Expected total cost = 1.84;", byteArrayOutputStream.toString());
    }

    @Test
    public void test3Apple2Soup1Bread5DaysLater() throws Exception {

        runTest("apples apples apples soup soup bread 5");
        Assert.assertEquals("Expected total cost = 1.97;", byteArrayOutputStream.toString());
    }

    private void runTest(final String data) throws Exception {

        final InputStream input = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        final InputStream old = System.in;

        try {
            System.setOut(new PrintStream(byteArrayOutputStream));
            System.setIn(input);

            final Class<?> cls = Class.forName("com.ford.grocery.GroceryApplication");
            final Method meth = cls.getDeclaredMethod("main", String[].class);
            final String[] params = new String[]{};
            meth.invoke(null, (Object) params);

        } finally {
            System.setOut(console);
            System.setIn(old);
        }
    }
}