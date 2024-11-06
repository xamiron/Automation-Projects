package forms;
import java.util.Arrays;

public class StringIsomorphismChecker {
    public static boolean areIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charMap1 = new int[256];
        int[] charMap2 = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (charMap1[c1] != charMap2[c2]) {
                return false;
            }

            charMap1[c1] = i + 1;
            charMap2[c2] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "egg";
        String s2 = "add";

        String s3= "magno";
        String s4= "tanga";

        if (areIsomorphic(s3, s4)) {
            System.out.println("The strings are isomorphic.");
        } else {
            System.out.println("The strings are not isomorphic.");
        }

        if (areIsomorphic(s1, s2)) {
            System.out.println("The strings are isomorphic.");
        } else {
            System.out.println("The strings are not isomorphic.");
        }
    }
}