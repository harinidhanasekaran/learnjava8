package harini.teaches;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 */
public class ArrayContainsDuplicate {

    private static int[] sort(int[] nums){
        for(int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    private static boolean containsDuplicate1(int[] nums) {
        int[] sortedArray = sort(nums);
        for(int i = 0; i < sortedArray.length-1; i++) {
            for (int j = 0; j < sortedArray.length-i-1; j++) {
                if (sortedArray[j] == sortedArray[j+1]) {
                   return true;
                }
            }
        }
        return false;
    }

    private static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums,0,nums.length);
        for(int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] == nums[j+1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean containsDuplicate3(int[] nums) {
        Set<Integer> inputSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if(inputSet.size() < nums.length)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{ 1,34,3,2,4 ,4};
        System.out.println(containsDuplicate3(inputArray));
    }


}
