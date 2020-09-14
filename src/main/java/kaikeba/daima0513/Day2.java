package kaikeba.daima0513;


import java.util.HashSet;
import java.util.Set;

/**
 * 每日一练
 *
 * 题目名称：存在重复元素
 * 题目描述：给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */

/**
 * 秦学宽
 */
public class Day2 {

    /**
     * 时间复杂度： O(N²)
     */
    public static boolean isNonDuplication(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return false;       // 一旦出现重复元素，就返回false
                }
            }
        }

        // 遍历完了，还没有出现重复元素，就返回true。
        return true;
    }

    /**
     * 时间复杂度： O(N)
     */
    public static boolean isNonDuplication2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // 如果没有重复元素，就是等长的。
        // 如果有重复元素，就是不等长的。
        return nums.length == set.size();
    }


    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            int[] nums = new int[10];
            for (int i = 0; i < 10; i++) {
                nums[i] = (int) (Math.random() * 50);
            }
            System.out.print("原数组： ");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println(isNonDuplication(nums) + "  -- " + isNonDuplication2(nums));
        }
    }



}
