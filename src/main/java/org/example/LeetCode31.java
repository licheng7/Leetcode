package org.example;

import java.util.*;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/28
 * Time:下午5:38
 *
 *
 * 下一个排列
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeetCode31 {

    public int[] nextPermutation(int[] nums) {

        for(int i=nums.length-1; i>=0; i--) {
            if(this.process(nums, i)) {
                Arrays.sort(nums, i+1, nums.length);
                return nums;
            }
        }

        this.process2(nums, 0, nums.length-1);

        return nums;
    }

    private boolean process(int[] nums, int i) {

        int m = nums[i];
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        boolean result = false;

        for(int a=i+1; a<nums.length; a++) {
            if(m < nums[a]) {
                result = true;
                if(nums[a] < minValue) {
                    minIndex = a;
                }
            }
        }

        if(result) {
            nums[i] = nums[minIndex];
            nums[minIndex] = m;
        }

        return result;
    }

    private void process2(int[] nums, int begin, int end) {

        if(begin == end || begin+1 == end) {
            return;
        }

        int a = nums[begin];
        nums[begin] = nums[end];
        nums[end] = a;

        this.process2(nums, begin+1, end-1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        System.out.println(Arrays.toString(new LeetCode31().nextPermutation(nums)));
    }
}
