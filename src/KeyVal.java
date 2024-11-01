public class KeyVal {
    private final long longerKeyHash;
    private final String val;
    public KeyVal(long longerKeyHash, String val) {
        this.longerKeyHash = longerKeyHash;
        this.val = val;
    }
    public long getLongerKeyHash() {
        return longerKeyHash;
    }

    public String getVal() {
        return val;
    }
}
