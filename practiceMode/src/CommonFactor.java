/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;

public class CommonFactor {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
*/
        Scanner s = new Scanner(System.in);
        long num1 = s.nextLong();
        long num2 = s.nextLong();
        long theNum=Math.min(num1,num2);
        long theNum2=Math.max(num1, num2);
        int count=1;
        //long byTwo=theNum/2;
        if (theNum2%theNum == 0)
            count++;
        int i=1;
        while(theNum>1) {
            theNum=theNum/(2*i);
            if(theNum==0 || theNum==1)
                break;
            if (theNum2 % theNum==0)
                count++;
            System.out.println(theNum2+" "+theNum+" "+i++);
        }
        System.out.println(count);
    }
}
