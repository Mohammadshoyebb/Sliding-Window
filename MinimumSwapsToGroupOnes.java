/*
 * 2134. Minimum Swaps to Group All 1's Together II
 * 
 * A swap is defined as taking two distinct positions in an array and swapping the values in them.
 * A circular array is defined as an array where we consider the first element and the last element to be adjacent.
 * 
 * Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the array together at any location.
 * 
 * Example 1:
 * Input: nums = [0,1,0,1,1,0,0]
 * Output: 1
 * Explanation: Here are a few of the ways to group all the 1's together:
 * [0,0,1,1,1,0,0] using 1 swap.
 * [0,1,1,1,0,0,0] using 1 swap.
 * [1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
 * There is no way to group all 1's together with 0 swaps.
 * Thus, the minimum number of swaps required is 1.
 * 
 * Example 2:
 * Input: nums = [0,1,1,1,0,0,1,1,0]
 * Output: 2
 * Explanation: Here are a few of the ways to group all the 1's together:
 * [1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
 * [1,1,1,1,1,0,0,0,0] using 2 swaps.
 * There is no way to group all 1's together with 0 or 1 swaps.
 * Thus, the minimum number of swaps required is 2.
 * 
 * Example 3:
 * Input: nums = [1,1,0,0,1]
 * Output: 0
 * Explanation: All the 1's are already grouped together due to the circular property of the array.
 * Thus, the minimum number of swaps required is 0.
 * 
 * Constraints:
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */

 import java.util.*;

 public class MinimumSwapsToGroupOnes {
     public int minSwaps(int[] nums) {
         int totalOnes = 0;
         for (int num : nums) {
             totalOnes += num;
         }
         
         int currentOnes = 0;
         int maxOnesInWindow = 0;
         int n = nums.length;
 
         for (int i = 0; i < totalOnes; i++) {
             currentOnes += nums[i];
         }
         maxOnesInWindow = currentOnes;
 
         for (int i = totalOnes; i < n + totalOnes; i++) {
             currentOnes += nums[i % n] - nums[(i - totalOnes) % n];
             maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
         }
 
         return totalOnes - maxOnesInWindow;
     }
 
     public static void main(String[] args) {
         MinimumSwapsToGroupOnes solution = new MinimumSwapsToGroupOnes();
         
         // Test cases
         System.out.println(solution.minSwaps(new int[] {0,1,0,1,1,0,0})); // Output: 1
         System.out.println(solution.minSwaps(new int[] {0,1,1,1,0,0,1,1,0})); // Output: 2
         System.out.println(solution.minSwaps(new int[] {1,1,0,0,1})); // Output: 0
         System.out.println(solution.minSwaps(new int[] {1,0,1,0,1,0,1,0,1,0})); // Output: 3
         System.out.println(solution.minSwaps(new int[] {1,1,1,1,0,0,0,1,1})); // Output: 1
     }
 }

 // Slower approach but easy to understand

 /*
  class Solution {
    public int minSwaps(int[] nums) {

        // Counting Number of Ones
        int onesSize = 0;
        for(int num : nums){
            if(num == 1){
                onesSize++;
            }
        }

        // Creating a window of size ones
        int zeroCount = 0;
        for(int i=0 ; i<onesSize ; i++){
            if(nums[i] == 0){
                zeroCount++;
            }
        }
            int minZero = zeroCount;
            int start = 0;
            int end = onesSize-1;
            int n = nums.length;

            while(start < n){
                if(nums[start] == 0){
                    zeroCount--;
                }
                start++;
                end++;

                if(nums[end%n]==0){
                    zeroCount++;
                }
            minZero = Math.min(minZero, zeroCount);
        }
        return minZero;
    }
}
  */