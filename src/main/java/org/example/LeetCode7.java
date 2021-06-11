package org.example;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/18
 * Time:下午10:09
 *
 *
 * 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeetCode7 {

    static int i = 1;

    public int reverse(int x) {

        if(x < 0) {
            i = -1;
            x = x*-1;
        }

        Queue<Integer> queue = new LinkedList<>();

        while (true) {

            int b = x % 10;

            x = x / 10;

            queue.add(b);

            if(x == 0) {
                break;
            }
        }

        int result = 0;

        while (true) {

            Integer a = queue.poll();
            if(a == null) {
                break;
            }

            for(int n=0; n<queue.size(); n++) {
                a = a*10;
            }

            result += a;
        }

        return i*result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode7().reverse(120));
    }
}
