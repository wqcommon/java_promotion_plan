package kaikeba.daima0514;

/**
 * 如果数组中超过一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 */

/**
 * 吴艺思
 */
public class practice2 {
    public static void main(String[] args) {

        int[] nums = {1,2,5,9,5,9,5,5,5};
        int count = 0;
        int num = -1;

        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                    if(count>nums.length/2){
                        num = nums[i];
                        break;
                    }
                }
            }
            count = 0;
        }
        System.out.println(num);
    }
}
