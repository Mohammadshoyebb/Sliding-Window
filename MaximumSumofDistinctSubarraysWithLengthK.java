/**
 * 2461. Maximum Sum of Distinct Subarrays With Length K
 * 
 * You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
 * 
 * The length of the subarray is k, and
 * All the elements of the subarray are distinct.
 * Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * Example 1:
 * 
 * Input: nums = [1,5,4,2,9,9,9], k = 3
 * Output: 15
 * Explanation: The subarrays of nums with length 3 are:
 * - [1,5,4] which meets the requirements and has a sum of 10.
 * - [5,4,2] which meets the requirements and has a sum of 11.
 * - [4,2,9] which meets the requirements and has a sum of 15.
 * - [2,9,9] which does not meet the requirements because the element 9 is repeated.
 * - [9,9,9] which does not meet the requirements because the element 9 is repeated.
 * We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
 * 
 * Example 2:
 * 
 * Input: nums = [4,4,4], k = 3
 * Output: 0
 * Explanation: The subarrays of nums with length 3 are:
 * - [4,4,4] which does not meet the requirements because the element 4 is repeated.
 * We return 0 because no subarrays meet the conditions.
 * 
 * Constraints:
 * 
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */

import java.util.HashMap;
import java.util.Map;

public class MaximumSumofDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        long currSum = 0;
        long ans = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        // Initialize the current sum and frequency map for the first window
        for (int i = 0; i < k; i++) {
            currSum += (long) nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // Check if the first window has all distinct elements
        if (map.size() == k) {
            ans = currSum;
        }
        
        int left = 0;
        
        // Slide the window across the array
        for (int i = k; i < n; i++) {
            currSum -= (long) nums[left];
            currSum += (long) nums[i];
            map.put(nums[left], map.get(nums[left]) - 1);
            
            // Remove the element from the map if its count drops to 0
            if (map.get(nums[left]) == 0) {
                map.remove(nums[left]);
            }
            
            // Add the new element to the map
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
            // Check if the current window has all distinct elements
            if (map.size() == k) {
                ans = Math.max(currSum, ans);
            }
            
            left++;
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        MaximumSumofDistinctSubarraysWithLengthK solution = new MaximumSumofDistinctSubarraysWithLengthK();
        int[] nums1 = {1, 5, 4, 2, 9, 9, 9};
        int k1 = 3;
        System.out.println(solution.maximumSubarraySum(nums1, k1));  // Output: 15
        
        int[] nums2 = {4, 4, 4};
        int k2 = 3;
        System.out.println(solution.maximumSubarraySum(nums2, k2));  // Output: 0
    }
}

