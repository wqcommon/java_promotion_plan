package kaikeba.daima0513;

/**
 * 焦亚鑫
 */
public class JYX {
    public static void main(String[] args) {
        int[] arr = {1,9,9,3,3,4,3,2,4,6};
        boolean bool = false;
        a:for(int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    bool = true;
                    break a;
                }
            }
        }
        System.out.println(bool);
    }
}

