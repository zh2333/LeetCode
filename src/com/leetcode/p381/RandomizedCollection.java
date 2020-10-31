package com.leetcode.p381;


import java.util.*;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 示例:
 *
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 *
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 *
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 *
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 *
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 *
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class RandomizedCollection {
    private HashMap<Integer, Integer> map = null;
    Random random = null;
    int size = 0;
    /** 初始化这个允许重复元素的集合 */
    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.random = new Random();
    }

    /** 向集合中插入一个元素.如果该集合之前不包含这个元素, 返回true.否则返回false */
    public boolean insert(int val) {
        boolean flag = map.containsKey(val);
        if (flag) {//如果包含了就将这个数值对应的个数加1
            map.put(val, map.get(val) + 1);
        } else {//如果不包含就将这个数值加入
            map.put(val, 1);
        }
        size++;//每插入一个元素, 集合大小+1
        return !flag;
    }

    /** 从集合中删除一个元素, 如过该集合包含这个元素, 返回true, 否则返回false */
    public boolean remove(int val) {
        boolean flag = map.containsKey(val);

        if (flag) {//包含这个元素
            int times = map.get(val);
            if (times == 1) {//如果这个元素的个数只剩一个了, 将这个元素从map和set中同时删除
                map.remove(val);
            } else {//否则将map中这个元素的数量减一
                map.put(val, times - 1);
            }
            size--;//集合中元素数量减一
            return true;
        } else {//不包含这个元素, 删除失败
            return false;
        }
    }

    /** 从集合中随机获取一个元素. */
    public int getRandom() {
        LinkedList<Integer> list = new LinkedList<>();
        Set<Integer> keys = map.keySet();
        int pos = random.nextInt(size);
        for (Integer val : keys) {
            int tmpTimes = map.get(val);
            if (pos < tmpTimes) {
                return val;
            } else {
                pos = pos - tmpTimes;
            }
        }
        return 0;
    }

}

