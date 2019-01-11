package Array1D;

import org.w3c.dom.ls.LSOutput;

import javax.management.openmbean.ArrayType;
import java.io.IOException;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
            long n= sc.nextLong();
            boolean nIsEven=((n-1)|0)==0?true:false;
            long value=!nIsEven?n-1:(n-1)^(n-2);
            int count=!nIsEven?2:0;
            for (long i=1; i<n-1; i++){
                for (long j=n-2; j>=0; j--){
                    if (i==j-1)
                        count++;
                }
            }
            displayXOR(24);
        }
    }
    public static void displayXOR(int n){
        int arr[][] = new int[n][n];
        System.out.print("\t");
        for (int i=0; i<n; i++)
            System.out.print(i+" ");
        System.out.println();
        for (int i=0; i<n; i++){
            System.out.printf("%3s",i+":  ");
            for (int j=0; j<n; j++){
                System.out.print((arr[i][j] = i ^ j)+" ");
            }
            System.out.println();
        }
    }
}