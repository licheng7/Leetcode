package org.example;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/19
 * Time:下午7:48
 *
 *
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 **/
public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {

        int index = 0;

        if(strs.length == 0) {

            return "";
        }

        while (true) {

            char c = 0;

            for(int i=0; i<strs.length; i++) {

                if(index >= strs[i].length()) {
                    return strs[i];
                }

                if(i == 0) {
                    c = strs[i].charAt(index);
                }
                else {
                    if(c != strs[i].charAt(index)) {
                        return strs[i].substring(0, index);
                    }
                }
            }

            index ++;
        }
    }

    public static void main(String[] args) {
        String[] s = {"flower", "flow", "flight"};
        System.out.println(new LeetCode14().longestCommonPrefix(s));
    }
}
