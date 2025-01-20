/*
*Name:           Steven Mecklenburg
*
*Course:         CS-12, Spring 2024
*
*Date:           02/10/2024
*
*Filename:       MethodsSM1.java
*
*Purpose:        Create Conversion Methods
*/

import java.util.Scanner;

public class MethodsSM1 {

    public static void main(String[] args) {
    
        //DATA:
        
        Scanner input = new Scanner(System.in);
                
        //Declare Variables:
        
        double tempF;
        double tempC;
        double dailyTemp;
        
        double euros;
        double dollars;
        
        //User Input:
        System.out.print("Please enter today's temperature in Fahrenheit: ");
        tempF = input.nextInt();
        
        System.out.print("Please enter number of Dollars to convert: "); 
        dollars = input.nextInt();   
        
        //Computation:
        tempC = convertTemperature(tempF);
        euros = convertMoney(dollars);
        
        //Display:
        displayOutput(dollars, euros, tempF, tempC);

    } // end main
    //Declares fahrenheit to celsius temperature conversion. Set formula to double to avoid integer division
    public static double convertTemperature(double fahren) {
    
        //Declare Variables:
        double fahren1;
        
        //Declare Constants:
        final double celsius1;
        
        //Initialize Variables:
        fahren1 = fahren;     
        
        //Computation and Output:
        
        celsius1 = (double) 5/9 * (fahren1-32);
        
        return celsius1;
        
    } // end method
    
    //Declares dollars to euros money conversion. Conversion Rate is set as a constant
    public static double convertMoney(double currency) {
         
        //Declare Variables:
        double currencyEuro;
        double currencyDollars;
        
        //Initialize Variables:
        currencyDollars = currency;
        
        //Declare and Initialize Constants:
        final double CONVERSION_RATE = 0.915131;       
        
        //Computation and Output:
             
        currencyEuro = CONVERSION_RATE * currencyDollars;
        
        return currencyEuro;
        
    } //end method
    
    //Declares Output method for temperature and money conversion
    public static void displayOutput(double usd, double eur, double farTemp, double celsTemp) {
    
        System.out.println("The daily temperature is " + farTemp + " degrees in Fahrenheit and " + celsTemp + " degrees in celsius.");    
        System.out.println("$" + usd + " is equal to " + eur + " Euros.");
          
    
    }
            
}