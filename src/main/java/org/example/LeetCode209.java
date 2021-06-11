package org.example;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/22
 * Time:上午11:03
 *
 *
 * 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeetCode209 {

    public int minSubArrayLen(int target, int[] nums) {

        int min = 0;

        for(int i=0; i<nums.length; i++) {

            for(int j=i; j<nums.length; j++) {

                if(this.process(target, nums, i, j)) {

                    if(min == 0) {
                        min = j-i+1;
                    }
                    else {
                        if(j-i+1 < min) {
                            min = j-i+1;
                        }
                    }
                }
            }
        }

        return min;
    }

    private boolean process(int target, int[] nums, int begin, int end) {

        int a = 0;
        for(int i=begin; i<end; i++) {
            a += nums[i];
        }

        if(a > target) {
            return false;
        }

        if(a+nums[end] < target) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] array = {2,3,1,2,4,3};
        System.out.println(new LeetCode209().minSubArrayLen(7, array));
    }
}
