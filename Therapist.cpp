#include <iostream>
#include <string>

using namespace std;

class Therapist {
    private:

    public:
    
    void conversation() {
        string input; 

        cout << "\nHi there. Thanks for clicking on me. \nWould you like to talk about anything? ";
        cin >> input;
        getline(cin, input);

        if (input.length() != 2) {
            cout << "Okay. What would you like to talk about?";
            getline(cin, input);
        }


        
    }
};

int main() {
    Therapist therapist;
    therapist.conversation();

    return 0;
}