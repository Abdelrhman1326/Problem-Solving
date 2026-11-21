class Solution {    
    public int minEatingSpeed(int[] piles, int h) {
        ArrayList<Integer> piles_array = new ArrayList<>(
            Arrays.stream(piles).boxed().sorted().toList()
        );

        long left = 1;
        long right = piles_array.get(piles_array.size() - 1);
        long k = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long hours = piles_array.stream()
                .mapToLong(b -> (long) Math.ceil((double) b / mid))
                .sum();

            if (hours > h) {
                left = mid + 1;
            } else {
                k = mid;
                right = mid - 1;
                k = Math.min(k, mid);
            }
        }

        return (int)k;
    }
}