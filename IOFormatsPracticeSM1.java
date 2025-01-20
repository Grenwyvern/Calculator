/*
*Name:           Steven Mecklenburg
*
*Course:         CS-12, Spring 2024
*
*Date:           02/10/2024
*
*Filename:       IOFormatsPracticeSM1
*
*Purpose:        Practice copy for original code
*/

//Import Utilities
import java.util.Scanner;
import javax.swing.JOptionPane;

public class IOFormatsPracticeSM1 {

    public static void main(String[] args) {
        //DATA:
         
        Scanner input = new Scanner(System.in);
         
        //Declare Variables
        
        double sandwichPrice;
        double chipsPrice;
        double sodaPrice;
        double totalLunchPrice;
        int traditionalAgeYears;
        int childAgeMonths;
        int addedMonths;
        double salesTax;
        double itemPrice;
        double area;
        double radius;
        int hits;
        int atBats;
        double battingAvg;
        int item1Inventory;
        int item2Inventory;
        int deliveryAmount;
        String inputStr;
        String outputStr;
        
        //Initialize Variables
        
        
        //Declare and Initalize Constants
        
        final int MONTHS_PER_YEAR = 12;
        final double PI = 3.14159;
        final double TAX_RATE = 0.0725;   
        
        //Initialize Variables with User Inputs
        sandwichPrice = Double.parseDouble ( JOptionPane.showInputDialog(null, "1) Enter the price for a sandwich ") );
        chipsPrice = Double.parseDouble ( JOptionPane.showInputDialog(null, "1) Please enter the price for chips ") );
        sodaPrice = Double.parseDouble ( JOptionPane.showInputDialog(null, "1) Enter the price for a soda ") );
        
        childAgeMonths = Integer.parseInt ( JOptionPane.showInputDialog(null, "2/3) Enter age in [months] ") );
        addedMonths = Integer.parseInt ( JOptionPane.showInputDialog(null, "2/3) Enter added months for the child ") );
        
        System.out.print("Enter retail price of item ");
        itemPrice = Double.parseDouble ( JOptionPane.showInputDialog(null, "4) Enter retail price of item ") );
        
        System.out.printf("Enter circle radius [m] ");
        radius = input.nextDouble();
        
        System.out.printf("Enter number of hits ");
        hits = input.nextInt();       
        System.out.printf("Enter number of atBats ");
        atBats = input.nextInt();
        
        System.out.printf("Enter starting first item quantity ");
        item1Inventory = input.nextInt();
        System.out.printf("Enter starting second item quantity ");
        item2Inventory = input.nextInt();       
        System.out.printf("Enter second item delivery quantity ");
        deliveryAmount = input.nextInt(); 
        System.out.println();               
        
        //Computation and Output Display:
        
        //Problem 1: Add up the total prices for Lunch
        totalLunchPrice = sandwichPrice + chipsPrice + sodaPrice;
        System.out.println("Lunch price before tax is = \t\t\t\t\t" + "$" + totalLunchPrice + "\n");
        
        //Problem 2: Calculates the child's years in whole numbers
        traditionalAgeYears = childAgeMonths / MONTHS_PER_YEAR;
        System.out.println(childAgeMonths + " month old child in whole years = \t\t\t\t\t\t\t\t\t" + traditionalAgeYears + " Years Old" + "\n");
        
        //Problem 3: Calculates the left over months after the whole number
        addedMonths = childAgeMonths % MONTHS_PER_YEAR;
        System.out.println(childAgeMonths + " month old in added months = \t\t\t\t\t\t\t\t\t" + traditionalAgeYears + " Years" + " and " + addedMonths + " Months Old" + "\n");
        
        //Problem 4: Calculates the salesTax by multiplying itemPrice by taxRate
        salesTax = itemPrice * TAX_RATE;
        System.out.println("Tax on item is = \t" + "$" + salesTax + "\n");

        //Problem 5: Calculates the area for pi
        area = PI * Math.pow(radius, 2);
        System.out.println("r= " + PI + " circle area [m^2] = \t\t\t\t\t" + area + " m^2" + "\n");
        
        //Problem 6: Calculates the battingAvg by diving hits by atBats. Declared double to get full average
        battingAvg = (double) hits / atBats;
        System.out.println("batting avg from given user input = \t\t\t\t\t" + battingAvg + "\n");
        
        //Problem 7: Calculates new inventory after one sale
        System.out.println("Starting Inventory for item one is = \t\t\t\t" + item1Inventory + "\n");
        item1Inventory--;
        System.out.println("New Inventory for item one is = \t\t\t\t" + item1Inventory + "\n");
        
        //Problem 8: Calculates new inventory after Amazon Prime includes 45 additional item2s
        System.out.println("Starting Inventory for item two is = \t\t\t\t" + item2Inventory + "\n");
        item2Inventory += deliveryAmount;
        System.out.println("New Inventory for item two is = \t\t\t\t" + item2Inventory + "\n");
    
    }

}