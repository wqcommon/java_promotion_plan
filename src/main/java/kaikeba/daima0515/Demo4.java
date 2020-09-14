package kaikeba.daima0515;

import java.util.*;

/**
 * 5月15日
 * 部分排序
 * 给定一个整数数组，编写一个函数，找出索引m和n
 * 只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
 * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。
 * 函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * 示例：
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 排序： [1,2,4,6,7,7,7,10,11,12,16,18,19]
 * 输出： [3,9]
 * 提示：
 * 0 <= len(array) <= 1000000
 */

/**
 * 肖建宇
 */
public class Demo4 {
    public static void main(String[] args) {
        int[] nums = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        MinSort ms = new MinSort();
        ms.method(nums);
        System.out.println("["+ms.getMin()+","+ms.getMax()+"]");
    }


}

/**
 * 解题思路
 * 将原数组复制出一个新数组，将新数组排序后与原数组进行比较。
 * 先从数组头部开始一个一个往后比较，如果比较的值不相等则返回该值的下标m
 * 然后从数组尾部开始一个个往前比较，如果比较的值不相等则返回该值下标n
 * 此时[m,n]就是最小排序区间
 */
class MinSort {
    private int max = -1;//记录最小排序区间的最大索引
    private int min = -1;//记录最小排序区间的最小索引

    public MinSort() {
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void method(int[] nums) {
        QuickSort qs = new QuickSort();
        int len = nums.length;
        //复制一个数组并排序
        int[] temp = new int[nums.length];
        for (int i=0;i<temp.length;i++){
            temp[i] = nums[i];
        }
        qs.sort(temp);

        //用原数组跟有序数组进行比较，找到第一个不相等的值
        for (int m=0;m<len;m++){
            if (nums[m] != temp[m]){
                min = m;
                break;
            }
            //如果2个都是有序数组则返回[-1,-1],因为min和max的初始值就是-1。
            if (m == len-1){
                return;
            }
        }
        for (int n=len-1;n>min;n--){
            if (nums[n] != temp[n]){
                max = n;
                break;
            }
        }


    }
}
//快速排序
class QuickSort {
    private static void exch(int[] a, int i, int j) {
        int t;
        t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static int partition(int[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        int m = a[lo];
        while (true) {
            while (a[++i] < m) {
                if (i == hi) {
                    break;
                }
            }
            while (m<a[--j]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public void sort(int[] a) {
        sort(a,0,a.length-1);
    }
}