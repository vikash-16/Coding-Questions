Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d]

If a < c OR a==c AND b < d.

******solution:

bool isprime(int a) {
    if(a == 1){
        return false;
    }
    for(int i = 2; i <= floor(sqrt(a));i++) {
        if(a % i == 0) {
            return false;
        }
    }
    return true;
}
vector<int> Solution::primesum(int A) {
    vector<int>res;
    if(A == 2)
        return res;
    for(int i = 2; i <=A/2;i++) {
        if(isprime(i) && isprime(A-i)) {
            res.push_back(i);
            res.push_back(A-i);
            break;
        }
    }
    return res;
}

