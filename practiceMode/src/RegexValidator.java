import java.util.Scanner;
import java.util.regex.*;

public class RegexValidator {
    public static void main(String[] args){
        Pattern p;
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        Boolean[] boolArray= new Boolean[testCases];
        int i=0;

        a:while(testCases>0){
            String pattern = in.nextLine();
            //Write your code
            try {
                Pattern.compile(pattern);
                boolArray[i]=true;
            }catch(Exception e) {
                boolArray[i]=false;
            }finally {
                testCases--;
                i++;
                continue a;

            }
        }
        for(Boolean bool: boolArray){
            if (bool) {
                System.out.println("Valid");
            }else
                System.out.println("Invalid");
        }
    }
}
