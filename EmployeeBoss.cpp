#include <iostream>
#include <string>
using namespace std;

// Address class definition
class Address {
private:
    string city;
    string state;

public:
    // Default constructor
    Address() : city(""), state("") {}

    // Constructor with parameters
    Address(string cityName, string stateName) : city(cityName), state(stateName) {}

    // Getter and Setter for city
    void setCity(const string& cityName) { city = cityName; }
    string getCity() const { return city; }

    // Getter and Setter for state
    void setState(const string& stateName) { state = stateName; }
    string getState() const { return state; }

    /* Gathers full input using getline and finds the location of the comma between city and state */
    void grabAddr() {
        string input;
        cout << "Enter your city and state separated by a comma: ";
        getline(cin, input);

        size_t commaPos = input.find(',');
        if (commaPos != string::npos) {
            city = input.substr(0, commaPos);
            state = input.substr(commaPos + 1);
        }
    }

    // Display method for city/state
    void display() const {
        cout << "City: " << city << endl;
        cout << "State: " << state << endl;
    }
};

// Employee class definition
class Employee {
private:
    string fName;
    string lName;
    Employee* boss;
    Address* addr;
    static int count;  // Private count variable

public:
    // Default constructor
    // Increment count whenever the default constructor is called
    Employee() : fName(""), lName(""), boss(nullptr), addr(nullptr) {
        count++;
    }

    // Constructor #1: Initializes first name and last name
    Employee(string first, string last) 
    : fName(first), lName(last), boss(nullptr), addr(nullptr) {
        count++;
    }

    // Constructor #2:
    // Calls Constructor #1
    Employee(string first, string last, Employee* b) 
    : Employee(first, last) {
        boss = b;
    }

    // Constructor #3:
    // Calls Constructor #2
    Employee(string first, string last, Employee* b, Address* a)
    : Employee(first, last, b) {
        addr = a;
    }

    // Getter and Setter for fName
    void setFirstName(const string& firstName) { fName = firstName; }
    string getFirstName() const { return fName; }

    // Getter and Setter for lName
    void setLastName(const string& lastName) { lName = lastName; }
    string getLastName() const { return lName; }

    // Getter and Setter for boss
    void setBoss(Employee* b) { boss = b; }
    Employee* getBoss() const { return boss; }

    // Getter and Setter for address
    void setAddr(Address* a) { addr = a; }
    Address* getAddr() const { return addr; }

    // Display method for Employee
    void display() const {
        cout << "First Name: " << fName << endl;
        cout << "Last Name: " << lName << endl;
        if (addr != nullptr) {
            addr->display();
        }
    }

    //Finds the comma between the first and last name
    //Returns with either npos/no position or the correct output for first and last name
    void grabName() {
        string input;
        cout << "Enter your first name and last name separated by a comma: ";
        getline(cin, input);

        size_t commaPos = input.find(',');
        if (commaPos != string::npos) {
            fName = input.substr(0, commaPos);
            lName = input.substr(commaPos + 1);
        }
    }

    // Getter for count (specific to this Employee object)
    static int getCount() {
        return count;
    }
};

int Employee::count = 0;

// Main function
int main() {
    Employee emp; emp.grabName();
    Address addr; addr.grabAddr();
    emp.setAddr(&addr);
    emp.display();

    Employee emp1; emp1.grabName();
    Address addr1; addr1.grabAddr();
    emp1.setAddr(&addr1);
    emp1.setBoss(&emp);
    emp1.display();

    Employee emp2; emp2.grabName();
    Address addr2; addr2.grabAddr();
    emp2.setAddr(&addr2);
    emp2.setBoss(&emp);
    emp2.display();

    cout << "Total Employees created: " << Employee::getCount() << endl;

    return 0;
}
