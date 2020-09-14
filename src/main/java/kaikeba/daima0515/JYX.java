package kaikeba.daima0515;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 焦亚鑫
 */
public class JYX {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        //升序索引下标
        int m1 = arr.length;
        int n1 = 0;
        //降序索引下标
        int m2 = arr.length;
        int n2 = 0;
        loopR1:for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    m1 = i;
                    break loopR1;
                }
            }
        }
        loopD1:for(int i=arr.length-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                if(arr[i] < arr[j]){
                    n1 = i;
                    break loopD1;
                }
            }
        }
        loopR2:for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] < arr[j]){
                    m2 = i;
                    break loopR2;
                }
            }
        }
        loopD2:for(int i=arr.length-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                if(arr[i] > arr[j]){
                    n2 = i;
                    break loopD2;
                }
            }
        }
        if(m1 == arr.length ||m2 ==arr.length){
            System.out.println("不用排序");
        }else{
            if((n1-m1) < (n2-m2)){
                System.out.println("升序索引区间"+m1+"，"+n1);
                int index = 0;
                for(int i=m1;i<n1;i++){
                    for(int j=m1;j<n1;j++){
                        if(arr[j]>arr[j+1]){
                            index = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] =index;
                        }
                    }
                }
            }else{
                System.out.println("降序索引区间"+m2+"，"+n2);
                int index = 0;
                for(int i=m1;i<n1;i++){
                    for(int j=m1;j<n1;j++){
                        if(arr[j]<arr[j+1]){
                            index = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] =index;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));



    }

}
