package Array1D;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoSortedArraysInDescOrder {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        /*int t= sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            int[] intArr = new int[n];
            int[] count = new int[n];
            Arrays.fill(count,1);
            int[] output = new int[n];
            for (int i = 0; i < n; i++) {
                intArr[i] = sc.nextInt();
            }
            Arrays.parallelSort(intArr);
            combination(intArr, count, 0, output, 0, m);
            //combination(intArr, count, 0, output, 0, p);
        }*/
        int[] aArr={9,7,5,3};
        int[] bArr={8,6,4,2,1};
        int[] finalArr;
        finalArr=merge(aArr, bArr, 0, 0, 0);
        for (int e : finalArr){
            System.out.print(e+" ");
        }
    }
    private static int[] merge(int[] aArr, int[] bArr, int aPos, int bPos, int finalArrPos){
        int n= aArr.length;
        int m= bArr.length;
        int[] finalArr= new int[n+m];
        int numberOfIter=m+n;
        while (numberOfIter-->0){
            if (aPos<n-1 && aArr[aPos]>bArr[bPos]){
                finalArr[finalArrPos++]=aArr[aPos++];
            }
            if (bPos<m-1 && bArr[bPos]>aArr[aPos]){
                finalArr[finalArrPos++]=bArr[bPos++];
            }
        }
        //System.out.println(finalArrPos+" "+aPos+" "+bPos);
        while (aPos<n){
            finalArr[finalArrPos++]=aArr[aPos++];
        }while (bPos<m){
            finalArr[finalArrPos++]=bArr[bPos++];
        }
        return finalArr;
    }
}