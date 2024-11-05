public class HashMap {
    public static final int DEFAULT_TABLE_SIZE = 10937;
    public static final int RADIX = 256;
    private int tableSize;
    private int elements;
    private String[] keys;
    private String[] values;

    public HashMap() {
        this.tableSize = DEFAULT_TABLE_SIZE;
        this.keys = new String[this.tableSize];
        this.values = new String[this.tableSize];
    }

    public int hash(String key) {
        int length = key.length();
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * RADIX + key.charAt(i)) % tableSize;
        }
        return hash;
    }
    public void add(String key, String value) {
        elements = elements + 1;
        double alpha = (double) (elements) / tableSize;
        if (alpha > 0.5) {
            resize();
        }
        int currentIndex = hash(key);
        while (keys[currentIndex] != null) {
            currentIndex = (currentIndex + 1) % tableSize;
        }
        keys[currentIndex] = key;
        values[currentIndex] = value;
    }
    public String get(String key) {
        int currentIndex = hash(key);
        while (true) {
            if (keys[currentIndex] == null) {
                return "INVALID KEY";
            }
            else if (keys[currentIndex].equals(key)) {
                return values[currentIndex];
            }
            currentIndex = (currentIndex + 1) % tableSize;
        }
    }
    public void resize() {
        int length = tableSize;
        tableSize = tableSize * 2;
        String[] newKeys = new String[tableSize];
        String[] newVals = new String[tableSize];
        for (int i = 0; i < length; i++) {
            if (keys[i] == null) {
                continue;
            }
            int currentIndex = hash(keys[i]);
            while (newKeys[currentIndex] != null) {
                currentIndex = (currentIndex + 1) % tableSize;
            }
            newKeys[currentIndex] = keys[i];
            newVals[currentIndex] = values[i];
        }
        this.keys = newKeys;
        this.values = newVals;
    }


}
