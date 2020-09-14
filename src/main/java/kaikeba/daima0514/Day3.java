package kaikeba.daima0514;

import java.util.HashMap;

/**
 * 主要元素
 * 如果数组中超过一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 *
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 */

/**
 * 秦学宽
 */
public class Day3 {

    public static int method(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int half = nums.length / 2;
        for (Integer key : map.keySet()) {
            if (map.get(key) > half) {
                return key;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            int[] nums = new int[10];
            for (int i = 0; i < 10; i++) {
                nums[i] = (int) (Math.random() * 5);
            }
            System.out.print("原数组： ");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println("  ---->  " + method(nums));
        }
    }


}
