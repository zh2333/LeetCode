package com.leetcode.p146;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**�����������յ����ݽṹ����ƺ�ʵ��һ��  LRU (�������ʹ��) ������ơ���Ӧ��֧�����²����� ��ȡ���� get �� д������ put ��

��ȡ���� get(key) - �����Կ (key) �����ڻ����У����ȡ��Կ��ֵ�����������������򷵻� -1��
д������ put(key, value) - �����Կ�����ڣ���д��������ֵ�������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ�����δʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣

����:

���Ƿ������ O(1) ʱ�临�Ӷ�����������ֲ�����

ʾ��:

LRUCache cache = new LRUCache( 2 /* �������� */ 

 public //cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // ����  1
//cache.put(3, 3);    // �ò�����ʹ����Կ 2 ����
//cache.get(2);       // ���� -1 (δ�ҵ�)
//cache.put(4, 4);    // �ò�����ʹ����Կ 1 ����
//cache.get(1);       // ���� -1 (δ�ҵ�)
//cache.get(3);       // ����  3
//cache.get(4);       // ����  4
//**/
class LRUCache {
	LinkedHashMap<Integer,Integer> map;
    public LRUCache(int capacity) {
    	//0.75f��װ������,true��ʾ,map�����Ԫ�ذ���ʱ������
    	map = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
    		@Override
    		//�ص�����д�������
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()>capacity;
            }
    	};
    }
    
    public int get(int key) {
    	if(!map.containsKey(key)) return -1;
		return map.get(key);

    }
    
    public void put(int key, int value) {
    	map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */