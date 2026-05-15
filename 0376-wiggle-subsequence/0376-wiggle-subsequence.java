class Solution {
    public int wiggleMaxLength(int[] nums) {
        int h=1,l=1;

        for(int i=1;i<nums.length;++i)
            if(nums[i]>nums[i-1])
                h=l+1;
            else if(nums[i]<nums[i-1])
                l=h+1;
        return Math.max(l,h);
    }
}