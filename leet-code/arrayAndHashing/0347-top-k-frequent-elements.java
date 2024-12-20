package arrayAndHashing;

import java.util.*;

class SolutiontopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> bucket[] = new ArrayList[nums.length + 1];

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int key : count.keySet()) {
            int freq = count.get(key);
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        int index = 0;
        int[] ans = new int[k];
        for (int i = nums.length; i >=0; i--) {
            if (bucket[i] != null) {
                for (int val : bucket[i]){
                    ans[index++] = val;
                    if(index == k)
                        return ans;
                }
            }
        }
        return ans;
    }
}