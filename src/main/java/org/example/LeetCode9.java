package org.example;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/19
 * Time:下午3:14
 *
 *
 * 回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeetCode9 {

    public boolean isPalindrome(int x) {

        // 先找到中间点，中间点可能是一个数，也可能是两个数
        char[] cs = String.valueOf(x).toCharArray();

        if(cs.length % 2 == 0) { // 偶数说明中间是个gap

            int a = cs.length / 2;

            return this.process(cs, a-1, a);
        }
        else { // 奇数说明中间是一个数

            return this.process(cs, cs.length / 2, cs.length / 2);
        }
    }

    private boolean process(char[] cs, int begin, int end) {

        if(begin < 0 || end >=cs.length) {

            return true;
        }

        if(cs[begin] != cs[end]) {

            return false;
        }

        return this.process(cs, begin-1, end+1);
    }

    public static void main(String[] args) {

        System.out.println(new LeetCode9().isPalindrome(1211));
    }
}
