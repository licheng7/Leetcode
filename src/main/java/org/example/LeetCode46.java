package org.example;

import java.util.*;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/20
 * Time:下午8:56
 *
 *
 * 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 **/
public class LeetCode46 {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.process(nums, new ArrayList<>(), new ArrayList<>());
        return results;
    }

    private void process(int[] nums, List<Integer> remove, List<Integer> result) {

        if(nums.length == remove.size()) {
            results.add(result);
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!remove.contains(i)) {
                List<Integer> newRemove = new ArrayList<>(remove);
                newRemove.add(i);
                List<Integer> newResult = new ArrayList<>(result);
                newResult.add(nums[i]);
                this.process(nums, newRemove, newResult);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new LeetCode46().permute(nums));
    }
}
