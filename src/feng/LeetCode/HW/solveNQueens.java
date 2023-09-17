package feng.LeetCode.HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solveNQueens {
    public static void main(String[] args) {
        int[] queen=new int[100];
        Arrays.fill(queen,-1);
        ArrayList<List<String>> solution = new ArrayList<>();
        back_queen(solution,queen,8,1);
        for (List<String> result:solution){
            System.out.println(result.get(0));
        }
    }

    public static void back_queen(List<List<String>> solution,int[] queen,int n,int row){
        if(row==n+1){
            solution.add(generateBoard(solution,queen,n));
        }
        for(int i=1;i<=n;i++){
            queen[row]=i;
            if(isOk(row,queen))
                back_queen(solution,queen,n,row+1);
        }
    }

    public static boolean  isOk(int row ,int[] queen){
        for (int i = 1; i < row; i++) {
            if(queen[row]==queen[i]||Math.abs(queen[row]-queen[i])==Math.abs(row-i))
                return false;
        }
        return true;
    }

    public static List<String> generateBoard(List<List<String>> solution,int[] queen,int n){
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder("[");
        for (int i=1;i<=n;i++){
            sb.append(queen[i]).append(", ");
        }
        sb.delete(sb.length()-2,sb.length()).append("]");
        result.add(sb.toString());
        return result;
    }



}
