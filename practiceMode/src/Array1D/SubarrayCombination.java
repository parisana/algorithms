package Array1D;
//Prints even length subarrays of a given length.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class SubarrayCombination{
    public static void main(String args[] ) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int t=Integer.parseInt(s);
        while(t-->0){
            s= br.readLine();
            int n=Integer.parseInt(s);

            int[] arrA = new int[n];
            s = br.readLine();
            String[] stringsArray = s.split(" ");
            //System.out.println(stringsArray.length+"length");
            for (int i=0; i<stringsArray.length; i++){
                arrA[i]= Integer.parseInt(stringsArray[i]);
            }
            int[] count= new int[n];
            Arrays.fill(count, 1);
            int[] output= new int[n];
            System.out.println();
            combination(arrA, count,0, output,0);
        }

    }

    private static void combination(int[] arrA, int[] count, int pos, int[] output, int lengthOfOutput) {
        //output(output,lengthOfOutput);
        if (lengthOfOutput>1){
            output(output,lengthOfOutput);
        }
        for (int i=pos; i<arrA.length; i++){
            if (count[i]==0)
                continue;
            output[lengthOfOutput]=arrA[i];
            //System.out.print(arrA[i]+" * ");
            count[i]--;
            combination(arrA, count,i,output,lengthOfOutput+1);
            count[i]++;
        }
    }
    private static void output(int[] output, int len) {
        for (int i=0; i<len;i++){
            System.out.print(output[i]+" ");
        }
        System.out.println();
    }
}