Given an integer A, convert it to a roman numeral, and return a string corresponding to its roman numeral version

 Note : This question has a lot of scope of clarification from the interviewer. Please take a moment to think of all the needed clarifications and see the expected response using “See Expected Output” For the purpose of this question, https://projecteuler.net/about=roman_numerals has very detailed explanations.


Input Format

The only argument given is integer A.
Output Format

Return a string denoting roman numeral version of A.
Constraints

1 <= A <= 3999
For Example

Input 1:
    A = 5
Output 1:
    "V"

Input 2:
    A = 14
Output 2:
    "XIV"




********solution::



pair<int,string> maxnum(map<int,string>&ump,int A) {
    pair<int,string>maximum;
    for(auto it = ump.begin(); it != ump.end(); it++) {
        if(it->first <= A) {
            maximum.first = it->first;
            maximum.second = it->second;
        }
    }
    return make_pair(maximum.first,maximum.second);
}
string Solution::intToRoman(int A) {
    map<int,string>ump;
    ump.insert( {1,"I"} );
    ump.insert( {4,"IV"} );
    ump.insert( {5,"V"} );
    ump.insert( {9,"IX"} );
    ump.insert( {10,"X"} );
    ump.insert( {40,"XL"} );
    ump.insert( {50,"L"} );
    ump.insert( {90,"XC"} );
    ump.insert( {100,"C"} );
    ump.insert( {400,"CD"} );
    ump.insert( {500,"D"} );
    ump.insert( {900,"CM"} );
    ump.insert( {1000,"M"} );
    ump.insert( {4000,"MMMM"} );
    string result = "";
    while(A != 0) {
        pair<int,string>num = maxnum(ump,A);
        result += num.second;
        A -= num.first;
    }
    return result;
}
