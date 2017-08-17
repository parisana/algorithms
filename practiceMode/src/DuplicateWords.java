import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

    public static void main(String[] args) {

        String regex = "\\b(\\w+)\\b(\\W*\\1\\b)*"; //regex for duplicate words seperated by non-words.
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); //make the regex pattern case insensitive
        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                System.out.println(m.toString());
                System.out.println(m.start()+" Grp : "+m.group()+"**Gr0: "+m.group(0)+"**Gr1: "+m.group(1));
                input = input.replaceAll(m.group(), m.group(1));
                System.out.println(input);
            }

            // Prints the modified sentence.
            System.out.println("\n***********************************\n"+input);
        }

        in.close();
    }
}
// input: 1
//        this This this is IS iS dog Is
