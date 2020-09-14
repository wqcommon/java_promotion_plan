package kaikeba.daima0512;

/**
 *
 * 秦学宽
 *
 */
public class Question1 {


    /**
     * 先用 右指针，找到右边的第一个不是属于 val 的元素，等待和左边第一个属于 val 的元素，进行交换。
     * 时间复杂度： O(N)
     * 空间复杂度： O(1)
     */
    public static int method1(int[] nums, int val){
        int resLength = nums.length;
        int right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != val) {
                break;
            }
            right = i;
        }

        int left = 0;
        while (left <= right) {
            if (nums[left] == val) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;   // 交换了之后， left 不用++
                resLength--;        // 每交换一次， 最后的长度就减1
            }else{
                left++;
            }
        }

        return resLength;
    }

    /**
     * 测试方法。。。
     * @param length 原数组有多长。。。
     */
    public static void test(int length) {
        int n = length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (int) (Math.random() * 10);
        }
        int val = nums[(int) (Math.random() * n)];
        System.out.print("原数组： ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("\n原长度： " + n + "\n");

        System.out.println("val 值： " + val);
        int res = method1(nums, val);
        System.out.print("之后的数组： ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("\n之后的长度： " + res);
    }



    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.println("第 " + i + " 次 ： ");
            test(20);
            System.out.println("=====================================");
        }

    }
}
