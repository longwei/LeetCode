package cc150.ch1;

/**
 * Created by longwei on 1/3/15.
 * 1.5 string compression aabcccccaa => a2b1c5a2,
 * if the result string.length is greater than original string, return original
 * the trick here is to use the StringBuffer to append
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compressBetter("abbbbbbbbbbbbbbbbbbca"));
    }

    public static String compressBetter(String str) {
        System.out.println(countCompression(str));
        System.out.println(str.length());
        if(countCompression(str) > str.length()) {
            return str;
        }
        StringBuffer mystr = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            } else {
                mystr.append(last).append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        mystr.append(last).append(count);
        return mystr.toString();
    }





    public static int countCompression(String str){
        if(str == null || str.length() ==0) return 0;
        int size = 0;
        int count = 1;
        char last = str.charAt(0);
        for(int i= 1; i < str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            } else {
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }
}
