/*
 * Name:         Rob Lapkass
 *
 * Course:       CS-12, Spring 2024
 *
 * Date:         03/30/24
 *
 * Filename:     UtilsTest1RL.java
 *
 * Purpose:      Test program for age algorithm correctness of PRGM10
 *               (instructor-provided).
 *               A series of test birthdates are provided, along with
 *               the expected age, and age results compared against expected.
 *
 *               This program has been generalized, so that it should work for either
 *               spring or fall semesters, just by toggling one flag.
 *
 *               =====================================================================
 *               INSTRUCTIONS: Do global replace of utility class name:
 *                  in jGRASP use: Edit: Find/Replace
 *                  or: Ctrl-F
 *                  change UtilsSM1 ==> your Utils class name
 *               Then run this program and inspect pass/fail results.
 *               =====================================================================
 *               Do not make any other changes to this file - it must run as-provided!
 *               =====================================================================
 *
 * Dependencies: This file depends on the presence of CS12Date.java
 */

import java.util.Random;

public class UtilsTest1SM1 {

    public static void main(String [] args) {
    
        // constants
        final int MIDYEAR = 182; // assumed midpoint day of year
        
        // declarations
        CS12Date bd, ref, now;
        int month, day, year;
        int age;
        int expAge;   // expected age
        int wrongAge; // age is 1 less
        
        // semester flag, T = spring, F = fall (SWITCH EVERY SEMESTER!)
        // updated in Fall 2021 to auto-set value, see code below
        //boolean semFlag = true;
        boolean semFlag;
        
        // test program control settings
        boolean doAgeTests = true;
        
        // date initializations
        bd = new CS12Date();
        ref = new CS12Date();
        final int CURR_YEAR = bd.getYear();
        final int CURR_MONTH = bd.getMonth();
        final int CURR_DAY = bd.getDay();
        
        // determine whether it's spring or fall semester by day # in year
        // early part of year is spring, latter part is fall
        if (UtilsSM1.today().getDateNum() < MIDYEAR) {
            semFlag = true;
        }        
        // otherwise, it's fall
        else {
            semFlag = false;
        }
    
        // perform age tests
        if (doAgeTests) {
        
            // program output header
            System.out.println("=============================");
            System.out.println("       Age test results      ");
            System.out.println("(test driver client provided)");
            System.out.println("=============================");
        
            //----------------------------------------------------------

            // test for birthdays BEFORE current date
            System.out.println("Birthdays BEFORE current date:");
            
            // B1: BD a day before current date
            expAge = 46;
            bd = UtilsSM1.today();
            bd.priorDate(1);
            bd.setYear(CURR_YEAR - expAge);
            runTest1("B1", bd, expAge);
                
            // B2: BD a day before current date
            expAge = 0;
            bd = UtilsSM1.today();
            bd.priorDate(1);
            runTest1("B2", bd, expAge);
        
            // B3: prior month, early day in month
            expAge = 35;
            month = getPriorMonth(semFlag);
            bd.setDate(month, getEarlyDay(month, CURR_DAY), CURR_YEAR - expAge);
            runTest1("B3", bd, expAge);
                
            // B4: prior month, early day in month, THIS year
            expAge = 0;
            month = getPriorMonth(semFlag);
            bd.setDate(month, getEarlyDay(month, CURR_DAY), CURR_YEAR);
            runTest1("B4", bd, expAge);            
            
            // B5: prior month, late day in month
            expAge = 18;
            month = getPriorMonth(semFlag);
            bd.setDate(month, getLateDay(month, CURR_DAY), CURR_YEAR - expAge);
            runTest1("B5", bd, expAge);
                
            // B6: prior month, late day in month, THIS year
            expAge = 0;
            month = getPriorMonth(semFlag);
            bd.setDate(month, getLateDay(month, CURR_DAY), CURR_YEAR);
            runTest1("B6", bd, expAge);
            
            // B7: this month, earlier day in month
            expAge = 82;
            bd.setDate(CURR_MONTH, getEarlyDay(CURR_MONTH, CURR_DAY), CURR_YEAR - expAge);
            runTest1("B7", bd, expAge);
                
            // B8: this month, earlier day in month, THIS year
            expAge = 0;
            bd.setDate(CURR_MONTH, getEarlyDay(CURR_MONTH, CURR_DAY), CURR_YEAR);
            runTest1("B8", bd, expAge);
            
            //----------------------------------------------------------
            
            // test for birthdays AFTER current date
            System.out.println("\nBirthdays AFTER current date:");
            
            // A1: tomorrow is BD
            wrongAge = 47;
            bd = UtilsSM1.today();
            bd.laterDate(1);
            bd.setYear(CURR_YEAR - wrongAge);
            runTest1("A1", bd, wrongAge - 1);
            
            // A2: future month, early day in month
            wrongAge = 16;
            month = getFutureMonth(semFlag);
            bd.setDate(month, getEarlyDay(month, CURR_DAY), CURR_YEAR - wrongAge);
            runTest1("A2", bd, wrongAge - 1);
                
            // A3: future month, early day in month
            wrongAge = 32;
            month = getFutureMonth(semFlag);
            bd.setDate(month, getEarlyDay(month, CURR_DAY), CURR_YEAR - wrongAge);
            runTest1("A3", bd, wrongAge - 1);
            
            // A4: future month, late day in month
            wrongAge = 21;
            month = getFutureMonth(semFlag);
            bd.setDate(month, getLateDay(month, CURR_DAY), CURR_YEAR - wrongAge);
            runTest1("A4", bd, wrongAge - 1);
                
            // A5: future month, late day in month
            wrongAge = 3;
            month = getFutureMonth(semFlag);
            bd.setDate(month, getLateDay(month, CURR_DAY), CURR_YEAR - wrongAge);
            runTest1("A5", bd, wrongAge - 1);
        
            //----------------------------------------------------------

            // test for birthdays ON today's date
            System.out.println("\nBirthdays ON today's date:");
        
            // T1: today, born today
            expAge = 0;
            bd = UtilsSM1.today();
            runTest1("T1", bd, expAge);
                
            // T2: today, kids or teens
            expAge = 8;
            bd = UtilsSM1.today();
            bd.setYear(CURR_YEAR - expAge);
            runTest1("T2", bd, expAge);
            
            // T3: today, millenials
            expAge = 22;
            bd = UtilsSM1.today();
            bd.setYear(CURR_YEAR - expAge);
            runTest1("T3", bd, expAge);
            
            // T4: today, baby boomers
            expAge = 54;
            bd = UtilsSM1.today();
            bd.setYear(CURR_YEAR - expAge);
            runTest1("T4", bd, expAge);
                
            // T5: today, seniors
            expAge = 78;
            bd = UtilsSM1.today();
            bd.setYear(CURR_YEAR - expAge);
            runTest1("T5", bd, expAge);
        
            //----------------------------------------------------------

            // test for future dates
            System.out.println("\n\nBirthdays in FUTURE:");
            System.out.println("==> error message to user **generated by getAge()** must display for EACH future date");
        
            // F1: tomorrow
            bd = UtilsSM1.today();
            bd.nextDay();
            runTest1("F1", bd, -1);
            
            // F2: future date in a week or so
            bd = UtilsSM1.today();
            bd.laterDate(10);
            runTest1("F2", bd, -1);
            
            // F3: future month this year, early date
            bd = UtilsSM1.today();
            month = getFutureMonth(semFlag);
            bd.setDate(month, getEarlyDay(month, CURR_DAY), CURR_YEAR);
            runTest1("F3", bd, -1);
            
            // F4: future month this year, late date
            bd = UtilsSM1.today();
            month = getFutureMonth(semFlag);
            bd.setDate(month, getLateDay(month, CURR_DAY), CURR_YEAR);
            runTest1("F4", bd, -1);
            
            // F5: future year, early month
            month = getPriorMonth(semFlag);
            bd.setDate(month, 15, CURR_YEAR + 4);
            runTest1("F5", bd, -1);
            
            // F6: future year, late month
            month = getFutureMonth(semFlag);
            bd.setDate(month, 9, CURR_YEAR + 3);
            runTest1("F6", bd, -1);
            
            //----------------------------------------------------------

            // test age on milestone dates
            System.out.println("\nPrior birthdays (dead or alive) on future milestone dates:");
        
            // M1-M2: George Washington 300th
            bd.setDate(2, 22, 1732);
            ref.setDate(2, 22, 2032);
            runTest2("M1", bd, ref, 300, "George Washington 300th");
            ref.setDate(2, 21, 2032);
            runTest2("M2", bd, ref, 299, "George Washington 300th, day before");  
            System.out.println();          
        
            // M3-M4: Bill Gates 70th
            bd.setDate(10, 28, 1955);
            ref.setDate(10, 28, 2025);
            runTest2("M3", bd, ref, 70, "Bill Gates 70th");
            ref.setDate(10, 27, 2025);
            runTest2("M4", bd, ref, 69, "Bill Gates 70th, day before"); 
            System.out.println();   
            
            // M5-M6: Mark Zuckerberg 65th
            bd.setDate(5, 14, 1984);
            ref.setDate(5, 14, 2049);
            runTest2("M5", bd, ref, 65, "Mark Zuckerberg 65th");
            ref.setDate(5, 13, 2049);
            runTest2("M6", bd, ref, 64, "Mark Zuckerberg 65th, day before");    
            
        } // end age tests
        
    } // end main
    
    //-----------------------------------------------------------------------------
    
    // generate a future month, depending upon whether spring or fall semester
    private static int getFutureMonth(boolean isSpring) {
    
        Random rand = new Random();
        int month;
        
        // spring or fall semester?
        if (isSpring) {
            // June-Dec
            month = rand.nextInt(7) + 6;   
        }
        else {
            // Nov-Dec only
            month = rand.nextInt(2) + 11; 
            
            // Dec only, Nov not a future month if early Nov! 
            month = 12;                    
        }
        
        return month;
    }
    
    // generate a prior month, depending upon whether spring or fall semester
    private static int getPriorMonth(boolean isSpring) {
    
        Random rand = new Random();
        int month;
        
        // it's spring
        if (isSpring) {
            // Jan-Feb (Age Utils assigned in late March or so)
            month = rand.nextInt(2) + 1;   
        }
        
        // it's fall
        else {
            // Jan-Sept (Age Utils assigned in October or so)
            month = rand.nextInt(9) + 1;           
        }
        
        return month;
    }
    
    //-----------------------------------------------------------------------------
    
    // generate an "early" date in a month, depends on current date ONLY
    private static int getEarlyDay(int month, int currDate) {
        // TODO: address glitch where Feb max date is 28 or 29 only, run late March
        return getRandomDay(1, Math.max(1, currDate-1));  // works, for now
        //return getRandomDay(1, Math.min(currDate-1, getMaxDays(month)));
    }
    
    // generate a "late" date in a month, depends on current date and month
    private static int getLateDay(int month, int currDate) {
        return getRandomDay(Math.min(currDate+1, getMaxDays(month)), getMaxDays(month));
    }
    
    // generate max # of days in a month (ignores leap years for now)
    // TODO: can't ignore leap years, needs to work in any year so needs to know year (Feb result year-dependent)
    // TODO: then other upstream usages of getEarlyDay/getLateDay are also impacted
    private static int getMaxDays(int month) {
        int maxDays;
        int year = (new CS12Date()).getYear(); // TODO: use an input, not current year
        
        // which month?
        switch (month) {
            // 30 days hath September, April, June and November
            case 4:
            case 6:
            case 9:
            case 11:
                maxDays = 30;
                break;
            
            // all the rest have 31:    
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:   
                maxDays = 31;
                break;
                
            // except February, of course
            case 2:
                // TODO: implement a fully correct leap year case, but this is good enough for now till 2100
                // 1900 and 2100 aren't leap years, but 2000 is a leap year
                maxDays = ((year % 4 == 0) ? 29 : 28);
                break;
                
            // error case: not that this should happen, but set a safe default
            default:
                maxDays = 28;
                break;
        }
        
        return maxDays;
    }
    
    //-----------------------------------------------------------------------------
    
    // generate a random day over bounded range, just API wrapper around an equivalent method for ages
    private static int getRandomDay(int minDay, int maxDay) {
        // this is just a random # generation, checking is done upstream
        return getRandomAge(minDay, maxDay);
    }
    
    // generate a random age within a certain range, to be used with an age test case
    private static int getRandomAge(int minAge, int maxAge) {
        
        Random rand = new Random();
        int age;
        
        // random age over specified range
        age = rand.nextInt(maxAge - minAge + 1) + minAge;
        
        return age;
    }

    //-----------------------------------------------------------------------------
    
    // test the single-input age form with a BD and an expected age
    private static void runTest1(String test, CS12Date bd, int expectedAge) {
    
        // test the 1-input form (age as of TODAY)
        int age = UtilsSM1.getAge(bd);
        
        // display test results
        //System.out.println("bd: " + bd + 
        //                   "\tas of: " + UtilsSM1.today() +
        //                   "\tage: " + age +
        //                   "\texpected: " + expectedAge +
        //                   "\tpass: " + (age==expectedAge ? true : false));
                     
        // rewritten using format specifiers to avoid tabbing      
        System.out.printf("%-5s%3s%11s%9s%11s%8s%4d%11s%4d%8s%-5b\n",
                          test + ')',
                          "bd: ", bd,
                          "as of:", UtilsSM1.today(),
                          "age:", age,
                          "expected:", expectedAge,
                          "pass: ", (age==expectedAge ? true : false));
        
    } // end runTest1

    //-----------------------------------------------------------------------------
    
    // test the two-input age form with a BD, milestone date, and an expected age
    private static void runTest2(String test, CS12Date bd, CS12Date ref, int expectedAge, String text) {
    
        // test the 2-input form (age as of some reference date)
        int age = UtilsSM1.getAge(bd, ref);
        
        // display test results
        //System.out.println("bd: " + bd + 
        //                   "\ton: " + ref +
        //                   "\tage: " + age +
        //                   "\texpected: " + expectedAge +
        //                   "\tpass: " + (age==expectedAge ? true : false) +
        //                   "\t" + text);
        
        // rewritten using format specifiers to avoid tabbing      
        System.out.printf("%-5s%3s%11s%9s%11s%8s%4d%11s%4d%8s%-8b%s\n",
                          test + ')',
                          "bd: ", bd,
                          "on:", ref,
                          "age:", age,
                          "expected:", expectedAge,
                          "pass: ", (age==expectedAge ? true : false),
                          text);
                   
    } // end runTest2
    
} // end class