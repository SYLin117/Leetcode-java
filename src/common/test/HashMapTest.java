package common.test;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        dict.put(1, 0);
        dict.put(2, dict.get(1) + 1);
        System.out.println(dict.get(1));
    }
}
