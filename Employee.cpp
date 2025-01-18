#include <iostream>
#include <vector>
#include <string>
#include <iomanip>

using namespace std;

// Base class Employee
class Employee {
protected:
    string fname, lname;
    double hrlyPay;

public:
    Employee(string fn, string ln, double pay) : fname(fn), lname(ln), hrlyPay(pay) {}
    virtual ~Employee() {}

    virtual double computePay() const = 0; // Pure virtual function
    virtual void raiseWages(double percentage) {
        hrlyPay *= (1 + percentage / 100);
    }

    virtual void displayInfo() const = 0; // Pure virtual function to display info
    virtual double getBonus() const { return 0; } // Virtual function with default implementation

    string getFname() const { return fname; }
    string getLname() const { return lname; }
};

// Derived class for hourly employees
class HourlyEmployee : public Employee {
private:
    double hoursWorked; //Private data members

public:
    HourlyEmployee(string fn, string ln, double pay, double hours) 
        : Employee(fn, ln, pay), hoursWorked(hours) {}

    double computePay() const override {
        if (hoursWorked <= 40) {
            return hrlyPay * hoursWorked;
        } 
        
        else {
            double overtime = hoursWorked - 40;
            return (hrlyPay * 40) + (hrlyPay * 1.5 * overtime);
        }
    }

    void displayInfo() const override {
        cout << fname << " " << lname << " - Hourly Wage: $" << fixed << setprecision(2) 
             << hrlyPay << "/hour, Weekly Pay: $" << computePay() << endl;
    }
};

// Derived class for salaried employees
class SalariedEmployee : public Employee {
private:
    double bonusAmt;

public:
    SalariedEmployee(string fn, string ln, double annualSalary, double bonus) 
        : Employee(fn, ln, annualSalary / 52 / 40), bonusAmt(bonus) {}

    double computePay() const override {
        return hrlyPay * 40;
    }

    void displayInfo() const override {
        cout << fname << " " << lname << " - Annual Salary: $" << fixed << setprecision(2) 
             << (hrlyPay * 52 * 40) << ", Weekly Pay: $" << computePay() 
             << ", Bonus: $" << bonusAmt << endl;
    }

    double getBonus() const { return bonusAmt; }
};

// Function to display menu and get user command
char displayMenu() {
    cout << "\nN: New employee" << endl;
    cout << "C: Compute paychecks" << endl;
    cout << "R: Raise wages" << endl;
    cout << "L: List all employees" << endl;
    cout << "Q: Quit" << endl;
    cout << "\nEnter command: ";
    
    char command;
    cin >> command;
    return toupper(command);
}

// Main function with switch-case to handle the menu
int main() {
    vector<Employee*> employees;
    char command;
    string name, fName, lName;
    char type;
    double hourlyWage, hours;
    double annualSalary, bonus;
    double percentage;

    do {
        command = displayMenu();

        switch (command) {
            case 'N':
                cout << "Enter name of new employee: ";
                cin.ignore();
                getline(cin, name);

                cout << "Hourly (h) or salaried (s): ";
                cin >> type;

                if (type == 'h') {
                    cout << "Enter hourly wage: ";
                    cin >> hourlyWage;
                    cout << "Enter weekly hours: ";
                    cin >> hours;
                    employees.push_back(new HourlyEmployee(name, "", hourlyWage, hours));
                } 
                
                else if (type == 's') {
                    cout << "Enter annual salary: ";
                    cin >> annualSalary;
                    cout << "Enter yearly bonus amount: ";
                    cin >> bonus;
                    employees.push_back(new SalariedEmployee(name, "", annualSalary, bonus));
                }
                break;
            
            case 'C': 
                for (Employee* emp : employees) {
                    cout << emp->getFname() << " " << emp->getLname()
                         << "\nWeekly Pay: " << fixed << setprecision(2) << emp->computePay() << "\n" << endl;
                }
                break;
            
            case 'R': 
                cout << "Enter percentage increase: ";
                cin >> percentage;
                for (Employee* emp : employees) {
                    emp->raiseWages(percentage);
                    cout << "\nName                     New Wages";
                    cout << "\n---------------          ---------------\n";
                    cout << emp->getFname() << "                 " << emp->computePay() << "\n";
                }
                break;
            
            case 'L': 
                cout << "\nName                     hourly wages                Bonus" << endl;
                cout << "------                     -------------               -----" << endl;
                for (Employee* emp : employees) {
                    // Display name in "Last, First" format
                    cout << emp->getLname() << emp->getFname();

                    // Simple spacing to align hourly wages after name
                    cout << "                 " << emp->computePay() << "/hour";

                    // Conditional display of bonus
                    if (emp->getBonus() > 0) {
                        cout << "                $" << emp->getBonus();
                    }
                    
                cout << endl;
            }
            break;
            
            case 'Q':
                cout << "Exiting the program." << endl;
                break;
            default:
                cout << "Invalid command. Please try again." << endl;
        }
    } while (command != 'Q');

    // Clean up dynamically allocated Employee objects
    for (Employee* emp : employees) {
        delete emp;
    }

    return 0;
}
