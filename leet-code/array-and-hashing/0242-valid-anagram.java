class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapCount = new HashMap<>();

        if(s.length() != t.length())
            return false;

        for(char c : s.toCharArray()){
            if(mapCount.containsKey(c)){
                mapCount.put(c, mapCount.get(c) + 1);
            }
            else {
                mapCount.put(c, 1);
            }
        }

        for(char c : t.toCharArray()) {
            if(mapCount.containsKey(c)){
                mapCount.put(c, mapCount.get(c) -1);
            }
        }
        for (int val : mapCount.values()){
            if(val != 0)
                return false;
        }

        return true;
    }
}