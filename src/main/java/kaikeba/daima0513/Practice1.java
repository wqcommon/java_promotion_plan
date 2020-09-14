package kaikeba.daima0513;

/**
 * 吴艺思
 */
public class Practice1 {
    /**
     * 每日一练
     * <p>
     * 题目名称：存在重复元素
     * 题目描述：给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3,9,6,5,3};
        System.out.println(repeat(nums));
    }

    public static boolean repeat(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;

    }
}