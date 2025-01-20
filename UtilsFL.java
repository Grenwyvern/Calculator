/*
 * Name:       
 *
 * Course:     CS-12, Spring 2024   
 *
 * Date:       
 *
 * Filename:   
 *
 * Purpose:    Starter CS-12 utilities file.
 *             This class is a collection of useful utility methods
 *              which are called statically:    UtilsFL.method()
 *
 *             TODO: reword the purpose of this file INTO YOUR OWN WORDS
 *
 *             THIS FILE RELIES UPON HAVING CS12Date.java IN LOCAL DIRECTORY
 */

import java.util.Scanner;

public class UtilsFL {

    //---------------------------------------------------------------------------
    // user input methods, by datatype
    //---------------------------------------------------------------------------
    
    // get an int value
    public static int readInt(String prompt) {
        // TODO: 1) add a 2nd *input argument* (in the above method interface) for boolean "guiMode" input
        //
        //       2a) add an if-else selection structure (2 logic branches)
        //       2b) for the needed condition, use the added 2nd (boolean) method input to determine which branch to use
        //       
        //       3a) the *existing* Scanner mode input code (lines 49-51) goes into the "false" branch
        //       3b) create equivalent JOptionPane code as the *other* "true" branch
        //
        //       4) then in client:
        //       a) if using F, get input as shown using Scanner (command line)
        //       b) if using T, get input using JOptionPane (popup GUI)
    
        // declare data and objects
        Scanner input;
        int data;

        // TODO: *in between* the above declarations and the ending return statement, 
        // add if-else logic around the following statements:
        
            // prompt for an input int value using Scanner mode, for guiMode=false case
            input = new Scanner(System.in);
            System.out.print(prompt);
            data = input.nextInt();
        
            // TODO: here, add the equivalent JOPtionPane read code for guiMode=true case
        
        // regardless of whether obtained by Scanner or JOptionPane, do this ONCE at end
        return data;   
          
    }
    
    //---------------------------------------------------------------------------
    // age-related methods
    //---------------------------------------------------------------------------
    
    // returns the age as of some REFERENCE date (2-input overloaded form, MODS NEEDED)
    public static int getAge(CS12Date dateBd, CS12Date dateRef) {
        // TODO: declare 6 additional ints for m,d,y of each date input (6 total): monthBd, yearRef, etc.
        int age = -1; // starting default output
        
        // TODO: take apart both input dates into individual ints, using accessors:  
        //        2 CS12Date objects --> 6 individual M,D,Y ints 
        // monthBd = ...
        // yearRef = ...       
        
        // TODO: devise needed AGE LOGIC below, there are multiple correct ways but this is ONE simple possibility
        // a) Start by putting into WORDS (comments) what each logic path is testing, see logic design diagrams given
        // b) Based on what each case is checking, devise the needed logical condition using those 6 ints (replacing each "false")
        // c) Calculate the resulting age in each case
        // d) ONLY if the age is -1 (a future birthday), print an error message as shown in sample output, including the 2 input dates and age = -1
        // e) DO NOT print any ages here!
        // f) DO NOT use multiple abrupt return statements for each case, only one common one at the end as given
        
        // TODO: TEST your changes incrementally by running this code freqquently against the provided test program,
        // see that you are getting good results for each new change made
        
        // TODO: cleanup this code before submitting it: remove all TODOs, check code against Coding Standard and rubric
         
         
        // first, check for all possible FUTURE birthdates
        
        // case 1: check for...
        if (false) {
        
        }
                
        // case 2: check for...
        else if(false) {
        
        }
        
        // case 3: check for...
        else if(false) {
        
        }
        
        // if we get this far, a person has been "born" and has a BD within any 12 month year        
        // case 4: check for...
        else if (false) {
            
        }
            
        // case 5: check for...
        else if (false) {
            
        }
            
        // case 6: all other birthdays
        else {
            
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
        
    }
       
} // end class