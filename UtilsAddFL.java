/*
 * APPEND the indicated lines to your own Utils file.
 * ADJUST for needed 4 or 3 space nested, as needed (this file assumes 4-space nesting)
 * ADJUST the opening braces style, as needed (this file uses braces-end style)
 *
 * When your own readString() is working, uncomment the indicated line in pause() (LINE 18)
 * Then, you can use pause(), blank(), and message() statically in your own test code or programs
 * to "reverse engineer" the needed Car I test code outputs
 */

public class UtilsAddFL {

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
// copy TO above here ---^
    
    // example code showing usage of the needed methods
    // use these three methods liberally as you create own test code:   message(), blank(), pause()
    public static void main(String [] args) {
    
        UtilsAddFL.message("This is a bordered message", true);
        UtilsAddFL.message("This is a regular message, followed by 1 blank line", false);
        UtilsAddFL.blank();
        UtilsAddFL.pause();
        
        UtilsAddFL.message("One more bordered message", true);
        UtilsAddFL.message("Another regular message, followed by 2 blank lines", false);
        UtilsAddFL.blank(2);
        UtilsAddFL.pause();
        
    } // end main
          
} // end class