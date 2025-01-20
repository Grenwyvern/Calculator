/*
*Name:           Steven Mecklenburg
*
*Course:         CS-12, Spring 2024
*
*Date:           03/26/2024
*
*Filename:       IOFormatsSM1 
*
*Purpose:        To construct an application that contains input and output GUI dialogs
*/

//Import Utilities
import javax.swing.JOptionPane;

public class IOFormatsSM1 {

    public static void main(String[] args) {
        //DATA:
        
        String inputStr;
        String outputStr;
         
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
        
        //Declare and Initalize Constants
        
        final int MONTHS_PER_YEAR = 12;
        final double PI = 3.14159;
        final double TAX_RATE = 0.0725;   
        
        //Initialize Variables with User Inputs
        sandwichPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "1) Enter the price for a sandwich "));
        chipsPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "1) Please enter the price for chips "));
        sodaPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "1) Enter the price for a soda "));
        
        childAgeMonths = Integer.parseInt(JOptionPane.showInputDialog(null, "2/3) Enter age in [months] "));
        addedMonths = Integer.parseInt(JOptionPane.showInputDialog(null, "2/3) Enter added months for the child "));
        
        itemPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "4) Enter retail price of item "));
        
        radius = Double.parseDouble(JOptionPane.showInputDialog(null, "5) Enter circle radius [m] "));
        
        hits = Integer.parseInt(JOptionPane.showInputDialog(null, "6) Enter number of hits "));
        atBats = Integer.parseInt(JOptionPane.showInputDialog(null, "6) Enter number of atBats "));
        
        item1Inventory = Integer.parseInt(JOptionPane.showInputDialog(null, "7) Enter starting first item quantity "));
        item2Inventory = Integer.parseInt(JOptionPane.showInputDialog(null, "8) Enter starting second item quantity "));
        deliveryAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "8) Enter second item delivery quantity "));
        
        //Computation and Output Display:
        
        //Problem 1: Add up the total prices for Lunch
        totalLunchPrice = sandwichPrice + chipsPrice + sodaPrice;
        outputStr = String.format("1) Lunch price before tax is: $%.2f\n", totalLunchPrice);
        JOptionPane.showMessageDialog(null, outputStr);
        
        //Problem 2 & 3: Calculates the child's years and remaining months
        traditionalAgeYears = childAgeMonths / MONTHS_PER_YEAR;
        addedMonths = childAgeMonths % MONTHS_PER_YEAR;
        outputStr = String.format("2/3) %d month old child = %d Years %d Months Old\n", childAgeMonths, traditionalAgeYears, addedMonths);
        JOptionPane.showMessageDialog(null, outputStr);
        
        //Problem 4: Calculates the salesTax by multiplying itemPrice by taxRate
        salesTax = itemPrice * TAX_RATE;
        outputStr = String.format("4) Tax on item is: $%.2f\n", salesTax);
        JOptionPane.showMessageDialog(null, outputStr);
        
        //Problem 5: Calculates the area for pi
        area = PI * Math.pow(radius, 2);
        System.out.printf("5) r=%.1f circle area [m^2] = %.4f m^2\n", radius, area);
        
        //Problem 6: Calculates the battingAvg by diving hits by atBats.
        battingAvg = (double) hits / atBats;
        System.out.printf("6) Batting average from given user input = %.3f\n", battingAvg);
        
        //Problem 7: Calculates new inventory after one sale
        System.out.printf("7a) Starting Inventory for item one is: %d\n", item1Inventory);
        item1Inventory--;
        System.out.printf("7b) New Inventory for item one is: %d\n", item1Inventory);
        
        //Problem 8: Calculates new inventory after Amazon Prime includes 45 additional item2s
        System.out.printf("8a) Starting Inventory for item two is: %d\n", item2Inventory);
        item2Inventory += deliveryAmount;
        System.out.printf("8b) New Inventory for item two is: %d\n", item2Inventory);
    
    }

}