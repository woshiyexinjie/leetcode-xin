package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nandiexin on 2019/5/9.
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * <p>
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 示例 2：
 * <p>
 * 输入：[5,5,10]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：[10,10]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：[5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= bills.length <= 10000
 * bills[i] 不是 5 就是 10 或是 20
 */
public class LemonadeChange860 {


    public boolean lemonadeChange(int[] bills) {

        Map<Integer,Integer> map = new HashMap();
        map.put(5,0);
        map.put(10,0);
        for (int bill:bills){
            if(!dealbill(bill,map)){
                return false;
            }
        }
        return true;


    }

    private boolean dealbill(int bill, Map<Integer, Integer> map) {
        if(bill == 5){
            map.put(5,map.get(5)+1);
            return true;
        }
        if(bill ==10 && map.get(5) > 0){
            map.put(10,map.get(10)+1);
            map.put(5,map.get(5)-1);
            return true;
        }
        if(bill ==20){
            if(map.get(10) > 0 && map.get(5) > 0){
                map.put(5,map.get(5)-1);
                map.put(10,map.get(10)-1);
                return true;
            }else if(map.get(10) <= 0 && map.get(5) > 2){
                map.put(5,map.get(5)-3);
                return true;
            }
        }
        return false;
    }
    //不使用map 那么直接下面这么用也是一样的
    public boolean lemonadeChange2(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) {
                five++;
            } else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else {
                five -= 3;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        LemonadeChange860 lemonadeChange860 = new LemonadeChange860();
        int charge[] ={10,10};
        System.out.println(lemonadeChange860.lemonadeChange(charge));

    }


}
