int countSubSets (int [] arr, int N, int diff) {
    int sum = 0;
    for (int i = 0 ; i < N ; i++)
        sum += arr[i];    

    int currSum = 0;
    return getCount (arr, N-1, diff, currSum, sum)
}

//brute-force approach
int getCount (int [] arr, int n, int diff, int currSum, sum) {
    if (n == 0 || sum - currSum > diff) {
        if (sum - currSum == diff)
            return 1;
        return 0;
    }


    return getCount (arr, n-1, diff, currSum, sum) + getCount (arr, n-1, diff, currSum+arr[n], sum);
} 