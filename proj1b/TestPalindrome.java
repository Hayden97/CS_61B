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
        String wordP1 = "a";
        String wordP2 = "racecar";
        String wordP3 = "";
        String wordNp4 = "horse";
        String wordNp5 = "rancor";
        String wordNp6 = "aaaab";

        assertTrue(palindrome.isPalindrome(wordP1));
        assertTrue(palindrome.isPalindrome(wordP2));
        assertTrue(palindrome.isPalindrome(wordP3));

        assertFalse(palindrome.isPalindrome(wordNp4));
        assertFalse(palindrome.isPalindrome(wordNp5));
        assertFalse(palindrome.isPalindrome(wordNp6));
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
