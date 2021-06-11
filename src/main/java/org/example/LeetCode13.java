package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/19
 * Time:下午7:38
 *
 *
 * 罗马数字转整数
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeetCode13 {

    List<Obj> list;

    public int romanToInt(String s) {

        this.init();

        int result = 0;

        List<Obj> sortList = list.stream().sorted((a, b) -> b.getNum() - a.getNum()).collect(Collectors.toList());

        while(s.length() > 0) {

            for (Obj obj : sortList) {

                if (s.startsWith(obj.getS())) {

                    result += obj.getNum();
                    s = s.substring(obj.getS().length());
                }
            }
        }

        return result;
    }

    private void init() {

        list = new ArrayList<>();

        list.add(new Obj(1, "I"));
        list.add(new Obj(4, "IV"));
        list.add(new Obj(5, "V"));
        list.add(new Obj(9, "IX"));
        list.add(new Obj(10, "X"));
        list.add(new Obj(40, "XL"));
        list.add(new Obj(50, "L"));
        list.add(new Obj(90, "XC"));
        list.add(new Obj(100, "C"));
        list.add(new Obj(400, "CD"));
        list.add(new Obj(500, "D"));
        list.add(new Obj(900, "CM"));
        list.add(new Obj(1000, "M"));
    }

    public static void main(String[] args) {

        System.out.println(new LeetCode13().romanToInt("III"));
    }
}