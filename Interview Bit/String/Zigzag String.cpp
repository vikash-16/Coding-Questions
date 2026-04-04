The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
**Example 2 : **
ABCD, 2 can be written as

A....C
...B....D




*****solution::


string Solution::convert(string A, int B) {
    if(B==1) {
        return A;
    }
    string res[B];
    int row = 0;
    string dir = "down";
    for(int i = 0; i< A.size(); i++) {
        res[row].push_back(A[i]);
        if(row == 0) {
            dir = "down";
        }
        if(row == B-1) {
            dir = "up";
        }
        if(dir == "down") {
            row++;
        }else {
            row--;
        }
    }
    string result;
    for(int i = 0; i < B; i++) {
        result+= res[i];
    }
    return result;
}

