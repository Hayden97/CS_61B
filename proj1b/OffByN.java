public class OffByN implements CharacterComparator{
    private static int offN;

    public OffByN(int N) {
        offN = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        return diff == offN;
    }
}
