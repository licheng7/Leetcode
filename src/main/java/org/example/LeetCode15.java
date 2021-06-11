package org.example;

import java.util.*;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/20
 * Time:下午4:36
 *
 *
 * 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<String> set = new HashSet();

        List<List<Integer>> result = new ArrayList<>();

        // step1 排序，排序是为了减少输出碰撞
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {

            for(int j=i+1; j<nums.length; j++) {

                for (int k=j+1; k<nums.length; k++) {

                    if(nums[i] + nums[j] + nums[k] == 0) {

                        if(!set.contains(nums[i]+"-"+nums[j]+"-"+nums[k])) {

                            List list = new ArrayList();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);

                            result.add(list);

                            set.add(nums[i]+"-"+nums[j]+"-"+nums[k]);
                        }
                    }
                }
            }
        }

        return result;
    }
}
