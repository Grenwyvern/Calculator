import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt for a string
        System.out.println("Enter a string:");
        String myStr = input.nextLine();

        // 1) Print the input string
        System.out.println("1) Input String: " + myStr);

        // 2) Print the length of myStr
        System.out.println("2) Length of myStr: " + myStr.length());

        // 3) Print the first and last characters of myStr
        System.out.println("3) First character: " + myStr.charAt(0));
        System.out.println("   Last character: " + myStr.charAt(myStr.length() - 1));

        // 4) Print myStr in all uppercase without altering it
        String upperCaseStr = myStr.toUpperCase();
        System.out.println("4) Uppercase myStr: " + upperCaseStr);
        System.out.println("   Original myStr: " + myStr);

        // 5) Print myStr in all lowercase without altering it
        String lowerCaseStr = myStr.toLowerCase();
        System.out.println("5) Lowercase myStr: " + lowerCaseStr);
        System.out.println("   Original myStr: " + myStr);

        // 6) Prompt for a specific index and print the character at that index
        System.out.println("Enter an index to retrieve character:");
        int index = input.nextInt();
        input.nextLine(); // Consume newline character
        char characterAtIndex = myStr.charAt(index);
        System.out.println("6) Character at index " + index + ": " + characterAtIndex);

        // 7) Prompt for a search string and print its index
        System.out.println("Enter a search string:");
        String searchString = input.nextLine();
        int searchIndex = myStr.indexOf(searchString);
        System.out.println("7) Index of '" + searchString + "': " + searchIndex);

        // 8) Print substring from search index to end of myStr
        String substringFromSearch = myStr.substring(searchIndex);
        System.out.println("8) Substring from search string to end: " + substringFromSearch);

        // 9) Find index of first comma
        int firstCommaIndex = myStr.indexOf(',');
        System.out.println("9) Index of first comma: " + firstCommaIndex);

        // 10) Find index of second comma
        int secondCommaIndex = myStr.indexOf(',', firstCommaIndex + 1);
        System.out.println("10) Index of second comma: " + secondCommaIndex);

        // 11) Find index of third comma
        int thirdCommaIndex = myStr.indexOf(',', secondCommaIndex + 1);
        System.out.println("11) Index of third comma: " + thirdCommaIndex);

        // 12) Extract substring between second and third commas
        String betweenCommas = myStr.substring(secondCommaIndex + 1, thirdCommaIndex);
        System.out.println("12) Substring between 2nd and 3rd commas: " + betweenCommas);
        System.out.println("    Length of substring: " + betweenCommas.length());

        // 13) Trim whitespace from the extracted substring
        String trimmedSubstring = betweenCommas.trim();
        System.out.println("13) Trimmed substring: " + trimmedSubstring);
        System.out.println("    Length of trimmed substring: " + trimmedSubstring.length());

        input.close();
    }
}