import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

class RandomizedCollection {

    HashMap<Integer, HashSet<Integer>> map;
    ArrayList<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)){
            map.get(val).add(list.size());
            list.add(val);
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(list.size());
            list.add(val);
            map.put(val, set);
        }

        return map.get(val).size() == 1;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }

        int index = map.get(val).iterator().next();
        int last = list.size() - 1;
        list.set(index, list.get(last));


        map.get(val).remove(index);
        map.get(list.get(last)).add(index);
        map.get(list.get(last)).remove(last);

        list.remove(last);

        if (map.get(val).size() == 0) {
            map.remove(val);
        }

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}


/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */