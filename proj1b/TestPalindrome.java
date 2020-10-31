import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        String word_p1 = "a";
        String word_p2 = "racecar";
        String word_p3 = "";
        String word_np4 = "horse";
        String word_np5 = "rancor";
        String word_np6 = "aaaab";

        assertTrue(palindrome.isPalindrome(word_p1));
        assertTrue(palindrome.isPalindrome(word_p2));
        assertTrue(palindrome.isPalindrome(word_p3));

        assertFalse(palindrome.isPalindrome(word_np4));
        assertFalse(palindrome.isPalindrome(word_np5));
        assertFalse(palindrome.isPalindrome(word_np6));
    }

    @Test
    public void TestOffByOne() {
        OffByOne obo = new OffByOne();
        assertTrue(obo.equalChars('a', 'b'));
        assertTrue(obo.equalChars('r', 'q'));

        assertFalse(obo.equalChars('a', 'e'));
        assertFalse(obo.equalChars('z', 'a'));
        assertFalse(obo.equalChars('a', 'a'));
    }

}
