package com.helloxin.leetcode.algorithms;

/**
 *  create by one leaf on 2017/12/12
 */
public class LongestCommonPrefix {

    /**
     * 根据String的indexOf和substring 来找他们的公众部分
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //没有子集会返回 -1，0是第一个位置 startWith
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                //如果为空 那么没有公众前缀
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 这个方法写的就比较直观了 取第一次字符，去遍历其他的字符串  看是否符合
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //遍历 第一个字符串
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            //开始比对
            for (int j = 1; j < strs.length; j ++) {
                //如果到了某个字符串的长度 或者已经不匹配
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * Divide and conquer  这是看solution 里面 前辈们写的第三种方法  想不到 而且我也不习惯使用递归的编程
     * 或许是因为递归 没有那么直观看到怎么执行的
     * 用于这个道题目到没看出什么优势 但是熟悉这个概念还不错
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix3(strs, 0 , strs.length - 1);
    }

    private static String longestCommonPrefix3(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            //递归调用
            String lcpLeft =   longestCommonPrefix3(strs, l , mid);
            String lcpRight =  longestCommonPrefix3(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    static String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) ) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    /**
     * Binary search  在什么情况下  需要考虑这么写呢 这是solution中提供的第四种方法
     * @param strs
     * @return
     */
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    //判断是否有共同前缀
    private static boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args) {
        System.out.println(longestCommonPrefix3(new String[]{"YE","YE"}));
    }
}


