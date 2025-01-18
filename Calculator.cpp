#include <iostream>

using namespace std;

class Calculator {
    public:
        int input1;
        int input2;
        char choice;
        bool quit = false;
        int output = 0;

    void compute () {

        do {
            menu();
            cout << "\nWhich operation would you like: ";
            cin >> choice;
            choice = toupper(choice);

            switch (choice) {
                case 'M':
                    cout << "Enter first number: ";
                    cin >> input1;
                    cout << "Enter second number: ";
                    cin >> input2;
                    output = multiply(input1, input2);
                    break;

                case 'D':
                    cout << "Enter first number: ";
                    cin >> input1;
                    cout << "Enter second number: ";
                    cin >> input2;
                    division(input1, input2);
                    break;

                case 'A':
                    cout << "Enter first number: ";
                    cin >> input1;
                    cout << "Enter second number: ";
                    cin >> input2;
                    addition(input1, input2);
                    break;

                case 'S':
                    cout << "Enter first number: ";
                    cin >> input1;
                    cout << "Enter second number: ";
                    cin >> input2;
                    subtraction(input1, input2);
                    break;

                case 'Q':
                    quitProgram();
                    break;

                default:
                    cout << "Error \n";
                    break;
            }

        } 
        
        while(!quit);

        

    }

    void menu() {
        cout << "\nM: Multiplication\n";
        cout << "D: Division\n";
        cout << "A: Addition\n";
        cout << "S: Subtraction\n";
        cout << "Q: Quit\n";
    }

    double multiply(int x, int y) {
        int output = x * y;
        cout << x << " x " << y << " = " << output << "\n";

        return output;

    }

    void division(int x, int y) {
        int output = 0;
        output = (x / y);
        cout << x << " / " << y << " = " << output << "\n";

    }

    void addition(int x, int y) {
        int output = 0;
        output = input1 + input2;
        cout << input1 << " + " << input2 << " = " << output << "\n";

    }

    void subtraction(int x, int y) {
        int output = 0;
        output = input1 - input2;
        cout << input1 << " - " << input2 << " = " << output << "\n";

    }

    void quitProgram() {
        cout << "command terminated\n";
        quit = true;
    }

};

int main () {
    Calculator calc;
    calc.compute();
return 0;

}