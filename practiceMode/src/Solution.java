import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int len = in.nextInt();
        //String s = in.next();
        String s="beabeefeab";
        countRepititions(s);

    }
    public static int countRepititions(String s){

        Set<Character> sSet=new HashSet<Character>();
        Set<Character> sTempSet=new HashSet<Character>();
        Pattern p;
        Matcher m;

        int[] countOfMatches=new int[s.length()];
        label1: for (int i=0; i<s.length();i++){      //beabeefeab
            char c=s.charAt(i);
            if (!sSet.contains(c)) {
                sSet.add(c);
                sTempSet.clear();  //clear the 2nd char array
                for (int j=i+1; j<s.length(); j++){
                    char tempChar=s.charAt(j);
                    if (!sTempSet.contains(tempChar)){
                        p=Pattern.compile("("+Pattern.quote(Character.toString(c))+")("+Pattern.quote(Character.toString(tempChar))+")(?:\\1|(?!(\1a-z)?(?!\2)?)*\\b)");
                        m=p.matcher(s.substring(i));
                        while (m.find()){
                            System.out.print(m.group());
                        }
                        System.out.println();
                    }
                }
                System.out.println("*****************************");
            }

        }
        for (int i=0; i< countOfMatches.length; i++)
            System.out.println("%%$%%:"+i+" "+countOfMatches[i]);
        return  0;
    }
}
