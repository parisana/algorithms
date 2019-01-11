package algorithms;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestClass {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println(32-Integer.numberOfLeadingZeros(3));

    }
    private  static long findCombo(int n, int r){
        if(r<1){
            return 0;
        }
        long result1=(combination(n, r));
        long result2=findCombo(n, r-1);
        System.out.println("result1:"+result1+" result2: "+result2);
        return result1+result2;
    }
    private static long combination(int n, int r){
        System.out.println("combination of: n-"+n+" over r-"+ r );
        long result;
        if (n==r || r<=0)
            result=1;
        else
            result=(permutation(n,n-r)/(fact(r)));
        System.out.println("result:"+result);
        return result;
    }

    private static long permutation(int n, int r) {
        if(r>=n){
            return 1;
        }
        System.out.println("permutating : n-"+n+"over r-"+r);
        long result=n*(permutation(n-1, r));

        return result;
    }

    private static long fact(int n){
        if(n<=1)
            return 1;
        return n*(fact(n-1));
    }
}
