/*
*Name:           Steven Mecklenburg
*
*Course:         CS-12, Spring 2024
*
*Date:           02/10/2024
*
*Filename:       OperatorsSM1.java
*
*Purpose:        To build a java application shell template 
*/

public class OperatorsSM1 {
 
    public static void main(String[] args) {
        //DATA:
         
        //Declare Variables
        
        int addedMonths;
        double salesPrice;
        double battingAvg;
        
        //Declare and Initialize Variables
        
        int hits = 123;
        int atBats = 456;
        int item1Inventory = 100;
        int item2Inventory = 20;
        int deliveryAmount = 45;
        double sodaPrice = 1.00;
        double chipsPrice = 1.50;
        double sandwichPrice = 5.99;
        double totalLunchPrice;
        double radius = 3.4;
        double itemPrice = 15.99;
        double taxRate = 0.0725;
        
        //Declare and Initalize Constants
        
        final int monthsPerYear = 12;
        int childAgeMonths = 31;
        final double areaForPi = 3.14159;    
        
        //Computation:
        
        //Problem 1: Add up the total prices for Lunch
        totalLunchPrice = sandwichPrice + chipsPrice + sodaPrice;
        
        //Problem 2: Calculates the child's years in whole numbers
        int traditionalAgeYears = childAgeMonths / monthsPerYear;
        
        //Problem 3: Calculates the left over months after the whole number
        addedMonths = childAgeMonths % monthsPerYear;
        
        //Problem 4: Calculates the salesTax by multiplying itemPrice by taxRate
        double salesTax = itemPrice * taxRate;

        //Problem 5: Calculates the area for pi
        double area = areaForPi * Math.pow(radius, 2);
        
        //Problem 6: Calculates the battingAvg by diving hits by atBats. Declared double to get full average
        battingAvg = (double) hits / atBats;
        
        //Problem 7: Calculates new inventory after one sale
        item1Inventory--;
        
        //Problem 8: Calculates new inventory after Amazon Prime includes 45 additional item2s
        item2Inventory += deliveryAmount;
         
        //Output:
              
        //Output Display:
    
        System.out.println("The Price for Lunch is = \t\t\t\t\t" + "$" + totalLunchPrice);
        System.out.println("My child = \t\t\t\t\t\t\t\t\t" + traditionalAgeYears + " Years Old" + " and " + addedMonths + " Months Old");
        System.out.println("The Sales Tax on a new Target item is = \t" + "$" + salesTax);
        System.out.println("The Area for a circle is = \t\t\t\t\t" + area + " Meters Squared");
        System.out.println("The Batting Average is = \t\t\t\t\t" + battingAvg);
        System.out.println("Inventory for item 1 went from = \t\t\t" + "100 to " + item1Inventory);
        System.out.println("Inventory for item 2 went from = \t\t\t" + "20 to " + item2Inventory);
    
    }

}