package temp.exam;

import java.util.*;

public class HW {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        long[] nums = new long[num];
        long[] lefts = new long[num];
        long[] rights = new long[num];
        in.nextLine();
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        // 注意 hasNext 和 hasNextLine 的区别
        for (int i = 0; i < num; i++) {
            nums[i]=Integer.parseInt(s1[i]);
        }
        long result=0;
        for (int i = 0; i < num-1; i++) {
            if(i==0){
                lefts[i]=nums[i];
                int right=0;
                for(int j=1;j<num;j++){
                    right+=nums[j];
                }
                rights[i]=right;
            }else{
                lefts[i]=lefts[i-1]+nums[i];
                rights[i]=rights[i-1]-nums[i];
            }
            long abs = Math.abs(lefts[i]-rights[i]);
            result=result>abs?result:abs;
        }
        System.out.println(result);

    }
}


