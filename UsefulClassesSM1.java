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
import java.util.Random;

public class UsefulClassesSM1 {

    public static void main(String[] args) {
        //DATA:
        
        Scanner input = new Scanner(System.in);
        Random number = new Random(); 
        
        //Declare variables
        
        int min;
        int max;
        int randNum1;
        int randNum2;
        int randNum3;
        int randNum4;
        int smallest;
        int largest;
        double firstSide;
        double secondSide;
        double hypotenuse;
        double radius;
        double volume;

        //Output display:
        
        //Prompts user input for min and max values
        //Prints min and max values in the code terminal
        System.out.print("Enter minimum random number bound: ");
        min = input.nextInt();
        System.out.print("Enter maximum random number bound: ");
        max = input.nextInt();
        
        randNum1 = number.nextInt(max - min + 1) + min;
        randNum2 = number.nextInt(max - min + 1) + min;
        randNum3 = number.nextInt(max - min + 1) + min;
        randNum4 = number.nextInt(max - min + 1) + min;
        
        //Problem 1
        //Displays the range of the function with the user inputs min and max values
        //Generates 4 random numbers from the range
        System.out.print("\n1) " + "range: " + min + "-" + max + "\t");
        System.out.print("random #'s:" + " " + randNum1 + " " + randNum2 + " " +  randNum3 + " " +  randNum4 + "\n");
        
        smallest = Math.min(randNum1, randNum2);
        smallest = Math.min(randNum3, randNum4);
        largest = Math.max(randNum1, randNum2);
        largest = Math.max(randNum3, randNum4);
        
        //Problem 2
        //Displays smallest and largest numbers from the 4 randomly generated numbers
        System.out.print("\n2a) " + "smallest random number: " + smallest);
        System.out.print("\n2b) " + "largest random number: " + largest + "\n");
        
        //Prompts user for a and b value of a triangle
        //Takes user input and puts value in firstSide and secondSide
        //Squares both value and places value in hypotenuse
        //Square roots hypotenuse in the end using static Math methods
        
        //Problem 3
        System.out.print("\nEnter triangle side a: ");
        firstSide = input.nextDouble();
        System.out.print("Enter triangle side b: ");
        secondSide = input.nextDouble();
        System.out.print("\n3) " + "sides: " + "a = " + firstSide + "\t\tb = " + secondSide + "\n");
        firstSide = Math.pow(firstSide, 2);
        secondSide = Math.pow(secondSide, 2);
        hypotenuse = firstSide + secondSide;
        hypotenuse = Math.sqrt(hypotenuse);
        System.out.print("   hyp: " + "  h = " + hypotenuse + " (exact)");
        System.out.print("\n\t\t" + "  h = " + Math.round(hypotenuse) + " (rounded)" + "\n");
        
        //Problem 4
        //Prompts user for radius amount
        //Volume formula declared
        //Displays radius value from user input
        //Displays calculated volume
        System.out.print("\nEnter Sphere Radius: ");
        radius = input.nextDouble();    
        volume = (double) 4/3 * Math.PI * Math.pow(radius, 3);
        System.out.print("\n4) sphere r = " + radius + "\t\tsphere v = " + volume);

    }

}