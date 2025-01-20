/*
*Name:           Steven Mecklenburg
*
*Course:         CS-13, Summer 2024
*
*Date:           06/14/2024
*
*Filename:       MenuSM.java
*
*Purpose:        To develop a menu system featuring various clickable options, with each selection leading to their appropriate calculations
*/

import java.util.Scanner;
public class MenuSM {

             static Scanner input = new Scanner(System.in);
    
             public static void main (String [] args) {
        
                                //Data and object declarations
                                Menu menu = new Menu();
                                char choice;
        
                                do {
                                    //Displays menu to user
                                    menu.display();
                                    choice = input.next().toUpperCase().charAt(0); 
        
                                    switch (choice) {
            
                                                    case 'H':
                                                    hypotenuse();
                                                    break;
                                        
                                                    case 'G':
                                                    gravity();
                                                    break;
                    
                                                    case 'Q':
                                                    System.out.println("Command terminated. Goodbye!");
                                                    break;
                    
                                                    default:
                                                    System.out.println("Error: Unrecognized option '" + choice + "', please try again");
                                                    }       
                                    }
                                //Reprompts user until they say a "h" or "g" or "q"  
                                while(Character.toUpperCase(choice)!= 'Q');             
             }
    
             public static void hypotenuse() {
        
                                //Declarations
                                double sideA;
                                double sideB;
                                double sideC;
                                boolean valid;
        
                                //Ensuring user input is between 2 and 20. Will reprompt if not
                                do {
                                    valid = true;
                                    System.out.print("Please enter a length between 2 and 20 for Side A: ");
                                    sideA = input.nextDouble();
                                    if ((sideA < 2) || (sideA > 20)) {
                                                                     System.out.println("Oops! Value " + sideA + " isn't between 2 and 20. Please try again");
                                                                     System.out.println();
                                                                     valid = false;
                                   }
                                //Reprompts Do While loop until valid input is given
                                }while(!valid);
                                do {
                                    valid = true;
                                    System.out.print("Please enter a length between 2 and 20 for Side B: ");
                                    sideB = input.nextDouble();
                                    if ((sideB < 2) || (sideB > 20)) {
                                                                     System.out.println();
                                                                     System.out.println("Oops! Value " + sideB + " isn't between 2 and 20. Please try again");
                                                                     valid = false;
                                   }
                                //Reprompts Do While loop until valid input is given
                                }while(!valid);
        
                                //Hypotenuse calculation after ensuring user input is between 2 and 20  
                                sideA = Math.pow(sideA, 2);
                                sideB = Math.pow(sideB, 2);
                                sideC = sideA + sideB;
                                sideC = Math.sqrt(sideC);
                                System.out.println("Your side c value is: " + sideC);
             }
    
             public static void gravity() {
        
                                //Declarations
                                double earthWeight;
                                boolean valid;
                                double moonGravity;
    
                                do {
                                   valid = true;
                                   System.out.print("Please enter your weight between 100 - 300 for earth: ");
                                   earthWeight = input.nextDouble();
                                   if ((earthWeight < 100) || (earthWeight > 300)) {
                                                                                   System.out.println("Oops! " + earthWeight + " is not between the required limit");
                                                                                   System.out.println();
                                                                                   valid = false;
                                   }
                                //Reprompts Do While loop until valid input is given
                                }while(!valid);
                  
                                //Calculate and display gravity
                                moonGravity = earthWeight * 0.17;
                                System.out.println("Your weight on the moon is " + moonGravity);
            
             }
}
class Menu {
      
      //Data Declarations
      String menu;
      
      public Menu() {
             menu = "-------------------\n" +
                    "   Menu Display \n" +
                    "-------------------\n" +
                    "1) Hypotenuse   [H]\n" + 
                    "2) Gravity      [G]\n" + 
                    "3) Quit         [Q]\n";
      }
      
      //Dispplay method for the menu. Placed here so it can be called up top
      public void display() {
                  System.out.print(menu);
      }
}