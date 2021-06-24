package yxy.tom.lrucache;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class LRUCache {
    private LinkedList<Integer> cacheSequence;
    private Map cacheMap;
    int size;

    public LRUCache(int capacity) {
        cacheSequence = new LinkedList<Integer>();
        cacheMap = new HashMap();
        size = capacity;
    }

    public int get(int key) {
        if(cacheMap.containsKey(key)){
            cacheSequence.remove(Integer.valueOf(key));
            cacheSequence.addFirst(key);
            return (int)cacheMap.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            cacheMap.put(key, value);
            cacheSequence.remove(Integer.valueOf(key));
            cacheSequence.addFirst(key);
        }else{
            cacheMap.put(key, value);
            cacheSequence.addFirst(key);
        }

        if(cacheMap.size() > this.size){
            int tempKey = cacheSequence.removeLast();
            cacheMap.remove(tempKey);
        }
    }
}