package kaikeba.daima0514;

import java.util.HashMap;
import java.util.Map;
/**
 * 主要元素
 * 如果数组中超过一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 *
 * 示例 1：
 *
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 *
 *
 * 示例 2：
 *
 *
 * 输入：[3,2]
 * 输出：-1
 */

/**
 * 刘正勇
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        //获取数组长度的一半是多少
        int count = nums.length / 2;
        Map<Integer,Integer> map = new HashMap<>();
        //遍历，找到次数大于nums.length / 2的元素
        for (int num: nums){
            int val = map.getOrDefault(num,0) + 1;
            map.put(num,val);
            if(val > count){
                return num;
            }
        }
       return -1;



    }
}

/**
 * 思路：先获取数组长度的一半，然后不停的去查询，加1去重新赋值，最后查到最大的，然后判断是不是
 */
