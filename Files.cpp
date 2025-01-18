#include <iostream>
#include <fstream>
#include <string>

using namespace std;

class Logger {
private:
    ofstream logFile;
public:
    Logger(const string& logFileName) {
        logFile.open(logFileName);
        if (!logFile.is_open()) {
            throw runtime_error("Failed to open log file.");
        }
    }

    //Destructor. Checks and closes the file
    ~Logger() {
        if (logFile.is_open()) {
            logFile.close();
        }
    }

    template <typename T>
    Logger& operator<<(const T& data) {
        cout << data;
        logFile << data;
        return *this;
    }

    //Overload << operator 
    Logger& operator<<(ostream& (*os)(ostream&)) {
        cout << os;
        logFile << os;
        return *this;
    }
};

// Overload == operator for string comparison
bool operator==(const string& line1, const string& line2) {
    return line1.compare(line2) == 0;
}

class Files {
private:
    string file1Name, file2Name, logFileName;
    ifstream file1, file2;
    Logger logger;

public:
    // Constructor
    Files(const string& f1, const string& f2, const string& logFile)
        : file1Name(f1), file2Name(f2), logFileName(logFile), logger(logFileName) {
        openFiles();
    }

    // Open files
    void openFiles() {
        file1.open(file1Name);
        file2.open(file2Name);
        if (!file1.is_open()) {
            throw runtime_error("Failed to open file: " + file1Name);
        }
        if (!file2.is_open()) {
            throw runtime_error("Failed to open file: " + file2Name);
        }
    }

    // Compare files line by line
    void compareFiles() {
        string line1, line2;
        int lineNumber = 0;
        while (true) {
            bool file1End = !getline(file1, line1);
            bool file2End = !getline(file2, line2);

            if (file1End && file2End) {
                logger << "Files are identical." << endl;
                break;
            } else if (file1End) {
                logger << "File " << file1Name << " is shorter." << endl;
                break;
            } else if (file2End) {
                logger << "File " << file2Name << " is shorter." << endl;
                break;
            }

            lineNumber++;
            if (!(line1 == line2)) {
                logger << "Difference found at line " << lineNumber << ":" << endl;
                logger << "File1: " << line1 << endl;
                logger << "File2: " << line2 << endl;
                break;
            }
        }
    }
};

int main() {
    
    //grabs user input and checks for exception
    try {
        string file1Name, file2Name;
        cout << "Enter the name of the first file: ";
        cin >> file1Name;
        cout << "Enter the name of the second file: ";
        cin >> file2Name;

        // Create Files object and compare files
        Files files(file1Name, file2Name, "log.txt");
        files.compareFiles();

    } catch (const exception& e) {
        cout << "Error: " << e.what() << endl;
    }

    return 0;
}
