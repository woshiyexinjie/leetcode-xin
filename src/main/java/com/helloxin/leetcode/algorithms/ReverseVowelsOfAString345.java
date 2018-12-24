package com.helloxin.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nandiexin on 2018/12/24.
 *
 Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:

 Input: "hello"
 Output: "holle"
 Example 2:

 Input: "leetcode"
 Output: "leotcede"
 Note:
 The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString345 {

    public String reverseVowels(String s) {
        char[] list=s.toCharArray();


        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for (int i=0, j=list.length-1; i<j; ) {
            if (!set.contains(list[i])) {
                i++;
                continue;
            }
            if (!set.contains(list[j])) {
                j--;
                continue;
            }
            char temp=list[i];
            list[i]=list[j];
            list[j]=temp;
            i++;
            j--;
        }
        return String.valueOf(list);
    }

    public String reverseVowels2(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++)
        {
            if ("AEIOUaeiou".indexOf(s.charAt(i)) != -1)
            {
                while (j >= 0 && "AEIOUaeiou".indexOf(s.charAt(j)) == -1)
                {
                    j--;
                }
                sb.append(s.charAt(j));
                j--;
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
