package kaikeba.daima0512;

/**
 * 焦亚鑫
 */
public class JYX {
    public static void main(String[] args) {
        int[] nums = {2,1,2,2,5,2,5,2};
        int val = 2;
        int index = nums.length;
        boolean bool ;
        int counter = 0;
        do{
            bool = false;
            for(int i=0;i<nums.length-counter;i++){
                if(nums[i] == val){
                    for(int x=i;x<nums.length-counter-1;x++){
                        nums[x] = nums[x+1];
                    }
                    nums[nums.length-counter-1] = val;
                    index--;
                    bool = true;
                    counter++;
                    break;
                }
            }
        }while (bool);
        for(int i=0;i<index;i++){
            System.out.print(nums[i]+"  ");
        }
        System.out.println();
        System.out.println("新长度："+index);
        System.out.println("原数组：");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"  ");
        }
    }
}
