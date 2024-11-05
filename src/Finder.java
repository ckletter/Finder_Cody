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
    private static final String INVALID = "INVALID KEY";
    public static final int RADIX = 256;
    private HashMap hashMap;
    public static final long LONGER_P = 2305843009213693951L;

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        hashMap = new HashMap();
        String currLine = br.readLine();
        while (currLine != null) {
            String[] split = currLine.split(",", 0);
            String key = split[keyCol];
            String val = split[valCol];
            hashMap.add(key, val);
            currLine = br.readLine();
        }
    }
    public String query(String key){
        return hashMap.get(key);
    }
}