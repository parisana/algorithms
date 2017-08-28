import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        encryptThisString(new StringBuilder(s), k);
    }
    public static void encryptThisString(StringBuilder str, int k){
        int tempCharValue;
        for (int i=0; i<str.length();i++){
            int charValue=Character.valueOf(str.charAt(i));
            tempCharValue=0;
            if (charValue>=65 && charValue<=90){
                tempCharValue=charValue+(k%26);
                if (tempCharValue>90)
                    tempCharValue=(tempCharValue%91)+65;
            }else if(charValue>=97 && charValue<=122){
                tempCharValue=charValue+(k%26);
                if (tempCharValue>122)
                    tempCharValue=(tempCharValue%123)+97;
            }else
                tempCharValue=charValue;
            System.out.print((char)tempCharValue);
        }
        return;
    }
}
