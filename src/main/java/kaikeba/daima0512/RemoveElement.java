package kaikeba.daima0512;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */

/**
 *  刘正勇
 */
public class RemoveElement {
    public static void main(String[] args) {

       int [] nums = {0,1,2,2,3,0,4,2};
       int val = 2;
        System.out.println(removeEletment(nums,val));
    }

    public static int removeEletment(int[] nums, int val){
        //双指针法，慢指针指向数组起始位置，快指针作为遍历依据
        int i = 0;
        //遍历数据
        for (int j = 0; j < nums.length; j++) {
            //元素不相等时
            if (nums[j] != val) {
                //把第num[j]索引上的值赋值给新数组nums[i]的下一个值nums[i++]
                nums[i++] = nums[j];

            }

        }
        return i;
    }

}

/**
 * 思路：我们可以保留两个指针 ii 和 jj，其中 ii 是慢指针，jj 是快指针。
 * 当 nums[j]与给定的值相等时，递增 j 以跳过该元素。只要 nums[j] 不等于 val
 * 把nums[j] 到 nums[i] 并同时递增两个索引。重复这一过程，直到 j到达数组的末尾，该数组的新长度为 i
 *
 * */