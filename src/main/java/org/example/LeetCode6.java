package org.example;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/18
 * Time:下午9:18
 *
 *
 * Z 字形变换
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 **/
public class LeetCode6 {

    HashMap<Integer, List<Character>> map;

    public static void main(String[] args) {
        System.out.println(new LeetCode6().convert("A", 1));
    }

    public String convert(String s, int numRows) {

        if(numRows == 1) {
            return s;
        }

        this.init(numRows);

        int mod = numRows * 2 - 2;

        char[] sc = s.toCharArray();

        for(int i=0; i<sc.length; i++) {
            int m = i % mod;
            if(m < numRows) {
                map.get(m).add(sc[i]);
            }
            else {
                map.get(mod-m).add(sc[i]);
            }
        }

        StringBuffer sb = new StringBuffer();
        map.entrySet().stream().forEach(entry -> {
            List<Character> list = entry.getValue();
            for(char c : list) {
                sb.append(c);
            }
        });
        return sb.toString();
    }

    private void init(int numRows) {
        map = new HashMap<>();
        for (int i=0; i<numRows; i++) {
            map.put(i, new ArrayList());
        }
    }
}
