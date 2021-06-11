package org.example;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/17
 * Time:下午10:54
 *
 *
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 **/
public class LeetCode3 {

    public static void main(String[] args) {

        String s = "pwwkew";
        System.out.println(new LeetCode3().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {

        int max = 0;

        char[] sc = s.toCharArray();

        int begin = 0;

        for(int i=0; i<s.length(); i++) {

            char target = sc[i];

            int index = this.checkIndex(sc, begin, i, target);

            if(index != -1) {
                begin = (index + 1 > i) ? i : index + 1;
            }
            else {
                if(i - begin + 1 > max) {

                    max = i - begin + 1;
                }
            }
        }

        return max;
    }

    private int checkIndex(char[] sc, int begin, int end, char target) {

        for(int i=begin; i<end; i++) {
            if(sc[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
