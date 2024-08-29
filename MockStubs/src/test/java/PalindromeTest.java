import org.junit.Before;
import org.junit.Test;
import stubs.PalindromeStub;

import static org.junit.Assert.assertTrue;

public class PalindromeTest {
    PalindromeStub palindromeStub = new PalindromeStub();

    @Before
    public void setUp() {
        palindromeStub = new PalindromeStub();
    }

    @Test
    public void testPalindrome() {
        assertTrue(palindromeStub.isPalindrome("civic"));
        assertTrue("true", palindromeStub.isPalindrome("noon"));
    }
}
