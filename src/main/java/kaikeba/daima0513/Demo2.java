package kaikeba.daima0513;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目名称：存在重复元素
 * 题目描述：给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false
 *
 * 肖建宇
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3};
        System.out.println(isRepetition(nums));
        System.out.println(isRepetition2(nums));
    }

    /**
     * 解题思路一：
     * 用双重for循环遍历，使每个值两两比较一次，只要有一次比较相等则返回true，否则返回false
     * @param nums
     * @return
     */
    public static boolean isRepetition(int[] nums){
        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 解题思路二：
     * 凭借HashSet存储的值不重复的特点，将数组的元素都add进hashset集合
     * 最后判断hashset的size()和nums的length()是否相等
     * 如果不相等则说明有重复值，返回true,否则返回false
     * @param nums
     * @return
     */
    //用HashSet存储数组
    public static boolean isRepetition2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if(set.size() == nums.length){
            return false;
        }
        return true;
    }
}
