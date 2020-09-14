package kaikeba.daima0512;

import java.util.Arrays;

/**
 * 解题思路一
 * 遍历数组，每当找到与val值相等的数，就将这个值和后面的值交换，一直交换到数组最后，然后数组的长度减一。
 * 解题思路二
 * 遍历数组，每当找到与val值相等的数，就将这个数与最后面的值交换，然后数组长度减一
 * （这个数组长度len是一个记录值，不是真实的数组长度）
 */

/**
 * 肖建宇
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int len = method(nums,val);
        System.out.println("数组新的长度为：");
        System.out.println(len);
        System.out.println("数组前"+len+"个元素为：");
        for (int i=0;i<len;i++){
            System.out.print(nums[i]+"\t");
        }
        System.out.println("\n");
        System.out.println("实际数组元素为：");
        System.out.println(Arrays.toString(nums));
    }

    public static int method(int[] nums, int val){
        int len = nums.length;
        for (int i=0;i<len;i++){
            if(nums[i] == val){
                for (int j=i;j<len-1;j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                i--;
                len--;
            }
        }

        return len;
    }
    public static int method2(int[] nums, int val){
        int len = nums.length;//动态记录数组长度
        //每次找到
        for (int i=0;i<len;i++){
            if(nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[len-1];
                nums[len-1] = temp;
                i--;
                len--;
            }
        }
        System.out.println("数组前"+len+"个元素为：");

        return len;
    }
}
