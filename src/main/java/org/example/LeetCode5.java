package org.example;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/18
 * Time:下午5:53
 *
 *
 * 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 **/
public class LeetCode5 {

    static int max;
    static int[] result = new int[2];

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new LeetCode5().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {

        char[] sc = s.toCharArray();

        for(int i=0; i<sc.length; i++) {

            this.process(sc, i, i);
            this.process(sc, i, i+1);
        }

        StringBuffer sb = new StringBuffer();
        for(int i=result[0]; i<=result[1]; i++) {
            sb.append(sc[i]);
        }

        return sb.toString();
    }

    private void process(char[] sc, int begin, int end) {

        if(begin<0 || end>=sc.length) {
            return;
        }

        if(sc[begin] != sc[end]) {
            return;
        }

        if(end - begin + 1 > max) {
            max = end - begin + 1;
            result[0] = begin;
            result[1] = end;
        }

        this.process(sc, begin-1, end+1);
    }
}
