import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashSet {
    List<List<Integer>> set;
    int size;
    int setLength;
    /** Initialize your data structure here. */
    public MyHashSet() {
        size = 0;
        setLength = 10;
        set = new ArrayList<>();
        for (int i = 0; i<setLength; i++){
            set.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        if (!contains(key)){
            set.get(key % setLength).add(key);
            size++;
        }
        if (size >= setLength * 2){
            setLength *= 2;
            arrange();
        }
    }

    public void remove(int key) {
        int position = key % setLength;
        for (int i : set.get(position)){
            if (i == key){
                set.get(position).remove((Integer)key);
                size--;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int position = key % setLength;
        for (int i : set.get(position)){
            if (i == key){
                return true;
            }
        }
        return false;
    }
    private void arrange(){
        List<List<Integer>> newSet = new ArrayList<>();
        for (int i = 0; i < setLength; i++){
            newSet.add(new LinkedList<>());
        }
        for (List<Integer> l : set){
            for (int i : l){
                int position = i % setLength;
                newSet.get(position).add(i);
            }
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */