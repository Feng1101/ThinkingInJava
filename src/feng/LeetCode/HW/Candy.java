package feng.LeetCode.HW;

public class Candy {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{12,3,5,6}));
    }
    public static int candy (int[] ratings){
        int n = ratings.length;
        int[] left=new int[n];
        for (int i = 0; i < n; i++) {
            if(i>0&&ratings[i]>ratings[i-1])
                left[i]=left[i-1]+1;
            else
                left[i]=1;
        }
        int[] right=new int[n];
        int result=0;
        for (int i = n-1; i>-1; i--) {
            if(i<n-1&&ratings[i]>ratings[i+1])
                right[i]=right[i+1]+1;
            else
                right[i]=1;
           result+=Math.max(left[i],right[i]);
        }
        return  result;
    }
}
