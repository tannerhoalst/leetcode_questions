package Hashmap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                if (Math.abs(i - j) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate2 cnd = new ContainsDuplicate2();
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        boolean result = cnd.containsNearbyDuplicate(nums, k);
        System.out.println("Contains nearby duplicate: " + result);
    }
}
