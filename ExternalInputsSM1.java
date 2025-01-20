import javax.swing.JOptionPane;

public class ExternalInputsSM1 {

    // Existing data declarations unchanged
    static double sandwichPrice;
    static double chipsPrice;
    static double sodaPrice;
    static double totalLunchPrice;
    static int traditionalAgeYears;
    static int childAgeMonths;
    static int addedMonths;
    static double salesTax;
    static double itemPrice;
    static double area;
    static double radius;
    static int hits;
    static int atBats;
    static double battingAvg;
    static int item1Inventory;
    static int item2Inventory;
    static int deliveryAmount;

    // Additional String declarations for input and output
    static String inputStr;
    static String outputStr;

    public static void main(String[] args) {
        // Declare and Initialize Constants
        final int MONTHS_PER_YEAR = 12;
        final double PI = 3.14159;
        final double TAX_RATE = 0.0725;

        // Problems 1-4 Initialize Variables
        inputStr = JOptionPane.showInputDialog(null, "Problem #1 - Enter the price for a sandwich:");
        sandwichPrice = Double.parseDouble(inputStr);
        inputStr = JOptionPane.showInputDialog(null, "Problem #1 - Enter the price for chips:");
        chipsPrice = Double.parseDouble(inputStr);
        inputStr = JOptionPane.showInputDialog(null, "Problem #1 - Enter the price for a soda:");
        inputStr = JOptionPane.showInputDialog(null, "Problem #2 - Enter age in months:");
        childAgeMonths = Integer.parseInt(inputStr);
        inputStr = JOptionPane.showInputDialog(null, "Problem #3 - Enter retail price of item:");
        itemPrice = Double.parseDouble(inputStr);

        inputStr = JOptionPane.showInputDialog(null, "Problem #4 - Enter circle radius [m]:");
        radius = Double.parseDouble(inputStr);

        inputStr = JOptionPane.showInputDialog(null, "Problem #5 - Enter number of hits:");
        hits = Integer.parseInt(inputStr);
        inputStr = JOptionPane.showInputDialog(null, "Problem #6 - Enter number of at-bats:");
        atBats = Integer.parseInt(inputStr);

        inputStr = JOptionPane.showInputDialog(null, "Problem #7 - Enter starting 1st item quantity:");
        item1Inventory = Integer.parseInt(inputStr);
        inputStr = JOptionPane.showInputDialog(null, "Problem #8 - Enter starting 2nd item quantity:");
        inputStr = JOptionPane.showInputDialog(null, "Problem #8 - Enter 2nd item delivery quantity:");
        deliveryAmount = Integer.parseInt(inputStr);

        // Problem 1: Add up the total prices for Lunch
        totalLunchPrice = sandwichPrice + chipsPrice + sodaPrice;
        outputStr = String.format("1) Lunch price before tax is: $%.2f\n", totalLunchPrice);
        JOptionPane.showMessageDialog(null, outputStr);

        // Problem 2: Calculates the child's years in whole numbers
        traditionalAgeYears = childAgeMonths / MONTHS_PER_YEAR;
        outputStr = String.format("2) %5d month old in whole years: %d Years Old\n", childAgeMonths, traditionalAgeYears);
        JOptionPane.showMessageDialog(null, outputStr);

        // Problem 3: Calculates the left over months after the whole number
        addedMonths = childAgeMonths % MONTHS_PER_YEAR;
        outputStr = String.format("3) %d month old in added months: %d Years and %d Months Old\n", childAgeMonths, traditionalAgeYears, addedMonths);
        JOptionPane.showMessageDialog(null, outputStr);

        // Problem 4: Calculates the salesTax by multiplying itemPrice by taxRate
        salesTax = itemPrice * TAX_RATE;
        outputStr = String.format("4) Tax on $%.2f is: $%.2f\n", itemPrice, salesTax);
        JOptionPane.showMessageDialog(null, outputStr);

        // Problem 5: Calculates the area for pi
        System.out.printf("5) r= %.1f circle area [m^2] =", radius);
        System.out.printf("%.4f m^2\n", area);

        // Problem 6: Calculates the battingAvg by dividing hits by atBats
        System.out.printf("6) %d hits, %d at-bats batting average is =", hits, atBats);
        System.out.printf("%.3f\n", battingAvg);

        // Problem 7: Calculates new inventory after one sale
        System.out.printf("7a) Starting Inventory for item 1 is: %d\n", item1Inventory);
        item1Inventory--;
        System.out.printf("7b) New Inventory for item 1 is: %d\n", item1Inventory);

        // Problem 8: Calculates new inventory after Amazon Prime includes 45 additional item2s
        System.out.printf("8a) Starting Inventory for item 2 is: %d\n", item2Inventory);
        item2Inventory += deliveryAmount;
        System.out.printf("8b) New Inventory for item 2 is: %d\n", item2Inventory);
    }
    
}
