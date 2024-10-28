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

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        ArrayList[] table = new ArrayList[P_VALUE];
        while (br.readLine() != null) {
            String[] line = br.readLine().split("[,]", 0);
            String key = line[keyCol];
            String val = line[valCol];
            long keyHash = strHash(key);
        }
    }
    public long strHash(String str) {
        int length = str.length();
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * RADIX + str.charAt(i)) % P_VALUE;
        }
        return hash;
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return INVALID;
    }
}