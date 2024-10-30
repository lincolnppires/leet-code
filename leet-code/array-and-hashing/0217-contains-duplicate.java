class Solution {
    public boolean containsDuplicate(int[] nums){
        Set<Integer> set = new HashSet();
        for(int key: nums){
            if(set.contains(key)){
                return true;
            }
            else {
                set.add(key);
            }
        }
        return false;
    }
}