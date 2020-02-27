package jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-12-04 11:29
 *
 * 测试自动装箱和拆箱
 */
public class Test1 {

    public int foo(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10000);
        int result = list.get(0);
        return result;
    }

    public ArrayList list(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        return list;
    }


    public static void main(String[] args) {
//        List<String> list =  new Test1().restoreIpAddresses("25525511135");
//        System.out.println(list);
//        System.out.println(Character.toLowerCase('0'));
        Test1 test1 = new Test1();
        int[] next = test1.getNext("abcabx");
        System.out.println(Arrays.toString(next));
        test1.search("abcacfabcabx","abcabx",next);
    }

    public void search(String original, String find, int next[]) {
        int j = 0;
        for (int i = 0; i < original.length(); i++) {
            while (j > 0 && original.charAt(i) != find.charAt(j))
                j = next[j];
            if (original.charAt(i) == find.charAt(j))
                j++;
            if (j == find.length()) {
                System.out.println("find at position " + (i - j));
                System.out.println(original.subSequence(i - j + 1, i + 1));
                j = next[j];
            }
        }
    }

    public int[] getNext(String b)
    {
        int len=b.length();
        int j=0;

        int next[]=new int[len+1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
        next[0]=next[1]=0;

        for(int i=1;i<len;i++)//i表示字符串的下标，从0开始
        {//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
            while(j>0&&b.charAt(i)!=b.charAt(j))j=next[j];
            if(b.charAt(i)==b.charAt(j))j++;
            next[i+1]=j;
        }

        return next;
    }

    public List<String> restoreIpAddresses(String s) {
        if(s.isEmpty() || s.length() < 4){
            return new ArrayList<>();
        }
        List<String> retList = new ArrayList<>();
        LinkedList<String> temRet = new LinkedList<>();
        dfs(retList,temRet,0,s,1);
        return retList;
    }

    private void dfs(List<String> retList, LinkedList<String> temRet, int index, String s, int dots){

        for(int i = index; i < s.length(); i++){
            String s1 = s.substring(index,i+1);
            if(validString(s1)){
                temRet.addLast(s1);
                if(dots == 3){
                    String s2 = s.substring(i+1);
                    if(validString(s2)){
                        temRet.addLast(s2);
                        retList.add(String.join(".",temRet));
                        temRet.removeLast();
                    }
                }else{
                    dfs(retList,temRet,i+1,s,dots+1);
                }
                temRet.removeLast();
            }
        }
    }

    private boolean validString(String s){
        int len = s.length();
        if(len > 3){
            return false;
        }
        if(s.charAt(0) == '0' && len > 1){
            return false;
        }
        return Integer.parseInt(s) <= 255;
    }
}
