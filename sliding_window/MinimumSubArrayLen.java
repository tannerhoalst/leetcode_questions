public class MinimumSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                int currentLength = right - left + 1;
                if (minLength > currentLength) {
                    minLength = currentLength;
                }
                sum -= nums[left];
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLength;
        }
    }

    public static void main(String[] args) {
        MinimumSubArrayLen sol = new MinimumSubArrayLen();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(sol.minSubArrayLen(target, nums)); // Output: 2
    }
}
