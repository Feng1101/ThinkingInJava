package temp.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HWT1 {
    public static void main(String[] args) {



    }

    public int deleteGreatestValue(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        //排序
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }
        int result=0;
        for (int i = n-1; i >=0 ; i--) {
            int max=0;
            for (int j = 0; j < m; j++) {
                max=Math.max(max,grid[j][i]);
            }
            result+=max;
        }

        return result;
    }
}

/*
for (int i = 0; i < m; i++) {
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                tempList.add(grid[i][j]);
            }
            Collections.sort(tempList);
            int temp=0;
            for(Integer key:tempList){
                grid[i][temp]=key;
                temp++;
            }
        }
 */