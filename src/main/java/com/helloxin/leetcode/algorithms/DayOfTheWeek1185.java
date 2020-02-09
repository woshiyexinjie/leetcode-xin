package com.helloxin.leetcode.algorithms;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Created by yebanxian on 2020/2/9.
 * Given a date, return the corresponding day of the week for that date.
 * <p>
 * The input is given as three integers representing the day, month and year respectively.
 * <p>
 * Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: day = 31, month = 8, year = 2019
 * Output: "Saturday"
 * Example 2:
 * <p>
 * Input: day = 18, month = 7, year = 1999
 * Output: "Sunday"
 * Example 3:
 * <p>
 * Input: day = 15, month = 8, year = 1993
 * Output: "Sunday"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The given dates are valid dates between the years 1971 and 2100.
 */
public class DayOfTheWeek1185 {

    //但是没有通过编译 不支持LocalDate  leetcode  error: cannot find symbol
    //java8 java。time包中增加了基于Joda-Time的包
    public static String dayOfTheWeek(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        //枚举
        switch (dayOfWeek) {
            case FRIDAY:
                return "Friday";
            case MONDAY:
                return "Monday";
            case SUNDAY:
                return "Sunday";
            case TUESDAY:
                return "Tuesday";
            case SATURDAY:
                return "Saturday";
            case WEDNESDAY:
                return "Wednesday";
            case THURSDAY:
                return "Thursday";
            default:
                return "";
        }
    }

    //这个问题的公式是泽尔公式。  公式就不想取研究了 知道就好了
    //另一个名字是：Zeller同余或Kim Larsen计算公式
    String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek2(int d, int m, int y) {
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int c = y / 100;
        y = y % 100;
        int w = (c / 4 - 2 * c + y + y / 4 + 13 * (m + 1) / 5 + d - 1) % 7;
        return days[(w + 7) % 7];
    }


    //原来想的是这一天到公元的某一天总是知道的，这里要计算一下闰年，那么和7取模就可以知道星期几了
    //这样比较大的问题是需要计算回去 那么第一天是什么 这样也是挺麻烦的 觉得也不切实际
    //虽然题目的要求是 从1970年开始算，是否很多人也会关心公元前的某一天会是星期几
    //星期这个概念是从什么时候开始有的

    //也可以知道当前这天是星期几  这样的想法更加直接点 不用回去计算，任意一个日期与当前的日期差和7取模，
    //那么也可以推算出那一天是星期几

    /**
     * 中国古代七曜一词，起源于先秦时代的天文占星学，又称七政；汉朝的数学家刘洪著作七曜术讲述天文算学，
     * 《后汉书志二律历》:“正月甲子朔旦冬至,七曜之起,始于牛初。”；东晋范甯的《春秋穀梁传序》：
     * “阴阳为之愆度，七曜为之盈缩。”杨士勋疏：“谓之七曜者，日月五星皆照天下，故谓之曜。
     * ”五星指火、水、木、金、土。在唐代以前还未有使用七星指代轮回的7日或一周；
     * 古巴比伦人首先使用7日为一周的时间单位，后来犹太人把它传到古埃及，又由古埃及传到罗马，公元3世纪以后，
     * 就广泛地传播到欧洲各国。唐朝时期在西域和中国的交流中传入了中土获得发展，再传入朝鲜半岛、日本。光绪三十一年
     * （1905年）由袁嘉谷所定用“星期”代替“曜日”，到了民国以后星期被广泛使用。
     *
     * @param args
     */

    //这种做法就是已经知道 1971.1.1 是星期五
    int[] m = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] res = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

    public String dayOfTheWeek3(int day, int month, int year) {
        int days = years(year);
        if (isLeap(year))
            m[2] = 29;
        for (int i = 0; i < month; i++) {
            days += m[i];
        }
        days += day - 1;
        return res[days % 7];
    }

    private int years(int y) {
        int count = 0;
        for (int i = 1971; i < y; i++) {
            if (isLeap(i)) {
                count += 366;
            } else {
                count += 365;
            }
        }
        return count;
    }

    private boolean isLeap(int y) {
        if (y % 4 != 0) {
            return false;
        } else if (y % 100 != 0) {
            return true;
        } else if (y % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(1, 1, 1971));

        System.out.println(LocalDate.of(2020, 2, 8).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    }
}
