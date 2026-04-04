Given a string A representing a roman numeral.
Convert A into integer.

A is guaranteed to be within the range from 1 to 3999.

NOTE: Read more
details about roman numerals at Roman Numeric System



Input Format

The only argument given is string A.
Output Format

Return an integer which is the integer verison of roman numeral string.
For Example

Input 1:
    A = "XIV"
Output 1:
    14

Input 2:
    A = "XX"
Output 2:
    20



******solution::



int Solution::romanToInt(string A) {
    unordered_map<char,int>ump;
    ump.insert( {'I',1} );
    ump.insert( {'V',5} );
    ump.insert( {'X',10} );
    ump.insert( {'L',50} );
    ump.insert( {'C',100} );
    ump.insert( {'D',500} );
    ump.insert( {'M',1000} );
    int res = 0;
    for(int i = 0; i < A.length();i++) {
        if(ump[A[i]] >= ump[A[i+1]]) {
            res = res+ump[A[i]];
        }else {
            res = res-ump[A[i]];
        }
    }
    return res;
}

