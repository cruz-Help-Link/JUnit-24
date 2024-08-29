package stubs;

import entity.Palindrome;

import java.util.HashMap;
import java.util.Map;

public class PalindromeStub extends Palindrome {
    private Map<String, Boolean> pali = new HashMap<>();

    public PalindromeStub() {
        // Define some predefined results for specific inputs
        pali.put("madam", true);
        pali.put("racecar", true);
        pali.put("hello", false);
        pali.put("noon", true);
        pali.put("civic", true);

    }

    @Override
    public boolean isPalindrome(String inputString) {
        return pali.containsKey(inputString) ? pali.get(inputString) : false;
    }

}
