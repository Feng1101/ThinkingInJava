package temp.exam;

import java.util.Scanner;

public class HW2 {
    private static  int nums;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int [][] keys=new int[m][n];
        in.nextLine();
        nums=m*n;
        // 注意 hasNext 和 hasNextLine 的区别
        for (int i = 0; i < m; i++) {
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            for (int j = 0; j < n; j++) {
                keys[i][j]=Integer.parseInt(s1[j]);
            }
        }
        inspect(keys,0,0,m,n);
        System.out.println(nums);
    }
    public static void inspect(int[][] keys,int m,int n,int row,int length){
        keys[m][n]=1;
        nums--;
        if((n+1)<length&&keys[m][n+1]==0){
            inspect(keys,m,n+1,row,length);
        }
        if((m+1)<row&&keys[m+1][n]==0){
            inspect(keys,m+1,n,row,length);
        }
        if((n-1)>=0&&keys[m][n-1]==0){
            inspect(keys,m,n-1,row,length);
        }
        if((m-1)>=0&&keys[m-1][n]==0){
            inspect(keys,m-1,n,row,length);
        }
    }
}
