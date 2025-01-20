/*
* Name:           Steven Mecklenburg
*
* Course:         CS-12, Spring 2024

* Date:           1/28/2024
*
* File Name:      HelloWorldSM.java
*
* Purpose:        Simple "Hello World" Java application to test the language
*/

public class HelloWorldSM {

    public static void main(String [] args) {
    
        printGreeting("Steven", "Mecklenburg");
    
    }
    
    private static void printGreeting(String firstName, String lastName)   {
    
        System.out.println("Hello " + firstName +
        
                           " " + lastName +
                           
                           ", good to have you in class");
                           
    }
    
}