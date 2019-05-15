package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nandiexin on 2019/5/15.
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * <p>
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * <p>
 * 返回所有不常用单词的列表。
 * <p>
 * 您可以按任何顺序返回列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 * 示例 2：
 * <p>
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A 和 B 都只包含空格和小写字母
 */
public class UncommonWordsFromTwoSentences884 {

    //这题看看别人怎么写
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String w : (A + " " + B).split(" ")) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String w : count.keySet()) {
            if (count.get(w) == 1) {
                res.add(w);
            }
        }
        return res.toArray(new String[0]);
    }

    public String[] uncommonFromSentences2(String A, String B) {
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");
        ArrayList<String> arr = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String AA : wordsA)
        {
            map.put(AA, map.getOrDefault(AA,0)+1);
        }
        for(String BB : wordsB)
        {
            map.put(BB, map.getOrDefault(BB,0)+1);
        }

        for(Map.Entry<String,Integer> entry: map.entrySet())
        {
            if(entry.getValue()<=1)
            {
                arr.add(entry.getKey());
            }
        }
        //Converting back from arraylist to array of string
        String[] l = new String[arr.size()];
        int itr = 0;
        for(String x: arr){

            l[itr++]= x;
        }
        return l;
    }
}
