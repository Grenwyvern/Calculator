/*
* Name:           Steven Mecklenburg
*
* Course:         CS-12, Spring 2024

* Date:           02/06/2024
*
* File Name:      HelloAgainSM.java
*
* Purpose:        Refactored Hello World Java application, now uses a utility class.
*/

public class HelloAgainSM1 {

    public static void main(String [] args) {
    
        // create a new object, one specific instance of the class
        HelloSM1 person = new HelloSM1();
        
        // print greeting for thed default person
        person.printGreeting();
        
        // update the object, and print the new greeting
        person.setFirstName("Steven");
        person.setLastName("Mecklenburg");
        person.printGreeting();
        
    }
    
}