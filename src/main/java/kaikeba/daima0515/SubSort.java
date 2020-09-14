package kaikeba.daima0515;

/**
 * 部分排序
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * <p>
 * <p>
 * 示例：
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * 提示：
 * 0 <= len(array) <= 1000000
 */

/**
 * 刘正勇
 */
public class SubSort {
    public static void main(String[] args) {
        //int[] nums = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] nums = {5,6,7,8,1,2,3,4};
        int[] arr = subSort(nums);
        for (int i : arr){
            System.out.println("["+i+"]");
        }

    }


    public static int[] subSort(int[] nums) {
        if (nums.length == 0) return new int[]{-1, -1};

        // 从左扫描到右寻找逆序对（正序：逐渐变大）
        int max = nums[0];
        // 用来记录最右的那个逆序对位置
        int rightIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                rightIndex = i;
            }
        }

        // 提前结束
        if (rightIndex == -1) return new int[]{-1, -1};

        // 从右扫描到左寻找逆序对（正序：逐渐变小）
        int min = nums[nums.length - 1];
        // 用来记录最左的那个逆序对位置
        int leftIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                leftIndex = i;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }


}

/**
 * 解题思路是先从左到右遍历数组，用一个变量max记录遍历到当前位置之前的最大值，与当前位置进行比较，
 * 如果当前位置大于max，则更新max的值，如果当前位置小于max，就把当前下标赋给变量rightIndex,
 * 同样，用min变量表示最后一个数，从右边也做同样的操作，直到当前值大于min，然后把当前值的下标给最做的逆序的位置leftIndex
 *
 */