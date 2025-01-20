/*
*Name:           Steven Mecklenburg
*
*Course:         CS-13, Summer 2024
*
*Date:           06/27/2024
*
*Filename:       CarsSM1.java
*
*Purpose:        
*/
import java.util.Scanner;
public class Employee1 {
    static Scanner input = new Scanner(System.in);

    //Data Declarations
    private static String fName;
    private static String lName;
    private Employee boss = new Employee();
    private Address addr = new Address();
    private int count = 0;
    
    public static String getFname() {
        return fName;
    }
    
    public static String setFname() {
        return fName;
    }
    
    public static String getLname() {
        return lName;
    }
    
    public static String setLname() {
        return lName;
    }
    
    public void getBoss() {
    }
    
    public void setBoss() {
    }
    
    public void getAddr() {
    }
    
    public void setAddr() {
    }
    
    public void getCount() {
    }
    
    public void setCount() {
    }
    
    {
        count++;
    }
    
    
    public void name(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }
    
    public void person (String fName, String lName, Employee boss) {
        name(fName, lName);
        boss = null;
    }
    
    public void person1 (String fName, String lName, Employee boss, Address addr) {
        person(fName, lName, boss);
        this.addr = addr;
    }
}
class Address {

    //Data Declarations
    private String city;
    private String state;
    
    public void getCity() {
        
    }
    
    public void getState() {
    }
    
    public void getInfo(String city, String state) {
    }
}

class Driver {

    //Data Declarations
    static Scanner input;
    static String fName;
    static String lName;
    static String city;
    static String state;
    
    public static void main (String [] args) {
    }
    
    public static void grabName() {
        System.out.println("Please enter your first name");
        fName = input.nextLine();
        System.out.println("Please enter your last name");
        lName = input.nextLine();
        fName.split(", ");
    }
    
    public static void getAddress() {
        System.out.println(city + " " + state);
    }
    
    public static void display() {
    }    
}