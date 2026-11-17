class MedianFinder {
    private PriorityQueue<Integer> max_heap;
    private PriorityQueue<Integer> min_heap;

    public MedianFinder() {
        min_heap = new PriorityQueue<>();
        max_heap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (min_heap.isEmpty()) {
            min_heap.offer(num);
            return;
        }

        if (!max_heap.isEmpty() && max_heap.peek() > num) {
            max_heap.offer(num);
        } else {
            min_heap.offer(num);
        }

        while (min_heap.size() < max_heap.size()) {
            min_heap.offer(max_heap.poll());
        }
        while (min_heap.size() > max_heap.size() + 1) {
            max_heap.offer(min_heap.poll());
        }
    }
    
    public double findMedian() {
        if (min_heap.size() == max_heap.size()) {
            return ((double)min_heap.peek() + (double)max_heap.peek()) / 2.0;
        }

        return min_heap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */