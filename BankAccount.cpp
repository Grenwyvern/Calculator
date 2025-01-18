#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

class BankAccount {
private:
    //Ensuring variables to be private
    string accNbr;
    double balance;

public:
    BankAccount(string accNbr, double balance) {

        //Initializing variables using pointer notation
        this->accNbr = accNbr;
        this->balance = balance;
    }

    //getter for account
    string getAcc() const {
        return accNbr;
    }

    //getter for balance
    double getBalance() const {
        return balance;
    }

    //Adds amount to balance no matter how big it is
    void deposit(double amount) {
        balance += amount;
    }

    //Withdraws the amount from balance ONLY if there is at least 1 dollar left in the account
    void withdraw(double amount) {
        if (balance - amount >= 1) {
            balance -= amount;
        } 
        
        else {
            cout << "You are withdrawing too much: try again\n" << endl;
        }
    }
};

class Bank {
private:
    int totalAccounts;
    int capacity;  // Dynamic capacity for resizing
    BankAccount** accounts;  // Dynamically allocated array of BankAccount pointers

    void resizeArray() {
        // Double the capacity when the array is full
        capacity *= 2;

        //Setting up an array of pointers with the current size of the variable capacity
        BankAccount** newAccounts = new BankAccount*[capacity];
        for (int i = 0; i < totalAccounts; i++) {
            newAccounts[i] = accounts[i];
        }
        delete[] accounts;
        accounts = newAccounts;
    }

public:
    Bank() {
        totalAccounts = 0;
        capacity = 10;  // Initial capacity

        //Sets up a new array of pointers with a size of the variable capacity
        accounts = new BankAccount*[capacity];
    }

    //Destructor calls the deleteObjects method to delete all objects
    //Deallocates the accounts array
    ~Bank() {
        deleteObjects();
        delete[] accounts;
    }

    void bankMenu() {
        int currentIndex = -1;
        char userSelection;
        BankAccount* currentAccount = nullptr;  //Bank Account object pointing to nullptr
        bool quit = false;

        do {
            // Print menu options first
            printMenu(currentIndex);

            //Checks if the currentAccount is not nullptr
            //Displys theh current account and balance of the Bank Account
            if (currentAccount) {
                cout << "\nCurrent account selected: " << currentAccount->getAcc()
                     << "  Balance: $" << fixed << setprecision(2) << currentAccount->getBalance() << endl;
            } 
            
            else {
                cout << "\nCurrent account selected: NONE" << endl;
            }

            // Get user command
            cout << "\nEnter Command: ";
            cin >> userSelection;
            userSelection = toupper(userSelection); //Takes input no matter lowercase or uppercase

            switch (userSelection) {
                case 'O':  // Open account
                    currentAccount = openAcc();

                    //Checks to currentAccount is not nullptr
                    if (currentAccount) {
                        if (totalAccounts >= capacity) {
                            resizeArray();
                        }

                        //Adds currentAccount to the total accounts list
                        //Selects the account by setting currentIndex to totalAccounts
                        //Increments the maximum amount accounts (totalAccounts) by 1
                        accounts[totalAccounts] = currentAccount;
                        currentIndex = totalAccounts;
                        totalAccounts++;
                    }
                    break;

                case 'D':  // Deposit
                    if (currentAccount != nullptr) {
                        double depositAmount;
                        cout << "Enter deposit amount: ";
                        cin >> depositAmount;
                        currentAccount->deposit(depositAmount);
                        cout << "New balance: $" << currentAccount->getBalance() << endl;
                    } 
                    
                    else {
                        cout << "Please select an account." << endl;
                    }
                    break;

                case 'S':  // Select account
                    currentIndex = selectAcc();

                    //Checks if account exists
                    if (currentIndex != -1) {
                        currentAccount = accounts[currentIndex];
                    }
                    break;

                case 'C':  // Close account
                    if (currentAccount != nullptr) {
                        closeAcc(currentIndex);
                        currentAccount = nullptr;  //Deselects account
                    } 
                    
                    else {
                        cout << "Please select an account" << endl;
                    }
                    break;

                case 'W':  // Withdraw
                    if (currentAccount != nullptr) {
                        double amount;
                        cout << "Enter amount to withdraw: ";
                        cin >> amount;
                        currentAccount->withdraw(amount);
                    } 
                    
                    else {
                        cout << "No account selected." << endl;
                    }
                    break;

                case 'L':  // List all accounts
                    listAccounts();
                    break;

                case 'Q':  // Quit
                    deleteObjects();
                    quit = true;
                    cout << "Code terminated. Goodbye" << endl;
                    break;

                default:
                    cout << "Invalid input. Try again." << endl;
                    break;
            }
        } while (!quit);
    }

    void printMenu(int index) {
        cout << "O: Open Account\n";
        cout << "D: Deposit\n";
        cout << "S: Select Account\n";
        cout << "C: Close Account\n";
        cout << "W: Withdraw\n";
        cout << "L: List All Accounts\n";
        cout << "Q: Quit\n";
    }

    BankAccount* openAcc() {
        string accNbr;  //Redeclares variable in this scope
        double initialBalance;
        bool valid = false;

        do {
            cout << "Enter new account number: ";
            cin >> accNbr;

            // Check for duplicate account number
            bool duplicate = false;

            //Checks if the Bank Account is set to null
            //Checks if the user input for account number matches anything with the array
            for (int i = 0; i < totalAccounts; i++) {
                if (accounts[i] && accounts[i]->getAcc() == accNbr) {
                    cout << "Account duplication is not allowed. Please try again." << endl;
                    return nullptr;
                }
            }
            
            cout << "Enter initial balance: ";
            cin >> initialBalance;  //Gathers user input for initial balance

            if (initialBalance >= 0) {
                valid = true;  //Ensures initial balance is positive
            } 
                
            else {
                cout << "Initial Balance must be positive." << endl;
            }
            
        } while (!valid);

        //returns new Bank Account with account number and initial balance
        return new BankAccount(accNbr, initialBalance);
    }

    void listAccounts() {

        //Displays message if no accounts have been created yet
        if (totalAccounts == 0) {
            cout << "No accounts have been created yet." << endl;
        } 
        
        else {
            double totalAssets = 0;

            //Ensures the Bank Account isn't set to null
            //Displays bank information as instructions say to do
            for (int i = 0; i < totalAccounts; i++) {
                if (accounts[i]) {
                    cout << i + 1 << ") Acct #: " << accounts[i]->getAcc() << "   Bal: $" << fixed << setprecision(2) << accounts[i]->getBalance() << endl;
                    totalAssets += accounts[i]->getBalance();
                }
            }
            cout << "\nTotal Bank assets: $" << fixed << setprecision(2) << totalAssets << endl;
        }
    }

    int selectAcc() {
        string accNbr;  //redeclaring variable in this scope. No global variables allowed
        cout << "Enter account number: ";
        cin >> accNbr;

        //Checks to see if user input for account number matches anything within the array
        for (int i = 0; i < totalAccounts; i++) {
            if (accounts[i]->getAcc() == accNbr) {
                cout << "Account selected: " << accounts[i]->getAcc() << endl;
                return i;
            }
        }

        cout << "Account not found." << endl;
        return -1;
    }

    void closeAcc(int index) {

        //Checks if account exists. If so, then it closes the account and deletes the memory
        if (index >= 0 && index < totalAccounts) {
            cout << "Closing account: " << accounts[index]->getAcc() << endl;

            delete accounts[index];

            if (index != totalAccounts - 1) {
                accounts[index] = accounts[totalAccounts - 1];
            }

            accounts[totalAccounts - 1] = nullptr;
            totalAccounts--;

            cout << "Account has been closed." << endl;
        } else {
            cout << "Account not found." << endl;
        }
    }

    //Runs through all the account indexes and sets all values to nullptr
    //Sets totalAccounts = 0
    void deleteObjects() {
        for (int i = 0; i < totalAccounts; i++) {
            delete accounts[i];
            accounts[i] = nullptr;
        }
        totalAccounts = 0;
    }
};

int main() {
    Bank bank;
    bank.bankMenu();
    return 0;
}
