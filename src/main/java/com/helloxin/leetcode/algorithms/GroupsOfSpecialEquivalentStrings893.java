package com.helloxin.leetcode.algorithms;

import java.util.*;

/**
 * Created by nandiexin on 2019/5/15.
 * <p>
 * 你将得到一个字符串数组 A。
 * <p>
 * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
 * <p>
 * <p>
 * <p>
 * 一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，并且交换 S[j] 和 S [i]。
 * <p>
 * 现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
 * <p>
 * <p>
 * <p>
 * 返回 A 中特殊等价字符串组的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["a","b","c","a","c","c"]
 * 输出：3
 * 解释：3 组 ["a","a"]，["b"]，["c","c","c"]
 * 示例 2：
 * <p>
 * 输入：["aa","bb","ab","ba"]
 * 输出：4
 * 解释：4 组 ["aa"]，["bb"]，["ab"]，["ba"]
 * 示例 3：
 * <p>
 * 输入：["abc","acb","bac","bca","cab","cba"]
 * 输出：3
 * 解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
 * 示例 4：
 * <p>
 * 输入：["abcd","cdab","adcb","cbad"]
 * 输出：1
 * 解释：1 组 ["abcd","cdab","adcb","cbad"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * 所有 A[i] 都具有相同的长度。
 * 所有 A[i] 都只由小写字母组成。
 */
public class GroupsOfSpecialEquivalentStrings893 {

    // 其实这个题目只是之前那个题目的判断 改成里数组  AA是否包含B的问题
    //但是这道题没让我通过 不是很能理解  难道和这句话有关
    // 一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，并且交换 S[j] 和 S [i]  不明所以
    public int numSpecialEquivGroups(String[] A) {

        List<String> list = new ArrayList<String>();
        Set<String> containList = new HashSet<>();
        list.addAll(Arrays.asList(A));
        while (list.size() > 0) {
            String a = list.get(0);
            containList.add(a);
            for (int i = 1; i < list.size(); i++) {
                if((a+a).contains(list.get(i))){
                    list.remove(i);
                }
            }
            list.remove(0);
        }
        return containList.size();
    }

    public static void main(String[] args) {

        GroupsOfSpecialEquivalentStrings893 groupsOfSpecialEquivalentStrings893 = new GroupsOfSpecialEquivalentStrings893();
        String arr[] ={"a","b","c","a","c","c"};
        System.out.println(groupsOfSpecialEquivalentStrings893.numSpecialEquivGroups(arr));

    }
}
