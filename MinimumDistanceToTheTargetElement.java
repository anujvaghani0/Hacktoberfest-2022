package Arrays;

//question link -> https://leetcode.com/problems/minimum-distance-to-the-target-element/

public class MinimumDistanceToTheTargetElement {
    public static void main(String[] args) {
        int[] nums = {6,8,9,5,12,36};
        System.out.println(getMinDistance(nums, 5, 2));
    }

    public static int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans = Math.min(ans, Math.abs(i - start));
            }
        }
        return ans;
    }
}
