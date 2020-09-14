package kaikeba.daima0515;

import java.util.Arrays;

/**
 * 秦学宽
 */
public class Day4 {

    public static int[] process(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }

        // 排好序后的数组，升序
        int[] newNumsAscending  = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNumsAscending[i] = nums[i];
        }
        Arrays.sort(newNumsAscending);

        // 排好序后的数组，降序。
        int[] newNumsDescending = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            newNumsDescending[nums.length - 1 - i] = newNumsAscending[i];
        }

        int leftAscending = -1;     // 升序情况下，返回区间的左闭区间值
        int rightAscending = -1;    // 升序情况下，返回区间的右闭区间值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != newNumsAscending[i]) {
                leftAscending = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != newNumsAscending[i]) {
                rightAscending = i;
                break;
            }
        }


        int leftDescending = -1;    // 降序情况下，返回区间的左闭区间值
        int rightDescending = -1;   // 降序情况下，返回区间的右闭区间值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != newNumsDescending[i]) {
                leftDescending = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != newNumsDescending[i]) {
                rightDescending = i;
                break;
            }
        }

        return (rightAscending - leftAscending) < (rightDescending - leftDescending) ?
                new int[]{leftAscending, rightAscending} :
                new int[]{leftDescending, rightDescending};
    }


    public static void main(String[] args) {

        for (int j = 0; j < 10; j++) {
            int[] nums = new int[10];
            for (int i = 0; i < 10; i++) {
                nums[i] = (int) (Math.random() * 20);
            }
            System.out.print("previous: ");
            for (int num : nums) {
                System.out.print(num + " ");
            }

            int[] process = process(nums);
            System.out.println(" --> 【" + process[0] + " ， " + process[1] + "】\n");

        }

    }


}
