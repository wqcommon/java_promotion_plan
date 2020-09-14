package kaikeba.daima0512;

/**
 * ���ַ�������һ�����Ƚ�
 * @author YIS
 *
 * 吴艺思
 *
 */
public class Practice1 {

	public static void main(String[] args) {
		
		int[] nums = {3,2,2,3};
		int val = 3;
		
		bubble(nums,val);
		System.out.println();
		newIdea(nums,val);
		System.out.println();
		
		int[] nums2 = {0,1,2,2,3,0,4,2};
		int val2 = 2;
		bubble(nums2,val2);
		System.out.println();
		newIdea(nums2,val2);
		System.out.println();
	}
	
	/*
	 * 	ʹ��ð������(�������������Ч�ʸ��ߵķ���)
	 */
	public static void bubble(int[] nums,int val) {
		int count = 0;
		int temp;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==val) {
				count++;
			}
		}
		//���ѭ�����Ƶ��ǣ��Ƚϵ�������
		//���ѭ��������length-1
		for(int i=0;i<nums.length-1;i++) {
			//�ڲ�ѭ�����Ƶ��ǣ�ÿ�ֱȽϵĴ���
			//��i�֣�i��0��ʼ���㣩���Ƚϴ���Ϊ��length-i-1
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]==val) {   //�Ƚϲ�����
					temp = nums[j];   
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		System.out.print("����Ӧ�÷����µĳ��� "+(nums.length-count)+", ���� nums �е�ǰ"+(nums.length-count)+"��Ԫ�ؾ�Ϊ:");
		for(int i=0;i<nums.length-count;i++) {
			System.out.print(nums[i]+" ");
		}
	}
	
	/*
	 * �µ��뷨
	 */
	public static void newIdea(int[] nums,int val) {

		int Index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[Index] = nums[i];
                Index++;
            }
        }
        System.out.print("����Ӧ�÷����µĳ��� "+Index+", ���� nums �е�ǰ"+Index+"��Ԫ�ؾ�Ϊ:");
       for(int i=0;i<Index;i++) {
			System.out.print(nums[i]+" ");
		}
	}
	
}
