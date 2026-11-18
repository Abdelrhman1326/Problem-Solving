class Solution {
    private static record Project(int profit, int capital) {}
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // w is the initial capital
        // k is the max number of projects to take
        ArrayList<Project> projects = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            projects.add(new Project(profits[i], capital[i]));
        }

        // sort with minimum capital then max profit
        projects.sort(
            Comparator.comparingInt(Project::capital)
                    .thenComparingInt(p -> -p.profit())
        );

        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Comparator.reverseOrder());
        int total_capital = w;
        int investments_count = 0;

        if (k == 0 || profits.length == 0) {
            return w;
        }

        for (int i = 0; i < projects.size(); i++) {
            if (investments_count == k) {
                break;
            }
            
            Project p = projects.get(i);
            
            if (max_heap.isEmpty() && p.capital() > total_capital) {
                // the capital isn't enough for any remaining project
                return total_capital;
            } else if (total_capital >= p.capital()) {
                // affordable project -> push its profit to the heap
                max_heap.offer(p.profit());
            } else if (total_capital < p.capital()) {
                // invest in the best recorded projects until we can afford p
                while (total_capital < p.capital() && !max_heap.isEmpty() && investments_count < k) {
                    total_capital += max_heap.poll();
                    investments_count += 1;
                }
                if (total_capital >= p.capital()) {
                    max_heap.offer(p.profit());
                } else {
                    return total_capital;
                }
            }
        }

        // cash out the remaining best projects
        while (investments_count < k && !max_heap.isEmpty()) {
            investments_count += 1;
            total_capital += max_heap.poll();
        }

        return total_capital; 
    }
}