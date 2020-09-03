public class Main {

    public static void main(String[] args) {
        int[] nums = {1,0,1,1 };
        int k = 1;
        int t = 2;
        long start = System.currentTimeMillis();
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
        System.out.println(System.currentTimeMillis() - start);
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums.length == 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                int indecesdiff = Math.abs(i - j);
                long numsdiff = Math.abs((long) nums[i] - nums[j]);
                if (indecesdiff <= k
                        && numsdiff <= t)
                    return true;
            }
        }
        return false;
    }

}

//    Given an array of integers, find out whether there are two distinct indices i and j in the array
//    such that the absolute difference between nums[i] and nums[j] is at most t
//    and the absolute difference between i and j is at most k.
//
//        Example 1:
//
//        Input: nums = [1,2,3,1], k = 3, t = 0
//        Output: true
//        Example 2:
//
//        Input: nums = [1,0,1,1], k = 1, t = 2
//        Output: true
//        Example 3:
//
//        Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//        Output: false
//    1)Time complexity O(n logk) - This will give an indication that sorting is involved for k elements.
//    2)Use already existing state to evaluate next state - Like, a set of k sorted numbers are only needed to be tracked.
//    When we are processing the next number in array, then we can utilize the existing sorted state and it is not necessary
//    to sort next overlapping set of k numbers again.