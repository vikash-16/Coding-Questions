/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 *
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */
int* repeatedNumber(const int* A, int n1, int *len1) {
    long long sum_1 = 0;
    long long sum_2 = 0;
    long long sum1;
    long long sum2;
    long long m;
    long long r;
    long long q;
    long long p;
    int *arr;
    long long i;
    arr = (int *)malloc(2 * sizeof(int));

    for ( i = 0; i < n1; i++) {
        sum_1 = sum_1 + (long long)A[i];
        sum_1 -= i+1;
    }

    for ( i = 0; i < n1; i++) {
        sum_2 = sum_2 + (long long)A[i] * (long long)A[i];
        sum_2 -= (i+1)*(i+1);
    }
 p = -1 * sum_1;
    q = -1 * (sum_2/p);

    m = (p + q) / 2;
    r = q - m;
    arr[0] = (int)r;
    arr[1] = (int)m;
    *len1 = 2;

    return arr;
    }
