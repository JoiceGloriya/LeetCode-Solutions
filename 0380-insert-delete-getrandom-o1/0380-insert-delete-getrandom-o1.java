class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> mpp;

    public RandomizedSet() {
        list = new ArrayList<>();
        mpp = new HashMap<>();
    }

    public boolean insert(int val) {
        if (mpp.containsKey(val))
            return false;
        list.add(val);
        mpp.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!mpp.containsKey(val))
            return false;

        int last = list.get(list.size() - 1);
        int ind = mpp.get(val);
        list.set(ind, last);
        mpp.put(last, ind);

        mpp.remove(val);
        list.remove(list.size() - 1);
         return true;
    }

    public int getRandom() {
        Random rand = new Random();
        int size = list.size();
        return list.get(rand.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */