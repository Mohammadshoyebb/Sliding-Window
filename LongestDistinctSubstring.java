/*
 *   Longest Distinct characters in string
 * 
 * 
 * Given a string S, find the length of the longest substring with all distinct characters.
 * 
 * Example 1:
 * Input: S = "geeksforgeeks"
 * Output: 7
 * Explanation: "eksforg" is the longest substring with all distinct characters.
 * 
 * Example 2:
 * Input: S = "aaa"
 * Output: 1
 * Explanation: "a" is the longest substring with all distinct characters.
 * 
 * Constraints:
 * 1 <= |S| <= 105
 */

 import java.util.*;

 public class LongestDistinctSubstring {
     public static int longestSubstrDistinctChars(String S) {
         int n = S.length();
         int maxLength = 0;
         
         // Set to store the characters in the current window
         Set<Character> charSet = new HashSet<>();
         
         int left = 0, right = 0;
         
         while (right < n) {
             // Expand the window
             if (!charSet.contains(S.charAt(right))) {
                 charSet.add(S.charAt(right));
                 right++;
                 maxLength = Math.max(maxLength, right - left);
             } else {
                 // Shrink the window from the left until we remove the duplicate character
                 charSet.remove(S.charAt(left));
                 left++;
             }
         }
         
         return maxLength;
     }
 
     public static void main(String[] args) {
         // Test cases
         System.out.println(longestSubstrDistinctChars("geeksforgeeks")); // Output: 7
         System.out.println(longestSubstrDistinctChars("aaa")); // Output: 1
         System.out.println(longestSubstrDistinctChars("abcabcbb")); // Output: 3
         System.out.println(longestSubstrDistinctChars("pwwkew")); // Output: 3
         System.out.println(longestSubstrDistinctChars("")); // Output: 0
     }
 }
 