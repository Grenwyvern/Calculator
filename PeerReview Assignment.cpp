#include <iostream>
using namespace std;

void menu();
void cis66(int students[5][3], int& studentCount);
void displayCis66(int students[5][3], int studentCount);
bool duplicateCheck(int studentID, int students[5][3], int studentCount);
char letterGrade(double average);

int main() {
    const int MAX_STUDENTS = 5;
    int students[MAX_STUDENTS][3]; // 5x3 array for storing student ID, midterm, and final grades
    int studentCount = 0; // Number of students added
    int choice; // Variable to store user input
    
    do {
        //Ensures the correct function is called depending on the option that is selected
        menu();
        cin >> choice;

        //Gathers user input
        if (choice == 1) {
            cis66(students, studentCount);
        } 
        else if (choice == 2) {
            displayCis66(students, studentCount);
        } 
        else if (choice != 3) {
            cout << "Invalid choice, please try again" << endl;
        }

    } while (choice != 3);
    
    cout << "Shutting down" << endl;

    return 0;
}

//Displays menu with 1st and 2nd option pushed out
void menu() {
    
    cout << "Record Grades" << endl;
    cout << "\t1) CIS66";
    cout << "\t2) Quit" << endl;
    cout << "What is your choice: ";
}

void option(int students[5][3], int& studentCount) {

    int choice;
    cin >> choice;

    switch (choice) {
        case 1: 
            cis66(students, studentCount);
            break;
        case 2:
            displayCis66(students, studentCount);
            break;
        default:
            cout << "Invalid. Please try again." << endl;   
    }
}

void cis66(int students[5][3], int& studentCount) {
    int studentID, midtermGrade, finalGrade;

    // Check if max number of students is reached
    if (studentCount >= 5) {
        cout << "Maximum number of students reached!" << endl;
        return;
    }

    // Get the student ID
    do {
        cout << "What is the Student ID ? ";
        cin >> studentID;

        if (studentID < 1 || studentID > 50) {
            cout << "Must be in the range of 1 and 50\n";
        }
        else if (duplicateCheck(studentID, students, studentCount)) {
            cout << "Duplicate ID :Try again.\n";
        }
    } while (studentID < 1 || studentID > 50 || duplicateCheck(studentID, students, studentCount));

    students[studentCount][0] = studentID; // Store student ID

    // Get midterm grade
    do {
        cout << "What is the score for the midterm ? ";
        cin >> midtermGrade;
        if (midtermGrade < 0 || midtermGrade > 100) {
            cout << "range must be between 0 and 100\n";
        }
    } while (midtermGrade < 0 || midtermGrade > 100);

    students[studentCount][1] = midtermGrade; // Store midterm grade

    // Get final grade
    do {
        cout << "What is the score for the Final ? ";
        cin >> finalGrade;
        if (finalGrade < 0 || finalGrade > 100) {
            cout << "Must be between 0 and 100\n";
        }
    } while (finalGrade < 0 || finalGrade > 100);

    students[studentCount][2] = finalGrade; // Store final grade

    studentCount++; // Increase student count after successful input
}

bool duplicateCheck(int studentID, int students[5][3], int studentCount) {
    for (int i = 0; i < studentCount; i++) {
        if (students[i][0] == studentID) {
            return true; // Duplicate found
        }
    }
    return false; // No duplicates
}

bool rangeCheck(int value, int min, int max) {
    return ((value >= min) && (value <= max));
}

char letterGrade(double average) {
    if (average >= 90) {
        return 'A';
    } else if (average >= 80) {
        return 'B';
    } else if (average >= 70) {
        return 'C';
    } else if (average >= 60) {
        return 'D';
    } else {
        return 'F';
    }
}

void displayCis66(int students[5][3], int studentCount) {
    if (studentCount == 0) {
        cout << "No students to display!" << endl;
        return;
    }

    cout << "\nStudentID\tMid\tFinal\tGrade" << endl;
    cout << "----------------------------------" << endl;

    for (int i = 0; i < studentCount; i++) {
        int studentID = students[i][0];
        int midtermScore = students[i][1];
        int finalScore = students[i][2];

        double average = (midtermScore + finalScore) / 2.0; // Calculate the average score
        char grade = letterGrade(average); // Get the corresponding letter grade

        // Display the student info
        cout << studentID << "\t\t" << midtermScore << "\t" << finalScore << "\t" << grade << endl;
    }
}
