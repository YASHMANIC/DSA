package Recursion;
import java.util.*;
public class N_queens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of queens");
        int n = sc.nextInt();
        sc.close();
        char[][] arr = new char[n][n];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]='.';
            }
        }
        check(arr,0);
    }


    public static boolean isSafe(char[][] arr,int row,int col){
        // check row
        for(int i=0;i<row;i++){
            if(arr[i][col] == 'Q') return false;
        }
        //check col
        for(int j=0;j<col;j++){
            if(arr[row][j] == 'Q') return false;
        }
        // Check upper left diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(arr[i][j] == 'Q') return false;
        }
        // Check upper right diagonal
        for(int i=row, j=col; i>=0 && j<arr.length; i--, j++) {
            if(arr[i][j] == 'Q') return false;
        }
        return true;
    }


    public static void print(char[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }


    public static void check(char[][] arr,int row){
        if(row == arr.length){
            print(arr);
            return;
        }
        for(int col=0;col<arr.length;col++){
            if(isSafe(arr,row,col) == true){
                arr[row][col] = 'Q';
                check(arr,row+1);
                arr[row][col]='.';
            }
        }
    }
}
