import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testPalindrome() {
        Palindrome palindrome = new Palindrome();
        String wordP1 = "a";
        String wordP2 = "flake";
        String wordP3 = "";
        String wordNP4 = "racecar";
        String wordNP5 = "abc";

        assertTrue(palindrome.isPalindrome(wordP1, offByOne));
        assertTrue(palindrome.isPalindrome(wordP2, offByOne));
        assertTrue(palindrome.isPalindrome(wordP3, offByOne));

        assertFalse(palindrome.isPalindrome(wordNP4, offByOne));
        assertFalse(palindrome.isPalindrome(wordNP5, offByOne));
    }
}
