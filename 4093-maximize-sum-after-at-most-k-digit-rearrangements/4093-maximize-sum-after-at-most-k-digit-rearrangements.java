class Solution {
    public long maximizeSum(int[] nums, int k) {
        long totalSum = 0;
        int n = nums.length;
        long[] gains = new long[n];

        for (int i = 0; i < n; i++) {
            int original = nums[i];
            totalSum += original;

            String str = Integer.toString(original);
            char[] digits = str.toCharArray();
            Arrays.sort(digits);

            long maxVal = 0;
            for (int j = digits.length - 1; j >= 0; j--) {
                maxVal = maxVal * 10 + (digits[j] - '0');
            }
            
            gains[i] = maxVal - original;
        }
        Arrays.sort(gains);
        
        
        for (int i = n - 1; i >= 0 && k > 0; i--) {
            if (gains[i] <= 0) break; 
            totalSum += gains[i];
            k--;
        }
        
        return totalSum;
    }
}