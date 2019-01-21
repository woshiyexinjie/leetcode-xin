package com.helloxin.leetcode.algorithms;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by nandiexin on 2019/1/21.
 *
 Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber414 {

    public static int thirdMax(int[] nums) {
        Object aa [] = Arrays.stream(nums).boxed().collect(Collectors.toSet()).toArray();
        Arrays.sort(aa);
        if(aa.length < 3){
            return (Integer)(aa[aa.length-1]);
        }else{
            return (Integer)aa[aa.length-3];
        }
    }


    //这里从最大的数据开始
    public static int thirdMax2(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) {
                continue;
            }
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

    // 我看有人使用了PriorityQueue 来写 还是挺好奇的 因为平时不用这个类
    public static int thirdMax3(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }



    public static void main(String[] args) {

        int nums[] ={3,5,6,7,2,45,7,78,3,4325,5436,435,543,34};
        System.out.println(thirdMax3(nums));

        System.out.println(null instanceof Integer);


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : nums){
            pq.add(a);
        }
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());;




    }
}
