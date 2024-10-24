package org.test;

import org.example.Arithmetic;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static junit.framework.TestCase.assertEquals;

public class ArithmeticTest {
    Arithmetic art = new Arithmetic();

    @Before
    public void first() {
        System.out.println("Before test case");
    }
    @After
    public void last() {
        System.out.println("After test case");
    }
    @BeforeClass
    public static void firstOfAll() {
        System.out.println("Before class");
    }
    @AfterClass
    public static void lastOfAll() {
        System.out.println("After class");
    }

    @Test(timeout = 20)
    public void testGreatestMethod() {
        assertEquals(4, art.findGreatest(3,4));
    }

    @Test
    public void testUpper() throws Exception{
        assertEquals("LIAR", art.toUpper("liar"));
    }

    @Test
    @Ignore
    public void testLower() {
        assertEquals("judge", art.toLower("JUdGe"));
    }

}
