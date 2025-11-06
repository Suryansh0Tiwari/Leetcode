bool isScramble(char* s1, char* s2) 
{
    int n = strlen(s1);
    if (n != strlen(s2)) return false;
    
    bool dp[n + 1][n][n];
    memset(dp, false, sizeof(dp));
    
    for (int len = 1; len <= n; ++len) 
    {
        for (int i = 0; i + len <= n; ++i) 
        {
            for (int j = 0; j + len <= n; ++j) 
            {
                if (len == 1) 
                {
                    dp[len][i][j] = (s1[i] == s2[j]);
                } 
                else 
                {
                    for (int k = 1; k < len; ++k) 
                    {
                        dp[len][i][j] |= (dp[k][i][j] && dp[len - k][i + k][j + k]);
                        dp[len][i][j] |= (dp[k][i][j + len - k] && dp[len - k][i + k][j]);
                    }
                }
            }
        }
    }
    
    return dp[n][0][0];
}
