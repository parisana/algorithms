/*
* For each character in english alphabet form ordered 2 pairs
* eg {{a,b}, {a,c},....,{y,z}}
* */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RegexTwoCharArrayNoRepition {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int len = in.nextInt();
        //String s = in.next();
        String s="aabaebe";
        Long ct=System.currentTimeMillis();
        char[][] allCharArray=buildCharCombinationArray(s);
        System.out.println(System.currentTimeMillis()-ct);
    }

    private static char[][] buildCharCombinationArray(String s) {

        char[][] comboCharArray = new char[327][3];
        String aToZ = "abcdefghijklmnopqrstuvwxyz";
        int count = 0;
        int currentPosition=1, nextposition=1,x=0;
        while (count<aToZ.length()){
            currentPosition=nextposition;
            while(currentPosition<26){
                comboCharArray[x][1]=aToZ.charAt(count);
                comboCharArray[x][2]=aToZ.charAt(currentPosition);
                currentPosition++;
                x++;
            }
            nextposition++;
            count++;
        }
        for (int i=0; i<325; i++){
            for (int j=0; j<3; j++) {
                System.out.print(comboCharArray[i][j]+"  ");
            }
            System.out.println();
        }
        return comboCharArray;
    }
    String countRepitition(String s,char[][] allCharArray){
        Pattern p;
        Matcher m;
        //for each pair memoize in the char array
        for (int i=0; i<allCharArray.length; i++){
            StringBuilder tempStrbuilder= new StringBuilder("");
            for (int j=1; j<3; j++){
                tempStrbuilder.append(allCharArray[i][j]);
            }
            p= Pattern.compile(tempStrbuilder.toString());
            m= p.matcher(s);
            while (m.find()) {
                allCharArray[i][0]++;
            }

        }
        return "";
    }
}
