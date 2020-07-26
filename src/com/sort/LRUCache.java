import java.util.HashMap;
import java.util.LinkedList;

/**
 * 使用LinkedList和HashMap实现最久未使用
 */
public class LRUCache {
    private int capacity;
    private HashMap<Integer,Integer> map;
    private LinkedList<Integer> list;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    /**
     *  1.如果map中已经存在这个key,就将它从原来的list中删除并添加到list的末尾,取出value
     *  2.不包含,返回-1
     * @param key
     * @return
     */
    public int get(int key){
        if(map.containsKey(key)){
            list.remove(key);
            list.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    /**
     *  1.如果map中存在这个key,执行更新操作,并更新key在list中的位置
     *  2.如果list的大小,等于capacity,执行淘汰策略
     *  3.直接插入
     * @param key
     * @param value
     * @return
     */
    public void put(int key,int value){
        if(map.containsKey(key)){
            list.remove(key);
            list.addLast(key);
            map.put(key,value);
            return;
        }

        if(list.size() == capacity){
            map.remove(list.removeFirst());
            map.put(key,value);
            list.addLast(key);
        }else {
            list.addLast(key);
            map.put(key,value);
        }
    }
}
