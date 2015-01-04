package cc150.ch1;

import utils.AssortedMethods;
/**
 * Created by longwei on 1/3/15.
 * 1.4 write a method to replace all space in a string with %20, IN-SPACE
 */
public class EcapeSpace {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "abc d e f ";
        char[] arr = new char[str.length() + 4 * 2 + 1];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        replaceSpace(arr, str.length());
        System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
    }

    //c style signature, assume str have enough space for appending %20
    public static void replaceSpace(char[] str, int length){
        //determine what's the size of the new string
        int spaceCount = 0;
        for(int i=0; i < length; ++i){
            if(str[i] == ' ') {spaceCount++;}
        }
        int newLength = length + spaceCount * 2;
        System.out.println(newLength);
        str[newLength] = '\0';
        //have to backward because in-place
        for(int i = length - 1; i >= 0; --i){
            if(str[i] == ' '){
                str[newLength -1] = '0';
                str[newLength -2] = '2';
                str[newLength -3] = '%';
                newLength = newLength - 3;
            } else{
                str[newLength -1 ] = str[i];
                newLength--;
            }
        }

        for( int i = 0; i < newLength; i++){

        }

    }
}
