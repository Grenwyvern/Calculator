/*
*Name:           Steven Mecklenburg
*
*Course:         CS-13, Summer 2024
*
*Date:           07/4/2024
*
*Filename:       Bank.java
*
*Purpose:        Displays menu and prompts user for commands which correponds to calculations
*/
import java.util.Scanner;
public class Employee {
    public String name;
    public static int noOfEmployees;
    
    public Employee(String name) {
        this.name = name;
    }
    
    {
        noOfEmployees++;
    }    
    
    public void computePay() {
    }
}

class HourlyEmployee extends Employee {
    int hrlyWage;
    
    public HourlyEmployee(int hrlyWage, String name) {
        super(name);      
    }
    
    public String getName() {
        return name;
    }
    
    public void setName() {
        this.name = name;
    }
    
    public int getHrlyWage() {
        return hrlyWage;
    }
    
    public void setHrlyWage() {
        this.hrlyWage = hrlyWage;
    }
    
    public void computePay() {
        if (true) {
        }
        
        else {
        }
    }
}

class SalariedEmployee {
}

class Driver {
    public static void main (String [] args) {
        char userSelection = (char)menu();
        boolean quit = false;
        do {
            switch(userSelection) {
                case 'N':
                    System.out.println("Enter name of new employee");
                    break;
                
                case 'C':
                    break;
                
                case 'R':
                    break;
                
                case 'L':
                    break;
                
                default: 
                    System.out.println("Invalid command. Please try again");
                }
           }
           while(!quit);
    }   
    static int menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("N: New employee");
        System.out.println("C: Compute weekly paychecks");
        System.out.println("R: Raise wages for everyone");
        System.out.println("L: List all employees' hourly wage");
        System.out.println("Q: Quit");
        
        System.out.print("Enter command: ");   
        
        char choice = input.next().toUpperCase().charAt(0);
        return (int) choice;
    }
}