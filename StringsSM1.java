/*
*Name:           Steven Mecklenburg
*
*Course:         CS-12, Spring 2024
*
*Date:           03/09/2024
*
*Filename:       StringsSM1.java
*
*Purpose:        To construct a code of String related inputs that can solve problems
*/
import java.util.Scanner;

public class StringsSM1 {

    public static void main(String [] args) {
        //DATA:
        
        Scanner input = new Scanner(System.in);
        
        //Declare variables 
        
        String myStr;
        int index;
        char characterIndex;
        String searchStr;  
        int searchIndex;     
        String subStr;
        String stringTrimmed; 
        char comma;   
        int firstComma;
        int secondComma;
        int thirdComma;
        String stringBetweenCommas;
        String trimmed; 
        
        //Initialize Variables
        
        index = 0;
        comma = ',';    

        //Output display:
        
        //Given input that includes several words separated by at least 3 commas. Asks user to input the desired text
        System.out.print("1) " + "Please Enter a Couple Words that are Separated by at Least 3 Commas \nEnter Here: ");
        myStr = input.nextLine();
        System.out.println("\ntext is: \t\t\t\t\t\t\t\t\t\t" +  myStr);   
        
        //Provides the length of the text in myStr. Answer alligned with the other answer
        System.out.println("\n2) " + "length of text is: " + "\t\t\t\t\t\t\t" + myStr.length());
        
        //Gives the first and last characters of the String myStr. Still need to find a way to show the difference of white spaces in question 13
        System.out.println("3) " + "first and last characters of text are: " + "\t\t" + myStr.charAt(0) + " and " + myStr.charAt(myStr.length()-1));
        
        //Takes the given String from myStr and capitalizes all of it
        System.out.println("\n4a) " + "text all caps: " + "\t\t\t\t\t\t\t\t" + myStr.toUpperCase());        
        //Prints the original String value from myStr and shows that the original hasn't changed
        System.out.println("4b) " + "text is unchanged" + "\t\t\t\t\t\t\t" + myStr);
        
        //Takes the given String from myStr and removes all capitalization
        System.out.println("5a) " + "text as lower case: " + "\t\t\t\t\t\t" + myStr.toLowerCase());        
        //Prints the original String value from myStr and shows that the original hasn't changed
        System.out.println("5b) " + "text is unchanged: " + "\t\t\t\t\t\t\t" + myStr);
        
        //Prompts the user for a numeric input to achieve a numeric output on where that letter is in the String. Still need to figure this one out
        System.out.print("Character at which text location? > ");
        index = input.nextInt();
        input.nextLine();
        characterIndex = myStr.charAt(index); 
        System.out.println("6 ) " + "character at text index " + index + "\t\t\t\t\t" + characterIndex);
        
        //Searches the String value myStr for the word and prints what index it's in
        System.out.print("Search pattern to locate? >");
        searchStr = input.nextLine();
        index = myStr.indexOf(searchStr);
        searchIndex = myStr.indexOf(searchStr);
        System.out.println("7) " + "search pattern" + searchStr + "is located at text index: " + searchIndex);
                
        //Looks through the String value myStr for the last word and displays it in the code terminal
        subStr = myStr.substring(searchIndex);
        System.out.println("8) " + "search pattern to the end is:" + "\t\t\t\t" + subStr);
            
        //Finds the location of the first comma and displays it in code terminal
        firstComma = myStr.indexOf(',');
        System.out.println("\n9) " + "first comma is at index: " + "\t\t\t\t\t" + firstComma);
        
        //Finds the location of the second comma and displays it in code terminal
        secondComma = myStr.indexOf(',', + firstComma + 1);
        System.out.println("10) " + "second comma is at index: " + "\t\t\t\t\t" + secondComma);
        
        //Finds the location of the third comma and displays it in the code terminal
        thirdComma = myStr.indexOf(',', + secondComma + 1);
        System.out.println("11) " + "third comma is at index: " + "\t\t\t\t\t" + thirdComma);
        
        //Looks for the value inbetween the 2nd and 3rd comma and displays the message along with it's length in the code terminal
        stringBetweenCommas = myStr.substring(secondComma + 1, thirdComma);
        System.out.println("\n12) " + "between commas 2 and 3 is:" + "\t\t\t\t\t" + stringBetweenCommas + " Length: " + stringBetweenCommas.length());
        //Trims the white spaces off of the word inbetween the 2nd and 3rd comma and displays it along with it's length in the code terminal
        stringTrimmed = stringBetweenCommas.trim();
        System.out.println("13) " + "between commas 2 and 3 is: " + "\t\t\t\t\t" + stringTrimmed + " and " + stringTrimmed.length());
        
    }

}