import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    // Uncomment this class once you've created your CharacterComparator interface and OffByOne class. *
    @Test
    public void TestPalindrome() {
        Palindrome palindrome = new Palindrome();
        String word_p1 = "a";
        String word_p2 = "flake";
        String word_p3 = "";
        String word_np4 = "racecar";
        String word_np5 = "abc";

        assertTrue(palindrome.isPalindrome(word_p1, offByOne));
        assertTrue(palindrome.isPalindrome(word_p2, offByOne));
        assertTrue(palindrome.isPalindrome(word_p3, offByOne));

        assertFalse(palindrome.isPalindrome(word_np4, offByOne));
        assertFalse(palindrome.isPalindrome(word_np5, offByOne));
    }
}
