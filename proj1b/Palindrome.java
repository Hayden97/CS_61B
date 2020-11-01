public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    private boolean isPalindrome(Deque<Character> wordDeque) {
        // base case
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }

        Character first = wordDeque.removeFirst();
        Character last = wordDeque.removeLast();

        return (first == last) && isPalindrome(wordDeque);
    }

    /** Returns true if the word is a palindrome according to the character comparison test. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(wordToDeque(word), cc);
    }

    private boolean isPalindrome(Deque<Character> wordDeque, CharacterComparator cc) {
        // base case
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }

        Character first =  wordDeque.removeFirst();
        Character last =  wordDeque.removeLast();

        return (cc.equalChars(first, last)) && isPalindrome(wordDeque, cc);
    }
}
