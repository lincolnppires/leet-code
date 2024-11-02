package arrayAndHashing;

import java.util.*;

class SolutiontwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapRemaining = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            var remain = target - nums[i];
            if(mapRemaining.containsKey(remain) && mapRemaining.get(remain) != i) {
                int[] ans = {i, mapRemaining.get(remain)};
                return ans;
            }
            mapRemaining.put(nums[i], i);
        }

        return null;
    }
}
