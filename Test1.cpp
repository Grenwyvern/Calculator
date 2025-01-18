#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

class BankAccount {
private:
    string accNbr;
    double balance;

public:
    BankAccount(string accNbr, double balance) {
        this->accNbr = accNbr;
        this->balance = balance;
    }

    string getAcc() const {
        return accNbr;
    }

    double getBalance() const {
        return balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (balance - amount >= 1) {
            balance -= amount;
        } else {
            cout << "You are withdrawing too much: try again\n" << endl;
        }
    }
};

class Bank {
private:
    int totalAccount;
    int capacity;  // Dynamic capacity for resizing
    BankAccount** accounts;  // Dynamically allocated array of BankAccount pointers

    void resizeArray() {
        // Double the capacity when the array is full
        capacity *= 2;
        BankAccount** newAccounts = new BankAccount*[capacity];
        for (int i = 0; i < totalAccount; i++) {
            newAccounts[i] = accounts[i];
        }
        delete[] accounts;
        accounts = newAccounts;
    }

public:
    Bank() {
        totalAccount = 0;
        capacity = 10;  // Initial capacity
        accounts = new BankAccount*[capacity];  // Dynamically allocate the array
    }

    ~Bank() {
        deleteObjects();
        delete[] accounts;  // Free the dynamically allocated array itself
    }

    void bankMenu() {
        int currentIndex = -1;
        char userSelection;
        BankAccount* currentAccount = nullptr;
        bool quit = false;

        do {
            // Print menu options first
            printMenu();

            // Display the current account selected or indicate none selected
            if (currentAccount) {
                cout << "\nCurrent account selected: " << currentAccount->getAcc()
                     << fixed << setprecision(2) << "  Balance: $" << currentAccount->getBalance() << endl;
            } else {
                cout << "\nCurrent account selected: NONE" << endl;
            }

            // Get user command
            cout << "\nEnter Command: ";
            cin >> userSelection;

            string accNbr;

            switch (userSelection) {
                case 'O':
                    currentAccount = openAcc();
                    if (currentAccount) {
                        accounts[totalAccount] = currentAccount;
                        currentIndex = totalAccount;
                        totalAccount++;
                    }
                    break;

                case 'D':  // Deposit
                    if (currentAccount != nullptr) {
                        double depositAmount;
                        cout << "Enter amount of deposit: ";
                        cin >> depositAmount;
                        currentAccount->deposit(depositAmount);
                        cout << "Deposit successful. New balance: $" << currentAccount->getBalance() << endl;
                    } else {
                        cout << "Please select an account." << endl;
                    }
                    break;

                case 'S':  // Select an account
                    if (totalAccount == 0) {
                        cout << "No accounts available." << endl;
                        break;
                    }

                    cout << "Enter account number: ";
                    cin >> accNbr;

                    currentIndex = -1;

                    for (int i = 0; i < totalAccount; i++) {
                        if (accounts[i]->getAcc() == accNbr) {
                            currentIndex = i;
                            currentAccount = accounts[currentIndex];
                            cout << "Account selected: " << currentAccount->getAcc() << endl;
                            break;
                        }
                    }

                    if (currentIndex == -1) {
                        cout << "Account number was not found." << endl;
                    }
                    break;

                case 'C':
                    if (currentAccount != nullptr) {
                        closeAcc(currentIndex);
                        currentAccount = nullptr;  // Deselect account after closing
                    } else {
                        cout << "Please select an account\n" << endl;
                    }
                    break;

                case 'W':  // Withdraw
                    if (currentAccount != nullptr) {
                        double amount;
                        cout << "Enter amount to withdraw: ";
                        cin >> amount;
                        currentAccount->withdraw(amount);
                    } else {
                        cout << "No account selected." << endl;
                    }
                    break;

                case 'L':  // List all accounts
                    listAccounts();
                    break;

                case 'Q':  // Quit
                    deleteObjects();
                    quit = true;
                    cout << "Code terminated. Goodbye";
                    break;

                default:
                    cout << "Improper input. Please try again." << endl;
                    break;
            }
        } while (!quit);
    }

    void printMenu() {  // Print menu options
        cout << "O: Open account\n";
        cout << "D: Deposit\n";
        cout << "S: Select account\n";
        cout << "C: Close account\n";
        cout << "W: Withdraw\n";
        cout << "L: List all accounts\n";
        cout << "Q: Quit\n";
    }

    BankAccount* openAcc() {
        string accNbr;
        double initialBalance;
        bool valid = false;

        do {
            cout << "Enter new account number: ";
            cin >> accNbr;

            bool duplicate = false;
            for (int i = 0; i < totalAccount; i++) {
                if (accounts[i] && accounts[i]->getAcc() == accNbr) {
                    cout << "Account duplication is not allowed. Please try again." << endl;
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                cout << "Enter initial balance: ";
                cin >> initialBalance;

                if (initialBalance >= 0) {
                    valid = true;
                } else {
                    cout << "Initial Balance must be positive." << endl;
                }
            }
        } while (!valid);

        if (totalAccount >= capacity) {
            resizeArray();
        }

        BankAccount* newAccount = new BankAccount(accNbr, initialBalance);
        return newAccount;
    }

    void listAccounts() {
        if (totalAccount == 0) {
            cout << "No accounts available." << endl;
        } else {
            double totalAssets = 0;
            for (int i = 0; i < totalAccount; i++) {
                if (accounts[i]) {
                    cout << i + 1 << ") Acct #: " << accounts[i]->getAcc()
                         << "   Bal: $" << fixed << setprecision(2) << accounts[i]->getBalance() << endl;
                    totalAssets += accounts[i]->getBalance();
                }
            }
            cout << "\nTotal Bank assets: $" << fixed << setprecision(2) << totalAssets << endl << "\n";
        }
    }

    void closeAcc(int index) {
        if (index >= 0 && index < totalAccount) {
            cout << "Closing account: " << accounts[index]->getAcc() << endl;

            // Delete the selected account
            delete accounts[index];

            if (index != totalAccount - 1) {
                accounts[index] = accounts[totalAccount - 1];
            }

            accounts[totalAccount - 1] = nullptr;
            totalAccount--;

            // After closing, there is no current account selected
            cout << "Account closed. No current account selected." << endl;
        } else {
            cout << "Invalid account selection." << endl;
        }
    }

    void deleteObjects() {  // Delete all dynamically allocated accounts
        for (int i = 0; i < totalAccount; i++) {
            delete accounts[i];
            accounts[i] = nullptr;
        }
        totalAccount = 0;
    }
};

int main() {
    Bank bank;
    bank.bankMenu();
    return 0;
}
