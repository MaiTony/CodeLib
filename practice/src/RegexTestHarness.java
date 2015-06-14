import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (true) {

            Pattern pattern = 
            Pattern.compile(in.next());

            Matcher matcher = 
            pattern.matcher(in.next());

            boolean found = false;
            while (matcher.find()) {
                System.out.println(String.format("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end()));
                found = true;
            }
            if(!found){
                System.out.println("No match found.");
                break;
            }
        }
        in.close();
    }
}