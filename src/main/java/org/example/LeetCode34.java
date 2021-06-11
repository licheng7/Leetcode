package org.example;

import java.util.Arrays;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/5/24
 * Time:下午3:01
 *
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {

        int begin = -1;
        int end = -1;

        if(nums.length!=0 && target>=nums[0] && target<=nums[nums.length-1]) {

            for(int i=0; i<nums.length; i++) {
                if(target == nums[i]) {
                    if(begin == -1) {
                        begin = i;
                        end = i;
                    }
                    else {
                        end = i;
                    }
                }
                else if(target < nums[i]) {
                    break;
                }
            }
        }

        return new int[]{begin, end};
    }

    public static void main(String[] args) {
        int[] a = {};
        System.out.println(Arrays.toString(new LeetCode34().searchRange(a, 8)));
    }
}
