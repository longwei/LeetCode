package leetcode.String;

/**
 * Created by longwei on 7/1/15.
 * Validate if a given string is numeric.
 * 0 int
 * 0.1 double
 * 2e10 //this should be valid number too
 * .1 is true...
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null) {return false;}
        if(s.isEmpty()) { return false;}
        int N = s.length();
        int i = 0;
//        boolean hasdigit= false;
//        boolean point = false;
//        boolean hasE = false;
        boolean isNumeric = false;
        //remove while space first
        while(i < N && s.charAt(i) == ' '){
            i++;
        }
        if( i == N) return false;
        if( s.charAt(i) == '+' || s.charAt(i) == '-'){i++;}
        //now comes the real numbers
        while(i < N && Character.isDigit(s.charAt(i))){
            isNumeric = true;
            i++;
        }
        if( i < N && s.charAt(i) == '.'){
            i++;
            while( i< N && Character.isDigit(s.charAt(i))){
                i++;
                isNumeric = true;
            }
        }
        //it must have either 1 or 1.1 or .1 for a base
        if(!isNumeric) return false;

        if( i < N && s.charAt(i) == 'e'){
            i++;
            isNumeric = false;
            if( i < N && (s.charAt(i) == '+' || s.charAt(i) == '-')){
                i++;
            }
            while( i < N && Character.isDigit(s.charAt(i))){
                isNumeric = true;
                i++;
            }
        }

        //rest of the space
        while(i < N && s.charAt(i) == ' '){
            i++;
        }
        return isNumeric && i == N;
    }


    public static void main(String[] args) {
        ValidNumber test = new ValidNumber();
        System.out.println(test.isNumber(null));
        System.out.println(test.isNumber("123."));
        System.out.println(test.isNumber(""));
        System.out.println(test.isNumber(" "));
        System.out.println(test.isNumber("  123"));
        System.out.println(test.isNumber("+-123"));
        System.out.println(test.isNumber("-123"));
        System.out.println(test.isNumber("0.1"));
        System.out.println(test.isNumber("0.11e22"));
        System.out.println(test.isNumber("e"));
        System.out.println(test.isNumber("1 "));
        System.out.println(test.isNumber(" 005047e+6"));
        System.out.println(test.isNumber(" 0e"));
        System.out.println(test.isNumber("e200"));
    }
}
