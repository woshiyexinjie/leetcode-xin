package com.helloxin.leetcode.algorithms;

import java.util.Objects;

/**
 * Created by yebanxian on 2019/12/16.
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * <p>
 * A defanged IP address replaces every period "." with "[.]".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 * <p>
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The given address is a valid IPv4 address.
 */
public class DefangingAnIPAddress1108 {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
    public String defangIPaddr2(String address) {
        return String.join("[.]", address.split("\\."));
    }

    public static void main(String[] args) {
        Boolean test = null;
        System.out.println(Objects.equals(test,true));
    }
}
