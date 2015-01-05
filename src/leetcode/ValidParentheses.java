package leetcode;

import java.util.Stack;
/**
 * Created by longwei on 1/4/15.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int length = s.length();
        for(int i = 0; i < length; i++){
            char cur = s.charAt(i);
            if(isOpen(cur)){
                stack.push(cur);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(!isMatchingclose(top, cur)){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOpen(char input){
        return input == '(' || input == '{' || input == '[';

    }

    public static boolean isclose(char input){
        return input == ')' || input == '}' || input == ']';
    }

    public static boolean isMatchingclose(char a, char b){
        if(a == '{'){
            return (b == '}');
        } else if ( a== '('){
            return (b == ')');
        } else if ( a == '['){
            return (b == ']');
        } else {
            return false;
        }

    }
}
