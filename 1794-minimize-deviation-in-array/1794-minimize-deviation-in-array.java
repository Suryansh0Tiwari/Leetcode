class Solution {
    public int minimumDeviation(int[] nums) {
        return util(nums, nums.length);
    }

    private int util(int A[], int N)
{
   
    // Store all array elements
    // in sorted order
    TreeSet<Integer> s = new TreeSet<Integer>();
    for (int i = 0; i < N; i++)
    {
 
        if (A[i] % 2 == 0)
            s.add(A[i]);
 
        // Odd number are transformed
        // using 2nd operation
        else
            s.add(2 * A[i]);
    }
 
    // (Maximum - Minimum)
    int diff =  s.last() -  s.first() ;
 
    // Check if the size of set is > 0 and
    // the maximum element is divisible by 2
    while ((s.last() % 2 == 0))
    {
 
        // Maximum element of the set
        int maxEl = s.last();
 
        // Erase the maximum element
        s.remove(maxEl);
 
        // Using operation 1
        s.add(maxEl / 2);
 
        // (Maximum - Minimum)
        diff = Math.min(diff, s.last() -  s.first());
    }
 
    // Print the Minimum
    // Deviation Obtained
    return (diff);
}
 
}