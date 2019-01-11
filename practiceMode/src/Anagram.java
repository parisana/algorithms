import java.io.*;
import java.util.*;

public class Anagram {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        Map<Character, Integer> mapOfA=mapper(a);
        Map<Character, Integer> mapOfB=mapper(b);
        if(mapOfA.equals(mapOfB))
            return true;
        return false;
    }
    static Map<Character, Integer> mapper(String str){
        int lengthOfStr=str.length();
        str = str.toLowerCase();
        System.out.println(str);
        Integer value;
        Map<Character, Integer> tempMap= new HashMap<Character, Integer>();
        for(int i=0; i<lengthOfStr;i++){
            char c =str.charAt(i);
            value=tempMap.get(c);
            if(value!=null)
                tempMap.put(c, value+1);
            else
                tempMap.put(c, 1);
        }
        return tempMap;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        if(isAnagram(a, b))
            System.out.println("Anagrams");
        else
            System.out.println("Not Anagrams");

    }
}
