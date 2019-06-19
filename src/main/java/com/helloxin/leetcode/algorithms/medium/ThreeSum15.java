package com.helloxin.leetcode.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nandiexin on 2019/5/21.
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {


        //我想暴力破解 总是可以的
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            for (int j = i + 1; j < nums.length - 1; j++) {

                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {

                        int sum[] = {nums[i], nums[j], nums[k]};
                        Arrays.sort(sum);
                        StringBuilder builder = new StringBuilder();
                        builder.append(sum[0]).append(sum[1]).append(sum[2]);
                        if (list2.contains(builder.toString())) {
                            continue;
                        }
                        list2.add(builder.toString());
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }

        }
        //还要去重
        return list;

    }

    public List<List<Integer>> threeSum3(int[] num) {
        //排序
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            //这是为了去重复的吧
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        //去重
                        while (lo < hi && num[lo] == num[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

        ThreeSum15 threeSum15 = new ThreeSum15();
        int nums[] = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(threeSum15.threeSum(nums));


    }
}
