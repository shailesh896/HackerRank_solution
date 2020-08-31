import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        int max=-9999;
        for(int i=0;i<grid.length;i++)
        for(int j=0;j<grid[0].length;j++)
        {
            if(grid[i][j]==1)
            {
                max=Math.max(max,maxretun(grid,i,j));
                
            }
        }
        return max;
    }
    static int  maxretun(int [][]grid,int i ,int j)
    {
        int max=0;
        if(i>=grid.length || j>=grid[0].length || j < 0 ||i<0 || grid[i][j]==0)
        { return 0;}
            max+=1;
            grid[i][j]=0;
            max+=maxretun(grid,i,j+1);//front
            max+=maxretun(grid,i+1,j+1);//front-down digonal
            max+=maxretun(grid,i+1,j);//down
            max+=maxretun(grid,i+1,j-1);//back-down daigonal
            max+=maxretun(grid,i,j-1);//back
           max+=maxretun(grid,i-1,j+1);//front-up digonal
           /*
            
            max+=maxretun(grid,i-1,j-1);
            max+=maxretun(grid,i-1,j);
            */
        
       return max;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
