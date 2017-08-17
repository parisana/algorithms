/*
* given a string input eg: beabeefeab
*find the longest possible t consisting of 2 distinct alternating characters
* eg o/p: 5 for the string babab.
* */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoCharactersRegex {

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

        int[] countOfMatches=new int[s.length()];
        label1: for (int i=0; i<s.length();i++){      //beabeefeab
            char c=s.charAt(i);
            if (!sSet.contains(c)) {
                sSet.add(c);
                System.out.println(sSet);
                for(int j=i+1; j<s.length(); j++){
                    char c2=s.charAt(j);
                    if(!sTempSet.contains(s.charAt(j))){
                        sTempSet.add(c2);
                        int countOfGroups=0;
                        Pattern p=Pattern.compile("("+Pattern.quote(Character.toString(c))+")("+Pattern.quote(Character.toString(c2))+"|(?!\1a-z)*\\b)(?:(\\1(?!\1a-z)*\\b)?|(\\1(?!\1a-z)*\\2)*)");
                        Matcher m=p.matcher(s);

                        while (m.find()){
                            System.out.print("\n##Start "+m.start()+" end: "+m.end()+" group0: "+m.group(0)+" groupcount: "+m.groupCount()+" **** ");
                            countOfGroups=m.groupCount();
                            if(m.end()==s.length()){
                                continue label1;
                            }
                        }
                        //countOfMatches[Character.valueOf(c)-97]=countOfGroups;
                    }else{
                        //set count of the combination to -1
                    }
                }
                sTempSet.clear();
            }

        }
        for (int i=0; i< countOfMatches.length; i++)
            System.out.println("%%$%%:"+i+" "+countOfMatches[i]);
        return  0;
    }
}
