/*
 * Name:       Steven Mecklenburg
 *
 * Course:     CS-12, Spring 2024   
 *
 * Date:       04/03/2024
 *
 * Filename:   UtilsSM1.java
 *
 * Purpose:    To determine the age of an individual by taking their birthday and subtracting it from a reference date
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class UtilsSM1 {

    //---------------------------------------------------------------------------
    // user input methods, by datatype
    //---------------------------------------------------------------------------
    
    // get an int value
    public static int readInt(String prompt, boolean guiMode) {
    
        // declare data and objects
        Scanner input;
        String dialog;
        int data = 0;
        String garbage;
        boolean failed = true;
               
        // prompt for an input int value using Scanner mode, for guiMode=false case
        // if false, goes to scanner. if true, goes to GUI
        if (!guiMode) {
            input = new Scanner(System.in);
            System.out.print(prompt);
            
            //Checks for valid number
            while ( !input.hasNextInt() ) {
                garbage = input.nextLine();
                System.out.print(prompt);

        }
            
        //Prompts the user for an int using scanner
        data = input.nextInt();                   
            
        }
             
        else {
        
            //Type safe checking
            while ( failed == true ) {
            
                try {
                    //Converts value into int if GUI input occurs
                    dialog = JOptionPane.showInputDialog(null, prompt);                   
                    data = Integer.parseInt(dialog);                   
                    failed = false;
                       
                }
                
                //Empty message is provided if exception is thrown
                catch(NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, ""); 
                
                }
                            
            } 
          
        }
        
        //returning data no matter scanner or GUI
        return data;
    }
    
    //---------------------------------------------------------------------------
    
    //Read Char method
    //Contains a string and a boolean argument
    //Returns prompt to user if value isn't a char. If it is a char, then data is returned
    public static char readChar(String prompt, boolean charValue) {
    
        //declare data and objects
        Scanner input;
        String dialog;
        String userInput;
        char data;
        
        //Checks if the value isn't a char
        if (!charValue) {
            
            //Data initializations 
            input = new Scanner(System.in);
            System.out.print(prompt);
            userInput = input.nextLine();
            data = userInput.charAt(0);
            
        }
        
        //GUI Inputs
        else {
            
            //Results in GUI inputs if boolean results in false
            dialog = JOptionPane.showInputDialog(null, prompt);
            data = dialog.charAt(0);  
                          
        }
        
        //returning data no matter scanner or GUI
        return data;  
    
    }
    
    //---------------------------------------------------------------------------
    
    //Read double method
    //Contains a string and boolean arguments
    //Reprompts user if value isn't a double. Otherwise, data is returned
    public static double readDouble(String prompt, boolean doubleMode) {
    
        // declare data and objects
        Scanner input;
        String dialog;
        double data = 0;
        String garbage;
        boolean failed = true;
               
        // prompt for an input int value using Scanner mode, for guiMode=false case
        // if false, goes to scanner. if true, goes to GUI
        if (!doubleMode) {
            input = new Scanner(System.in);
            System.out.print(prompt);
            
        //Checks for valid number
        while ( !input.hasNextDouble() ) {
            garbage = input.nextLine();
            System.out.print(prompt);

        }
            
        //Prompts user for a double input using scanner
        data = input.nextDouble();                   
            
        }

        else {
        
            //Type safe checking
            while ( failed == true ) {
            
                //Converts value into int if GUI input occurs
                //Empty messagge provided if exception is thrown
                try {
                
                    dialog = JOptionPane.showInputDialog(null, prompt);                   
                    data = Integer.parseInt(dialog);                   
                    failed = false;
                       

                }

                catch(NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, ""); 
                
                }
                            
            } 
          
        }
        
        //returning data no matter scanner or GUI
        return data;
    }
    
    //Read string method
    //Contains a string and boolean arguments
    //Reprompts user if value isn't a string. Otherwise, returns data
    public static String readString(String prompt, boolean StrValue) {
    
        //declare data and objects
        Scanner input;
        String dialog;
        String userInput;
        String data;
        
        //Checks if value isn't a String
        if (!StrValue) {
            
            input = new Scanner(System.in);
            System.out.print(prompt);
            userInput = input.nextLine();
            data = userInput.toString();
        }
        
        //Provides GUI input if boolean results in a false
        else {
         
            dialog = JOptionPane.showInputDialog(null, prompt);
            data = dialog.toString();                
        }
        
        //returning data no matter scanner or GUI
        return data;  
    
    }
    


    
    //---------------------------------------------------------------------------
    // age-related methods
    //---------------------------------------------------------------------------
    
    // returns the age as of some REFERENCE date (2-input overloaded form, MODS NEEDED)
    public static int getAge(CS12Date dateBd, CS12Date dateRef) {
        // TODO: declare 6 additional ints for m,d,y of each date input (6 total): monthBd, yearRef, etc.
        int age = -1; // starting default output
        int dayBd;
        int monthBd;
        int yearBd;
        int dayRef;
        int monthRef;
        int yearRef;
        String testDate;
        
        //2 CS12Date objects --> 6 individual M,D,Y ints 
        dayBd = dateBd.getDay();
        monthBd = dateBd.getMonth();
        yearBd = dateBd.getYear();
        dayRef = dateRef.getDay();
        monthRef = dateRef.getMonth();
        yearRef = dateRef.getYear();
        CS12Date birthDateRef = new CS12Date(monthRef, dayRef, yearRef);      
         
        //checking for future birthdates. Ensuring they're not cyborgs
        
        // case 1: check for birthdays being after reference year
        if (yearBd > yearRef) {
             //   System.out.printf("ERROR: provided birthday " + dateBd + " is after reference date " + dateRef + ": age = " + age + "(from case 1)");      
        }
                
        // case 2: check for same year and younger birth month
        else if((yearBd == yearRef) && (monthBd > monthRef)) {
             //   System.out.printf("ERROR: provided birthday " + dateBd + " is after reference date " + dateRef + ": age = " + age + "(from case 2)");
        
        }
        
        // case 3: check for same year and same month but day of birth is before reference date
        else if((yearBd == yearRef) && (monthBd == monthRef) && (dayBd < dayRef)) {
             //   System.out.printf("ERROR: provided birthday " + dateBd + " is after reference date " + dateRef + ": age = " + age + "(from case 3)");
        }
        
        // if we get this far, a person has been "born" and has a BD within any 12 month year        
        // case 4: check for younger birth year and younger birth month
        else if ((yearBd < yearRef) && (monthBd > monthRef)) {
            age = (yearRef - yearBd) - 1;
              //  System.out.printf("provided birthday " + dateBd + " is before reference date " + dateRef + ": age = " + age + "(from case 4)");
            
        }
            
        // case 5: check for younger birth year and same month and day of birth is before reference day
        else if ((yearBd < yearRef) && (monthBd == monthRef) && (dayBd > dayRef)) {
            age = (yearRef - yearBd) -1;
             //   System.out.printf("provided birthday " + dateBd + " is before reference date " + dateRef + ": age = " + age + "(from case 5)");
            
        }
            
        // case 6: all other birthdays
        else {  
            age = (yearRef - yearBd);    
        }
        
        // return ONE common age here, NOT multiple return statements in each logic path above!
        return age;
        
    } // end 2-input overloaded version
    
    //---------------------------------------------------------------------------

    // returns the age as of TODAY'S date (1-input overloaded form, NO CHANGES NEEDED, DO NOT EDIT)
    public static int getAge(CS12Date dateBd) {
        int age;
        CS12Date dateToday = today();
        
        // calls overloaded version of above method, using TODAY as the reference date
        age = getAge(dateBd, dateToday);  
        return age;
        
    } // end 1-input overloaded version
    
    
    //---------------------------------------------------------------------------
    // date-related methods 
    //---------------------------------------------------------------------------
    
    // returns today's date as a CS12Date (NO CHANGES NEEDED, DO NOT EDIT)
    public static CS12Date today() {
    
        // simply return a default date, which is today
        return new CS12Date();
        
    } //end CS12Date method

    // execution related methods ------------------------------------------------
    
// copy FROM below here-----------V
    // execution related methods ------------------------------------------------
    
    // pauses execution until any key is pressed, specific prompt
    public static void pause(String message) {
        // ignores any returned value
        UtilsSM1.readString(message, false);
        System.out.println();   // add a blank line
    }
    
    // pauses execution until any key is pressed, generic prompt
    public static void pause() {
        pause("Press <Enter> to continue... ");
    }

    // display related methods --------------------------------------------------

    // prints a specified character N times
    public static void spacer(char ch, int num) {
        // print specified char N times
        for (int i=0; i<num; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }
    
    // prints a default character N times
    public static void spacer(int num) {
        final char SEP_CHAR = '=';   // default separator character
        
        // overloaded call to the other version
        spacer(SEP_CHAR, num);
    }
    
    // prints a default spacer, = x40 wide
    public static void spacer() {
        final char SEP_CHAR = '=';   // default separator character
        final int SEP_NUM = 40;      // default separator width
        
        // overloaded call to the other version
        spacer(SEP_CHAR, SEP_NUM);
    }
    
    // Added Sp2024: these also do the same thing, except using an available String methods
    // Here, it's implied that the spacer is a single-length STRING character
    // For now, the existing message() methods still use the char versions of this

    // prints a specified string spacer N times
    public static void spacerStr(String ch, int num) {
        System.out.println(ch.repeat(num));
    }
    
    // prints a default string spacer N times
    public static void spacerStr(int num) {
        final String SEP_CHAR = "=";   // default separator character
        
        // overloaded call to the other version
        spacerStr(SEP_CHAR, num);
    }
    
    // prints a default string spacer, = x40 wide
    public static void spacerStr() {
        final String SEP_CHAR = "=";   // default separator character
        final int SEP_NUM = 40;        // default separator width
        
        // overloaded call to the other version
        spacerStr(SEP_CHAR, SEP_NUM);
    }
    
    //------------------------------------------------------------------
       
    // print a message with or without surrounding bounding box
    public static void message(String msg, boolean box) {
        // print message w/o boxing
        if (!box) {
            System.out.println(msg);
        }
        
        // prints message WITH boxing, using length of desired message
        else {
            spacer('=', msg.length());
            System.out.println(msg);
            spacer('=', msg.length());
        }
    }
    
    //------------------------------------------------------------------
    
    // print one blank line
    public static void blank() {
        System.out.println();
    }
    
    // overloaded version, prints N blank lines
    public static void blank(int num) {
        for (int i=1; i<=num; i++) {
            blank();
        }
    }
       
} // end class