class Solution {
    private record Pair(String key, Integer value){}
    public String[] sortPeople(String[] names, int[] heights) {
        ArrayList<Pair> people = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            people.add(new Pair(names[i], heights[i]));
        }

        people.sort((a, b) -> (b.value).compareTo((a.value)));
        
        String[] ans = new String[people.size()];
        for (int i = 0; i < people.size(); i++) {
            ans[i] = (String)people.get(i).key();
        }
        return ans;
    }
}