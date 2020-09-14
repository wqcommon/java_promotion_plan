package kaikeba.daima0515;

import java.util.Arrays;

/**
 * 部分排序
 *
 * 给定一个整数数组，编写一个函数，找出索引m和n，
 * 只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
 * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，
 * 若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 */

/**
 * 吴艺思
 */
public class Practice2 {
    public static void main(String[] args) {
        int[] nums = {1,2,4,7,16,18,19};

        int[] arr1 = new int[nums.length];      //升序数组
        int[] arr2 = new int[nums.length];      //降序数组
        for(int i=0;i<nums.length;i++){
            arr1[i] = nums[i];
        }
        Arrays.sort(arr1);

        for(int i=0;i<nums.length;i++){
            arr2[i] = arr1[nums.length-1-i];
        }

        int[] range1 = ascendingOrder(nums,arr1);
        int[] range2 = descendingOrder(nums,arr2);
        if((range1[1]-range1[0])<(range2[1]-range2[0])){
            System.out.println(Arrays.toString(range1));
        }else{
            System.out.println(Arrays.toString(range2));
        }

    }

    public static int[] ascendingOrder(int[] nums,int[] arr1){
        int[] range = new int[2];
        aa:for(int i=0;i<nums.length;i++){
            while (nums[i] != arr1[i]){
                range[0] = i;
                break aa;
            }
            range[0] = -1;
        }

        bb:for(int i=nums.length-1;i>0;i--){
            while(nums[i] != arr1[i]){
                range[1] = i;
                break bb;
            }
            range[1] = -1;
        }
        return range;
    }

    public static int[] descendingOrder(int[] nums,int[] arr2){
        int[] range = new int[2];
        aa:for(int i=0;i<nums.length;i++){
            while (nums[i] != arr2[nums.length-1-i]){
                range[0] = i;
                break aa;
            }
            range[0] = -1;
        }

        bb:for(int i=0;i<nums.length;i++){
            while(nums[nums.length-1-i] != arr2[i]){
                range[1] = i;
                break bb;
            }
            range[1] = -1;
        }
        return range;
    }

}
