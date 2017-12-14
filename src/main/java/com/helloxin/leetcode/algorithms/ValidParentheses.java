package com.helloxin.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * create by nandiexin on 2017/12/13
 **/
public class ValidParentheses {

    /**
     *  Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
     *  determine if the input string is valid.
        The brackets must close in the correct order,
        "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */

    public static boolean isValid(String s) {


        boolean isValid = false;
        Stack<Character> stack = new Stack<>();
        if(null != s && !s.isEmpty()){

            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                //判断是否存在其他字符
                if(a != '(' && a == '[' && a == '{' && a != ')' && a == ']' && a == '}'){
                    break;
                }
                if(stack.isEmpty()){
                    stack.push(a);
                    continue;
                }
                if(a == '(' || a == '[' || a == '{'){
                    stack.push(a);
                }else if(a == ')'){
                    char b = stack.peek();
                    if (b != '('){
                        break;
                    }
                    stack.pop();
                }
                else if(a == ']'){
                    char b = stack.peek();
                    if (b != '['){
                        break;
                    }
                    stack.pop();
                }else if(a == '}'){
                    char b = stack.peek();
                    if (b != '{'){
                        break;
                    }
                    stack.pop();
                }
            }
        }
        if(stack.size() ==0 ){
            isValid = true;
        }
        return isValid;
    }

    /**
     * 下面看的其他人写的   但是 这里没做 其他字符的控制
     */
    public static boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            switch(c){
                case '(': case '[': case '{':
                    stk.push(c);
                    break;
                case ')': case ']': case '}':
                    if(stk.isEmpty() || c != map.get(stk.pop())){
                        return false;
                    }
            }
        }
        return stk.isEmpty();
    }
    //好吧 ，其实我是不愿意这么写的
    public static boolean isValid3(String s) {

        int len = s.length();
        if(len==0) return true;
        if(len%2 == 1) return false;
        for(int i = 1; i < len; i++)
            if(s.charAt(i-1) == '{' && s.charAt(i)=='}')
            {
                String ss = s.substring(0, i-1) + s.substring(i+1);
                return isValid(ss);
            }
            else if(s.charAt(i-1) == '[' && s.charAt(i)==']')
            {
                String ss = s.substring(0, i-1) + s.substring(i+1);
                return isValid(ss);
            }
            else if(s.charAt(i-1) == '(' && s.charAt(i)==')')
            {
                String ss = s.substring(0, i-1) + s.substring(i+1);
                return isValid(ss);
            }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isValid("{"));
        System.out.println(isValid("([{}])"));
    }
}
