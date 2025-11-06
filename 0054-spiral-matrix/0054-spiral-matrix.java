class Solution 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        if(matrix.length==0)
        return  new ArrayList<>();

        final int m = matrix.length , n = matrix[0].length;

        List<Integer> ans = new ArrayList<>();

        int r1=0,c1=0,r2=m-1,c2=n-1;

        while(ans.size()<m*n)
        {
            for(int j=c1;j<=c2 && ans.size()<m*n;++j)
                ans.add(matrix[r1][j]);
            for(int i=r1+1;i<=r2-1 && ans.size()<m*n;++i)
                ans.add(matrix[i][c2]);
            for(int j=c2;j>=c1 && ans.size()<m*n;--j)
                ans.add(matrix[r2][j]);
            for(int i=r2-1;i>=r1+1 && ans.size()<m*n;--i)
                ans.add(matrix[i][c1]);

            ++c1;
            --c2;
            ++r1;
            --r2;


        }

        return ans;
    }
}