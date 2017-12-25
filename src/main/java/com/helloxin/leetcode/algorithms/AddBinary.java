package com.helloxin.leetcode.algorithms;

/*
Given two binary strings, return their sum (also a binary string).

        For example,
        a = "11"
        b = "1"
        Return "100".
*/

/**
 * create by nandiexin on 2017/12/22
 **/
public class AddBinary {

    //这边写的比较长 就不优化了
    public static String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        int  n = a.length()>b.length()?a.length():b.length();
        boolean carry = false;
        StringBuilder a1 = new StringBuilder(a);
        StringBuilder b1 = new StringBuilder(b);
        a1=a1.reverse();
        b1= b1.reverse();
        StringBuilder newbinary = new StringBuilder();
        for(int i = 0;i < n ; i++){
            int aint = i > a.length() - 1? 0 : Integer.parseInt(a1.charAt(i)+"");
            int bint =i > b.length() - 1? 0 : Integer.parseInt(b1.charAt(i)+"");
            if( carry == false){
                if(aint+bint < 2 ){
                    newbinary.append(aint + bint);
                }else{
                    newbinary.append(0);
                    carry = true;
                }
            }else if(carry == true){
                if(aint+bint+1 < 2 ){
                    newbinary.append(aint + bint+1);
                    carry= false;
                }else if(aint+bint+1 == 3){
                    newbinary.append(1);
                    carry= true;
                }else if(aint+bint+1 == 2){
                    newbinary.append(0);
                    carry= true;
                }

            }
        }
        if(carry == true){
            newbinary.append(1);
        }
        return newbinary.reverse().toString();
    }

    /**
     * 网上看的这个人是这么写的  服
     * @param a
     * @param b
     * @return
     */
    public static String addBinary2(String a,String b){
        String result = "";
        int c = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while(i >= 0 || j >=0 ||c ==1)
        {
            c += i >= 0 ? a.charAt(i--) - '0':0;
            c += j >= 0 ? b.charAt(j--) - '0':0;
            result = (char)( c%2 + '0') + result;
            c /= 2;

        }

        return result;
    }

    /**
     * 这是网上看到另一个写的 和上面的第二种类似
     */
    public static  String addBinary3(String a, String b) {
        if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        StringBuilder stb = new StringBuilder();

        int i = aArray.length - 1;
        int j = bArray.length - 1;
        int aByte;
        int bByte;
        int carry = 0;
        int result;

        while(i > -1 || j > -1 || carry == 1) {
            aByte = (i > -1) ? Character.getNumericValue(aArray[i--]) : 0;
            bByte = (j > -1) ? Character.getNumericValue(bArray[j--]) : 0;
            result = aByte ^ bByte ^ carry;
            carry = ((aByte + bByte + carry) >= 2) ? 1 : 0;
            stb.append(result);
        }
        return stb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary2("1","1010"));
    }
}
