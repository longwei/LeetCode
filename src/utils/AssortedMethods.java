package utils;

/**
 * Created by longwei on 1/3/15.
 */
public class AssortedMethods {
    public static String charArrayToString(char[] array) {
        StringBuilder buffer = new StringBuilder(array.length);
        for (char c : array) {
            if (c == 0) {
                break;
            }
            buffer.append(c);
        }
        return buffer.toString();
    }
}
