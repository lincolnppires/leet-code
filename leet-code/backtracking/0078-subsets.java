package backtracking;

import java.util.*;
class SolutionSubsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++){
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        SolutionSubsets subsets = new SolutionSubsets();
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets.subsets(nums);

        for(List<Integer> subset : result){
            System.out.println(subset);
        }
    }

}