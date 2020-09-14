package kaikeba.daima0514;

/**
 * 肖建宇
 */
public class Demo3 {
    public static void main(String[] args) {
        int[] nums = {1,2,5,9,5,9,5,5,5};
        int n = method(nums);
        System.out.println(n);
    }

    /**
     * 解题思路一
     * 利用2个for循环，使得每个元素都与其他元素比较是否相等，相等则count++，
     * 当count大于数组长度的一半时，返回该值，如果没找到则返回-1；
     * @param nums
     * @return
     */
    public static int method(int[] nums){
        int count;
        int len = nums.length;
        for (int i=0;i<nums.length;i++){
            count = 0;
            for (int j=0;j<nums.length;j++){
                if (nums[i] == nums[j]){
                    count++;
                }
                if (count>(len/2)){
                    return nums[i];
                }
            }
        }

        return -1;
    }
}
