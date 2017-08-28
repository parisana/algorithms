/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import for Scanner and other utility classes
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/
        //BufferedReader

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int testCases=Integer.parseInt(line);
        if (testCases<1 || testCases>5)
            throw new InputMismatchException();
        int size=testCases;
        int count=0;
        int[] resultArray= new int[size];
        while (testCases>0){
            String tokens[] = (br.readLine()).split("\\s");
            int m=Integer.valueOf(tokens[1]);
            //System.out.println(n+"\t"+m);
            int temp=m;

            String inputTokens[] = br.readLine().split("\\s");
            for (String token: inputTokens){
                int tmpToken=Integer.valueOf(token);
                //System.out.println(tmpToken);
                if (tmpToken<temp)
                    temp=tmpToken;
            }
            System.out.println(m-temp);
            //resultArray[count]=m;
            testCases--;
            count++;
        }
        /*for (int i=0; i< size; i++)
            System.out.println(resultArray[i]);*/


        /*Scanner scanner=new Scanner(System.in);
        int testCases= scanner.nextInt();
        if (testCases<1 || testCases>5)
            throw new InputMismatchException();
        int[] resultArray=new int[testCases];
        int i=0;
        while (testCases>0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int tmp=m;
            for (int j=0; j< n; j++){
                int cur = scanner.nextInt();
                if (cur<tmp)
                    tmp=cur;
            }
            resultArray[i]=m-tmp;
            testCases--;
            i++;
        }

        for (int k=0; k<resultArray.length; k++)
            System.out.println(resultArray[k]);*/
    }
}
