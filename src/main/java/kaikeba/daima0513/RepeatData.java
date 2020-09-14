package kaikeba.daima0513;

import java.util.HashSet;

/**
 * 题目名称：存在重复元素
 * 题目描述：给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @autor lzy
 */

/**
 * 刘正勇
 */
public class RepeatData {
    public static void main(String[] args) {
         int[] nums = {1,2,3,4,2};
        System.out.println(new RepeatData().isRepeat(nums));
    }

    public boolean isRepeat(int[] nums){
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }

}

/**
 * 思路：利用HashSet将数组中的值为set集合，遍历数组，如果发现有重复的就直接返回true。否则，将该数值放进set中。
 *  contains（）
 *
 * contains() 该方法的目的是检查给定HashSet中是否存在元素。如果找到该元素，则返回true，否则返回false。
 *
 * add（）方法可用于将元素添加到数组。方法声明只有当元素尚未存在于集合中时才会添加元素。如果成功添加了元素，则该方法返回true，否则返回false。
  */
