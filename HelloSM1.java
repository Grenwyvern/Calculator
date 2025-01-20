/*
* Name:           Steven Mecklenburg
*
* Course:         CS-12, Spring 2024

* Date:           02/06/2024
*
* File Name:      HelloAgainSM1.java
*
* Purpose:        Utility class component for Hello World
*/

public class HelloSM1 {

    // instance variables: what the class IS
    private String firstName;
    private String lastName;
      
    // constructor: initializes the class
    public HelloSM1() {
        firstName = "Anonymous";
        lastName = "Students";
    }
      
    // methods: what a class DOES
      
    // print a greeting given first and last names
    public void printGreeting() {
        System.out.println("Hello " + firstName +
                           " " + lastName +
                           ", Good to have you in class.");
    }
      
    // update the first name
    public void setFirstName(String first) {
        firstName = first;
    }
      
    // update the last name
    public void setLastName(String last) {
        lastName = last;
    }

}