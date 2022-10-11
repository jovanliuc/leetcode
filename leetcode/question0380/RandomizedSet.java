package leetcode.question0380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

    private List<Integer> list;
    private HashMap<Integer, Integer> valueToIndexMap;
    private Random random;


    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.valueToIndexMap = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (valueToIndexMap.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            valueToIndexMap.put(val, list.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!valueToIndexMap.containsKey(val)) {
            return false;
        } else {
            int index = valueToIndexMap.get(val);
            int lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            list.remove(list.size() - 1);
            valueToIndexMap.put(lastVal, index);
            valueToIndexMap.remove(val);
            return true;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
