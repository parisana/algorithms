import java.util.Scanner;

/**
 * Created by pari on 12/8/17.
 */
public class RegexIpCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}
//Write your code here
class MyRegex{
    String pattern="(?:([0-1]?[0-9]{1,2}\\.)|(2[0-4][0-9]\\.)|(25[0-5]\\.)){3}" +
            "(?:([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))";
}
