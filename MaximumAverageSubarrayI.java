/**
 * 643. Maximum Average Subarray I
 * 
 * You are given an integer array nums consisting of n elements, and an integer k.
 * 
 * Find a contiguous subarray whose length is equal to k that has the maximum average value 
 * and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 * 
 * Example 1:
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * 
 * Example 2:
 * Input: nums = [5], k = 1
 * Output: 5.00000
 * 
 * Constraints:
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 */

 import java.util.Arrays;

 public class MaximumAverageSubarrayI {
 
     // Approach 1: Using Sliding Window
     public double findMaxAverage(int[] nums, int k) {
         int max = Integer.MIN_VALUE;
         // Special case when k is 1
         if (k == 1) {
             for (int num : nums) {
                 if (max < num) {
                     max = num;
                 }
             }
             return max;
         }
 
         // Initializing the sliding window
         int start = 1;
         int end = k;
         max = 0;
         for (int i = 0; i < k; i++) {
             max += nums[i];
         }
         int curr = max;
         // Sliding the window across the array
         while (end < nums.length) {
             curr = curr + nums[end] - nums[start - 1];
             if (curr > max) {
                 max = curr;
             }
             start++;
             end++;
         }
 
         return (double) max / k;
     }
 
     // Approach 2: Using Math
     public double findMaxAverageMath(int[] nums, int k) {
         double max = Integer.MIN_VALUE;
         double sum = 0;
         int n = nums.length;
 
         // Initial sum of the first k elements
         for (int i = 0; i < k; i++) {
             sum += nums[i];
         }
         max = Math.max(max, sum / k);
 
         // Sliding the window across the array and calculating the sum
         for (int i = k; i < n; i++) {
             sum -= nums[i - k];
             sum += nums[i];
             max = Math.max(max, sum / k);
         }
         return max;
     }
 
     public static void main(String[] args) {
         MaximumAverageSubarrayI solution = new MaximumAverageSubarrayI();
         
         int[] nums1 = {1, 12, -5, -6, 50, 3};
         int k1 = 4;
         System.out.println(solution.findMaxAverage(nums1, k1)); // 12.75
         System.out.println(solution.findMaxAverageMath(nums1, k1)); // 12.75
 
         int[] nums2 = {5};
         int k2 = 1;
         System.out.println(solution.findMaxAverage(nums2, k2)); // 5.0
         System.out.println(solution.findMaxAverageMath(nums2, k2)); // 5.0
     }
 }
 
