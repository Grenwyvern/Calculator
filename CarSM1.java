/*
*Name:           Steven Mecklenburg
*
*Course:         CS-12, Spring 2024
*
*Date:           04/19/2024
*
*Filename:       CarsSM1.java
*
*Purpose:        Implementation of a new Car class
*/

public class CarSM1 {

    //Instance variables ----------------------------------
    private String make;            // Make of the car
    private String model;           // Model of the car
    private int year;               // Year of the car
    private double odometer;        // Car's odometer
    private double tankLevel;       // Car's tank level
    private double tankSize;        // Car's tank size
    private CS12Date saleDate;      // Date of the car's sale
    private double salePrice;       // How much the car cost
    
    //Constants -------------------------------------------
    private final double TOL = 0.001;        // Tolerance amount
    
    //Other class data ------------------------------------
        double tripMiles = 0.0;
        double tripGallons = 0.0;
        double tripMPG = 25.0;
        
    //Data above here
    //======================================================
    //Methods below here
    
    //Constructors ----------------------------------------
    //Default constructor
    public CarSM1() {
        make = "Sierra";
        model = "Wolverine";
        year = UtilsSM1.today().getYear();
        odometer = 0.0;
        tankLevel = 0.0;
        tankSize = 0.0;
        saleDate = new CS12Date();
        salePrice = 0.00;
               
    }
    
    //Full constructor
    public CarSM1(String make, String model, int year,
                  double odometer, double tankLevel,
                  double tankSize, CS12Date saleDate,
                  double salePrice) {
        //Stores default values in Car class
        this();          
        
        setMake(make);
        setModel(model);
        setYear(year);
        setOdometer(odometer);
        setTankSize(tankSize);
        setTankLevel(tankLevel);
        setSaleDate(saleDate);
        setSalePrice(salePrice);

    }
    
    //Aditional constructor: Make and model only
    public CarSM1 (String make, String model) {
        //Stores default values in Car class
        this();
        
        setMake(make);
        setModel(model);
    }
    
    //Additional constructor: Make, model, and year only
    //Rest default using this()
    public CarSM1 (String make, String model, int year) {
        //Stores default values in Car class
        this();
        
        setMake(make);
        setModel(model);
        setYear(year);
    }
    //Additional constructor: Make, model, odometer only
    //Rest default using this()
    public CarSM1 (String make, String model, double odometer) {
        //Stores default values in Car class
        this();
        
        setMake(make);
        setModel(model);
        setOdometer(odometer);
    }
    
    //Display methods -------------------------------------
    //String version of object
    public String toString() {
        return String.format("%s %s %d %,.1f %.3f %.1f %s %,.2f", make, model, year, odometer, tankLevel, tankSize, saleDate, salePrice);               
    }
    
    //Default print method
    public void print() {
        System.out.printf("%-44s %s %n", "make: ", make);
        System.out.printf("%-44s %s %n", "model: ", model);
        System.out.printf("%-44s %d %n", "model year:", year);
        System.out.printf("%-44s %,.1f %n", "odometer [miles]: ", odometer);
        System.out.printf("%-44s %.3f %n", "tank level [gals]: ", tankLevel);
        System.out.printf("%-44s %.1f %n", "tank size [gals]: ", tankSize);
        System.out.printf("%-44s %s %n", "last sale date:", saleDate);
        System.out.printf("%-44s %,.2f %n", "last sale price [$]: ", salePrice);
        System.out.println("------------------------------------------------------");
        System.out.printf("%-44s %d %n", "age [yrs]: ", getAge());
        System.out.printf("%-44s %s %n", "status: ", getStatus());
        System.out.printf("%-44s %,.2f %n", "depreciated value [$]: ", getValue(5));
        System.out.printf("%-44s %,.1f %n", "remaining fuel: ", getFuelPct());
        System.out.printf("%-44s %.1f %n", "full travel range [miles]: ", getFullRange());
        System.out.printf("%-44s %.1f %n", "remaining travel range [miles]: ", getTripRange());
        System.out.printf("%-44s %.1f %n", "current MPG [miles/gals]: ", getMPG());
        System.out.println("------------------------------------------------------");
        System.out.printf("%-44s %.1f %n", "travel since last fill-up [miles]:", tripMiles);
        System.out.printf("%-44s %.3f %n", "fuel since last fill-up [gals]: ", tripGallons);
                                
    }
    //Overloaded print method
    public void print(String msg) {
        System.out.println("===============================");
        System.out.println(msg);
        System.out.println("===============================");
        print();    
    }
    
    //Default display method to post a FOR SALE sign that contains string formatting
    //Contains a year 8 depreciation year
    public void display() {
        System.out.printf("FOR SALE: %s %d %s %s %n", getStatus(), year, make, model);
        System.out.printf("%.1f gal tank %.1f MPG %,.1f miles %n", tankSize, tripMPG, odometer);
        System.out.printf("last sold %s $%,.2f asking price $%,.2f %n", saleDate, salePrice, getValue(8));
    }
    
    //Calculates new CS12Date for age
    public int getAge() {  
        int age = UtilsSM1.getAge(new CS12Date(1, 1, year));
        return age;
    }
    
    //Contains logic if else if statements for get age method
    //Determines what status will print based on logic statements
    public String getStatus() {
        String status;
            
            //Checks if the get age method equals 0
            //If get age method equals 0, then status prints "new"
            if (getAge() == 0) {
                status = "new";
            }
            
            //Checks if the get age method is greater than 0
            //If get age method equals 0, then status prints "used"
            else if (getAge() > 0) {
                status = "used";
            }
            
            //Otherwise status prints "prototype"
            else {
                status = "prototype";
            }
            
        return status;
    }
    
    //Contains logic if else statements that determine the depreciation value
    //Ensures the input to be positive and to only be 5 or 8
    public double getValue(int deprYears) {   
        double value;
        
        //Checks if the depreciation years are 5 or 8
        //Value is initialized to equal sale price value
        if (deprYears < 0) {
            System.out.printf("ERROR: getValue(): depreciation schedule must be positive, can't be %d years, no depreciation%n", deprYears);
            value = salePrice;
        
        }
        
        //Checks if the get age method equals a future birthday compared to a reference date 
        else if (getAge() == -1) {
            value = salePrice;
        } 
        
        //Checks if the depreciation years are any value but 5 or 8
        else if ((deprYears != 5) && (deprYears != 8)) {
            System.out.printf("ERROR: getValue(): depreciation schedule can't be %d years, must be 5 | 8 yrs ONLY, no depreciation%n", deprYears);
            value = salePrice;
        }        
        
        //Runs calculations if other logic statements fail
        else {
            value = (salePrice - (getAge() * (salePrice / (double) deprYears)));
        }
        
        //Returns minimum value of 0     
        return Math.max(value, 0.0);
    }
    
    //Contains if else logic statements
    //Returns fuel value and ensures there is enough fuel to travel
    //Returns 0.0 value for fuel if the if statement falls through
    public double getFuelPct() {
        double fuel;
        
            //Checks if the tank size is less than 0
            if (tankSize <= 0) {
                fuel = 0.0;
            }
            
            //Runs calculations if logic statement fails
            else {
                fuel = (tankLevel / tankSize) * 100;
            }
            
        return fuel;
    }
    
    //Gets full range through accessor
    public double getFullRange() {
        return (tankSize * getMPG());
    }
    
    //Gets trip range value through accessor
    public double getTripRange() {
        return (tankLevel * getMPG());
    }
    
    //Contains a logic if statement that determines the current gallons in the car
    public double getMPG() {      
    
        //Checks if the current gallons are above 0 since the last fillup
        if (tripGallons > 0) {
            tripMPG = (tripMiles / tripGallons);
        }
        
        return tripMPG;
    }
        
    // Accessors, Mutators ---------------------------------
    
    //Make accessor
    public String getMake() {
        return make;
    }
    
    //Make mutator
    public void setMake(String make) {
        this.make = make;
    }
    
    //Make overaloded mutator
    public void setMake(boolean input) {
        String data = UtilsSM1.readString("Enter make of the car > ", input);
        setMake(data);
    }
    
    //Model accessor
    public String getModel() {
        return model;
    }
    
    //Model mutator
    public void setModel(String model) {
        this.model = model;
    }
    
    //Model overloaded mutator
    public void setModel(boolean input) {
        String data = UtilsSM1.readString("Enter model of the car > ", input);
        setModel(data);
    }
    
    //Year accessor
    public int getYear() {
        return year;
    }
    
    //Year mutator
    public void setYear(int year) {
        
        //If year is below 1900 then year is given default value initialized above
        if (year < 1900) {   
            System.out.printf("ERROR: setYear(): year %d must be >= 1900, model year left unchanged%n", year);
        }
        
        //Results in default value    
        else {
            this.year = year;
        }           
    }
    
    //Year overaloded mutator
    public void setYear(boolean input) {
        int data = UtilsSM1.readInt("Enter model year of the car > ", input);
        setYear(data);
    }
    
    //Odometer accessor
    public double getOdometer() {
        return odometer;
    }
    
    //Odometer mutator
    public void setOdometer(double odometer) {
    
        //Checks if odometer is less than 0
        if (odometer < 0.0) {
            System.out.printf("ERROR: setOdometer(): can't set odometer to negative value %,.1f [miles], odometer value is unchanged%n", odometer);
        }
        
        //Checks if the odometer is less than the default value
        else if (odometer < this.odometer) {
            System.out.printf("ERROR: setOdometer(): can't move odometer back to %.1f [miles], that's illegal!, odometer value is unchanged%n", odometer);
        }
        
        //Results in default value
        else {
            this.odometer = odometer;
        }
    }
    
    //Odometer overloaded mutator
    public void setOdometer(boolean input) {
        double data = UtilsSM1.readDouble("Enter odometer of the car [miles] > ", input);
        setOdometer(data);
    }
    
    //Tank level accessor
    public double getTankLevel() {
        return tankLevel;
    }
    
    //Tank level mutator
    public void setTankLevel(double tankLevel) {
    
        //Checks if tank level is lower than 0
        if (tankLevel < 0.0) {
            System.out.printf("ERROR: setTankLevel(): can't set tank level to negative value %.3f [gals], tank level is unchanged%n", tankLevel);
        }
        
        //Checks if it's greater than the tank size
        else if (tankLevel > tankSize) {
            System.out.printf("ERROR: setTankLevel(): tank level %.3f [gals] must be <= tank size %.1f [gals], tank level is unchanged%n", tankLevel, tankSize);
        }
        
        //Results in default value
        else {
            this.tankLevel = tankLevel;
        }
    }
    
    //Tank level overloaded mutator
    public void setTankLevel(boolean input) {
        double data = UtilsSM1.readDouble("Enter tank level of the car [gals] > ", input);
        setTankLevel(data);
    }
    
    //Tank size accessor
    public double getTankSize() {
        return tankSize;
    }
    
    //Tank size mutator
    public void setTankSize(double tankSize) {
    
        //Checks if the tank size is less than 0
        if (tankSize < 0.0) {
            System.out.printf("ERROR: setTankSize(): can't set tank size to a negative value %.1f [gals] tank size is unchanged%n", tankSize);
        }
        
        //Checks if the tank level is greater than the tank size
        else if (tankLevel > tankSize) {
            System.out.printf("ERROR: setTankSize(): tank size %.1f [gals] must be >= tank level %.3f [gals], tank size is unchanged%n", tankSize, tankLevel);
        }
        
        //Results in default value
        else {
            this.tankSize = tankSize;
        }
    }
    
    // Tank size overloaded mutator
    public void setTankSize(boolean input) {
        double data = UtilsSM1.readDouble("Enter tank size of the car [gals] > ", input);
        setTankSize(data);
    }
    
    // Sale date accessor
    public CS12Date getSaleDate() {
        CS12Date temp = new CS12Date();
        temp.setMonth(this.saleDate.getMonth());
        temp.setDay(this.saleDate.getDay());
        temp.setYear(this.saleDate.getYear());
            
        return temp;
    }
    
    // Sale date mutator
    public void setSaleDate(CS12Date saleDate) {  
       
        //Data date safe transfer   
        (this.saleDate).setMonth(saleDate.getMonth());
        (this.saleDate).setDay(saleDate.getDay());
        (this.saleDate).setYear(saleDate.getYear());
    }
    
    // Sale date overloaded mutator
    public void setSaleDate(boolean input) { 
        int dataMonth;
        int dataDay;
        int dataYear;
        dataMonth = UtilsSM1.readInt("Enter sale month for the car > ", input);
        dataDay = UtilsSM1.readInt("Enter sale day for the car > ", input);
        dataYear = UtilsSM1.readInt("Enter sale year of the car > ", input);
        saleDate = new CS12Date(dataMonth, dataDay, dataYear);
    }
    
    // Sale price accessor
    public double getSalePrice() {
        return salePrice;
    }
    
    // Sale price mutator
    public void setSalePrice(double salePrice) {
    
        //Checks if the sale price is less than 0
        if (salePrice < 0) {
            System.out.printf("ERROR: setSalePrice(): sale price can't be $%,.2f must be >= $0.00, sale price is unchanged%n", salePrice);
        }
        
        //results in default value
        else {
            this.salePrice = salePrice;
        }

    }
    
    // Sale price overloaded mutator
    public void setSalePrice(boolean input) {
        double data = UtilsSM1.readDouble("Enter sale price of the car [$] > ", input);
        setSalePrice(data);
    }
    
    // Equivalence -----------------------------------------
    public boolean equals(Object obj) {
    
        boolean status;
        
        //Returns a false if logic statement fails
        if (!(obj instanceof CarSM1)) {
            status = false;
        }
        
        //Returns obj
        else {
            CarSM1 c = (CarSM1) obj;
            
            //If these statements result in a true with the if statement,then the method returns a true
            if ( (c.getMake().equals(this.make)) &&
                 (c.getModel().equals(this.model)) &&
                 (c.getYear() == (this.year)) &&
                 (Math.abs(c.getOdometer()-this.odometer) <= TOL) &&
                 (Math.abs(c.getTankSize()-this.tankSize) <= TOL) &&
                 (Math.abs(c.getSalePrice()-this.salePrice) <= TOL) &&
                 (c.getSaleDate().equals(this.saleDate)) ) {
                 status = true;    
            }
            
            //If the if statement results in a false, then the method returns a false    
            else {
                status = false;
            }
        } return status;
    }
   
    // Derived data accessors ------------------------------
    
    // Utility Methods -------------------------------------
    public void update(boolean mode) {
        setMake(mode);
        setModel(mode);
        setYear(mode);
        setOdometer(mode);
        setTankSize(mode);
        setTankLevel(mode);
        setSaleDate(mode);
        setSalePrice(mode);                     
    }
    
    //Drive method contains several check if/else if's to determine if the drive is possible
    //Includes "No Travel" error methods if logic cases fail
    public void drive(double miles, double mpg) {
        
        //Checks if the destination miles are less than 0
        if (miles <= 0.0) {   
            System.out.printf("ERROR: drive (m,mpg): can't drive negative or 0.0 distance %.1f [miles], no drive taken%n", miles);  
        }
        
        //Checks if the mpg are less than 0
        else if (mpg <= 0.0) {     
            System.out.printf("ERROR: drive (m,mpg): can't have negative or 0.0 MPG %.1f [MPG], no drive taken%n", mpg);  
        }
        
        //Checks if the tank level are less than the mile per gallon
        else if (tankLevel <= miles / mpg) {    
            System.out.printf("ERROR: drive(m,mpg): can't drive %.1f [miles] at %.1f MPG with current gas %.3f gals, no drive taken%n", miles, mpg, getTankLevel());   
        }        
        
        //Runs changes if other logic statements result in a false
        else {
            odometer += miles;
            tankLevel -= miles / mpg;
            tripMiles += miles;
            tripGallons += miles / mpg;
        }           
    }
    
    public void drive(double miles) {
        
        //Checks if the miles are less than or requal to 0. If so, throws error message
        if (miles <= 0.0) {   
            System.out.printf("ERROR: drive (m): can't drive negative or 0.0 distance %.1f [miles], no drive taken%n", miles); 
        }
        
        //Checks if the tank level is less than or equal to the miles / getMPG(). If so, throws error message
        else if (tankLevel <= miles / getMPG()) {
            System.out.printf("ERROR: drive(m): can't drive %.1f [miles], max trip length is %.1f, no drive taken%n", miles, getTripRange());
        }
        
        //Calls drive method
        else {
            drive(miles, getMPG());
        }
    }
    
    public void fuel(double gallons) {
    
        //Checks if the tank level is greater than the tank size. If so, throws error
        if ((gallons + tankLevel) > (tankSize)) {
            System.out.printf("ERROR: fuel(): adding %.3f [gals] more would exceed tank size, no change to gas level", gallons);
        }
        
        //Checks if the there is enough fuel in the tank
        else if (gallons <= 0.0) {
            System.out.printf("ERROR: fuel(): can't add %.3f [gals], must be > 0.0, no change to gas tank%n", gallons);
        }
        
        //Runs changes if other if else if statements are false
        else {
            tankLevel += gallons;
            tripMiles = 0.0;
            tripGallons = 0.0;
        }
    }
    
    public void sell(double price, CS12Date date) {
    
        //Checks if the price is less than 0. If so, throws error
        if (price < 0.0) {
            System.out.printf("ERROR: sell(): cannot sell for negative price %,.2f [$], no sale made%n", price);
        }
        
        //Runs changes if results in a false with the if statement
        else {
            setSaleDate(date);
            salePrice = price;
        }
    }
   
    
    // Unit test code --------------------------------------
    public static void main (String [] args) {
        CarSM1 c1 = new CarSM1();   // First object using default constructor
        
        CarSM1 c2 = new CarSM1("Honda", "Odyssey", 2010, 
                               100000.0, 17.5, 20.0, 
                               new CS12Date(5, 1, 2010), 27995.99);   // Second object using full constructor
                               
        CarSM1 c3 = new CarSM1("Toyota", "Prius", 2020,
                                0.0, 0.0, 0.0, new CS12Date(), 0.0);   // Third object using full constructor
                                
        CarSM1 c4 = new CarSM1("Tesla", "Model S", 2024,
                                123.4, 0.0, 0.0, new CS12Date(), 0.0); // Fourth object using full constructor
                                
        CarSM1 c5 = new CarSM1("Chevy", "Camaro", 2020,
                                0.0, 0.0, 0.0, new CS12Date(), 23500.86);   // Fifth object using full constructor
        CarSM1 c6 = new CarSM1();   // Sixth object using default constructor
        
        // First sample output
        // Displays default constructor for car 1
        // Pauses user with pause() continues when user selects "Enter"
        UtilsSM1.message("test 1: create 4 car objects, using all 4 constructor forms", true);
        System.out.println("(no visible output)");
        System.out.println();
        UtilsSM1.message("test 2: display all created objects using toString and overloaded print", true);
        System.out.println();
        System.out.println(c1);
        c1.print("default constructor - car1");
        System.out.println();
        UtilsSM1.pause();
        System.out.println();              
        
        // Gathers information from car 2 and displays it with print()
        // Pauses code with pause() continues when user selects "Enter"
        System.out.println();
        System.out.println(c2);
        c2.print("full constructor - car2");
        System.out.println();
        UtilsSM1.pause();
        System.out.println();
        
        // Gathers information from car 3 Full constructor and displays it with print()
        // Gathers information from car 4 Full constructor and displays it with print()
        // Pauses code with pause() continues when user selects "Enter"
        System.out.println(c3);
        c3.print("make/model/year constructor - car3");
        System.out.println();
        UtilsSM1.pause();
        System.out.println();
        System.out.println(c4);
        c4.print("make/model/odometer constructor - car4");
        System.out.println();
        UtilsSM1.pause();
        
        // Test 3: Gathers information using get accessors from the second car object
        // Displays information from car 3 and car 4
        UtilsSM1.message("test 3: test all accessors - print ONE object, and extract each field alone using gets", true);
        System.out.println();
        c2.print("Starting car");
        System.out.println();
        System.out.println("all instance vars displayed using each get");
        System.out.println();    
        System.out.println("make alone: \t\t\t " + c2.getMake());
        System.out.println("model alone: \t\t\t " + c2.getModel());
        System.out.println("year alone: \t\t\t " + c2.getYear());
        System.out.println("odometer alone: \t\t " + c2.getOdometer());
        System.out.println("tank level alone: \t\t " + c2.getTankLevel());
        System.out.println("tank size alone: \t\t " + c2.getTankSize());
        System.out.println("sale date alone: \t\t " + c2.getSaleDate());
        System.out.println("sale price alone: \t\t " + c2.getSalePrice());
        UtilsSM1.pause();     
        
        // Test 4: Prints default information before gathering information from full constructor using get accessors
        // Uses print() methods to display the information
        // Uses pause() method to pause code and wait for user to select enter
        UtilsSM1.message("test 4: test all mutators - print default object before/after updating ecah field", true);
        c1.print("default car as starting point");
        System.out.println();
        System.out.println("all instance vars individually updated using sets (made-up data)");
        System.out.println();
        c5.print("default car updated");
        System.out.println();
        UtilsSM1.pause();
        
        // Test 5: Prompts for user input for the make, model, year, odometer, tank level, tank size, sale date, and sale price
        // Prints default car and then shows the changes from user input below
        // Pauses the code with pause() and waits until user selects "Enter"
        UtilsSM1.message("test 5: test all prompting mutators - print default objects before/after updating each field", true);
        c1.print("starting default car");
        System.out.println();
        System.out.println("update each field - note this can be absolute garbage data for now!");
        c6.setMake(false);
        c6.setModel(false);
        c6.setYear(false);
        c6.setOdometer(false);
        c6.setTankLevel(false);
        c6.setTankSize(false);
        c6.setSaleDate(false);
        c6.setSalePrice(false);
        System.out.println();
        c6.print("after all updates");
        System.out.println();
        UtilsSM1.pause();
        
        //Equality section
        //Compares car 1 with other variables and returns a boolean result              
        System.out.println("test car1 vs car1: \t\t\t\t" + c1.equals(c1) );
        System.out.println("test car1 vs car2: \t\t\t\t" + c2.equals(c1) );
        System.out.println("test car1 vs any String: \t\t" + c2.equals(c1) );
        System.out.println("test car1 vs any CS12Date: \t\t" + c2.equals(c1) );
        
    }  //End main

} // End class