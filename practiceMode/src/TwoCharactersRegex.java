import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoCharactersRegex {
    private static int[][] intArray;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        if (s.length()<=1)
            System.out.println(0);
        else {
            int finalStringLength = countRepitions(s);
            if (finalStringLength < 0)
                finalStringLength = 0;
            System.out.println(finalStringLength);
        }
    }
    static int countRepitions(String s){
        int[] finalArray=new int[26];
        intArray=new int[26][26];
        char[][] countArray= new char[26][26];
        for (int i=0; i<s.length(); i++){
            char temp=s.charAt(i);
            int intValOfChar=(int)temp-97;
            for (int j=0; j<26; j++){
                if (countArray[intValOfChar][j]=='*') {
                    continue;
                }if (countArray[intValOfChar][j]==temp) {
                    countArray[intValOfChar][j]='*';
                    countArray[j][intValOfChar]='*';
                    counter(intArray, intValOfChar, j, false);
                    continue;
                }
                countArray[j][intValOfChar]=temp;
                countArray[intValOfChar][j]=temp;
                counter(intArray, intValOfChar, j, true);
            }
        }
        for (int i=0; i<26;i++){
            Arrays.sort(intArray[i]);
        }
        for (int j=0; j<26;j++){
            //System.out.print(intArray[j][25]+"\t");
            finalArray[j]=intArray[j][25];
        }
        Arrays.sort(finalArray);
        //System.out.println(finalArray[25]);

        return finalArray[25];
    }

    private static void counter(int[][] intArray, int row, int column, boolean flag) {
        if (intArray[row][column]==-1)
            return;
        if(flag==true){
            intArray[row][column]+=1;
            intArray[column][row]+=1;
        }else {
            intArray[row][column] = -1;
            intArray[column][row] = -1;
        }
    }
}
