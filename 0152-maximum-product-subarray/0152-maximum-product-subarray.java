class Solution {
    public int maxProduct(int[] nums) 
    {
        int ans = nums[0];
        int dpMin = nums[0];
        int dpMax = nums[0] ;
        
        for(int i= 1;i<nums.length;i++)
        {
            final int num = nums[i];
            final int prevMin = dpMin;
            final int prevMax = dpMax;
            if(num<0)
            {
                dpMin = Math.min(num,prevMax*num);
                dpMax = Math.max(num,prevMin*num);
            }
            else
            {
                dpMin = Math.min(num,prevMin*num);
                dpMax = Math.max(num,prevMax*num);
            }

            ans = Math.max(ans,dpMax);

        }

        return ans;



    }
}