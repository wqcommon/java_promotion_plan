package kaikeba.daima0514;

/**
 * 焦亚鑫
 */
public class JYX {
    public static void main(String[] args) {
        int[] arr = {1,2,5,9,5,9,5,5,5};
        double counter;
        int index = -1;
        loop:for(int i=0;i < arr.length/2+1;i++){
            counter = 1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    counter++;
                    if(counter>(arr.length/2)){
                        index = arr[j];
                        break loop;
                    }
                }
            }
        }
        System.out.println(index);
    }
}
