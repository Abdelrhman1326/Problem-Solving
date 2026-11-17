class LRUCache {
    private final Integer capacity;
    int[] president_set;
    int count;
    LinkedHashSet<Integer> LRU_Keys_Set = new LinkedHashSet<>();

    public LRUCache(int capacity) {
        count = 0;
        president_set = new int[(int)(1e4 + 1)];

        for (int i = 0; i < president_set.length; i++) {
            president_set[i] = -1;
        }

        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (president_set[key] != -1) {
            LRU_Keys_Set.remove(key);
            LRU_Keys_Set.add(key);
            return president_set[key];
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (president_set[key] != -1) {
            president_set[key] = value;
            LRU_Keys_Set.remove(key);
            LRU_Keys_Set.add(key);
            return;
        }

        if (count == capacity) {
            int oldestKey = LRU_Keys_Set.iterator().next();
            LRU_Keys_Set.remove(oldestKey);
            president_set[oldestKey] = -1;
            count--;
        }

        president_set[key] = value;
        LRU_Keys_Set.add(key);
        count++;
    }
}