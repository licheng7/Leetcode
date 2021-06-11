package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/19
 * Time:下午4:16
 *
 *
 * 整数转罗马数字
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 **/
public class LeetCode12 {

    List<Obj> list;

    public String intToRoman(int num) {

        this.init();

        List<Obj> sortList = list.stream().sorted((a, b) -> b.getNum() - a.getNum()).collect(Collectors.toList());

        for(Obj obj : sortList) {

            int n = 0;
            while (num / obj.getNum() > 0) {

                num -= obj.getNum();
                n ++;
            }

            obj.setN(n);
        }

        StringBuffer sb = new StringBuffer();
        for(Obj obj : sortList) {

            for(int i=obj.getN(); i>0; i--) {

                sb.append(obj.getS());
            }
        }

        return sb.toString();
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

        System.out.println(new LeetCode12().intToRoman(3));
    }
}

class Obj {

    private int num;
    private String s;
    private int n;

    public Obj(int num, String s) {
        this.num = num;
        this.s = s;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
