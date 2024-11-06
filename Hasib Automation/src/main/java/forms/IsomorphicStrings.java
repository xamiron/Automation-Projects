package forms;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] mappingS = new int[256];
        int[] mappingT = new int[256];

        // Initialize both arrays with 0, which indicates no mapping yet
        for (int i = 0; i < 256; i++) {
            mappingS[i] = 0;
            mappingT[i] = 0;
        }

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if there is no mapping for both charS and charT yet
            if (mappingS[charS] == 0 && mappingT[charT] == 0) {
                // If both characters have not been mapped yet, create a new mapping
                mappingS[charS] = charT; // Map charS in s to charT in t
                mappingT[charT] = charS; // Map charT in t to charS in s
            } else {
                // If mapping exists, check if it's consistent (the current mapping should match the previous one)
                if (mappingS[charS] != charT || mappingT[charT] != charS) {
                    return false; // Return false if the mappings don't match
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        // Test if 'paper' and 'title' are isomorphic
        System.out.println(isIsomorphic(s, t));  // Output: true

        String s2 = "foo";
        String t2 = "bar";

        // Test if 'foo' and 'bar' are isomorphic
        System.out.println(isIsomorphic(s2, t2));  // Output: false
    }
}
