import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 **/

public class Finder {
    public static final int P_VALUE =  10937;
    private static final String INVALID = "INVALID KEY";
    public static final int RADIX = 256;
    public static final long LONGER_P = 2305843009213693951L;
    private ArrayList<KeyVal>[] table;

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        table = new ArrayList[P_VALUE];
        String currLine = br.readLine();
        while (currLine != null) {
            String[] split = currLine.split(",", 0);
            String key = split[keyCol];
            String val = split[valCol];
            int keyHash = strHash(key);
            ArrayList<KeyVal> keyVals = table[keyHash];
            if (keyVals == null) {
                table[keyHash] = new ArrayList<>();
                keyVals = table[keyHash];
            }
            keyVals.add(new KeyVal(strLongerHash(key), val));
            currLine = br.readLine();
        }
    }
    public int strHash(String str) {
        int length = str.length();
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * RADIX + str.charAt(i)) % P_VALUE;
        }
        return hash;
    }
    public long strLongerHash(String str) {
        int length = str.length();
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * RADIX + str.charAt(i)) % LONGER_P;
        }
        return hash;
    }
    public String query(String key){
        int keyHash = strHash(key);
        ArrayList<KeyVal> keyVals = table[keyHash];
        int length = keyVals.size();
        if (length == 1) {
            return keyVals.get(0).getVal();
        }
        for (KeyVal current : keyVals) {
            long longerIndexHash = current.getLongerKeyHash();
            long longerKeyHash = strLongerHash(key);
            if (longerKeyHash == longerIndexHash) {
                return current.getVal();
            }
        }
        return INVALID;
    }
}