package com.leetcode.p1002;

import com.leetcode.utils.MyList;
import org.junit.Test;

import java.util.*;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    @Test
    public void test() {
        String[] A = {"cool","lock","cook"};
        System.out.print("[");
        List<String> res = commonChars(A);
        for (String s:res) {
            if (s == res.get(res.size() - 1)) {
                System.out.print(s);
            } else {
                System.out.print(s + ", ");
            }
        }
        System.out.print("]");

    }
    public List<String> commonChars(String[] A) {
        if (A.length == 0) return new ArrayList<>();
        HashMap<Character, Map<Integer, Integer>> map = new HashMap<>();
        int size = A.length;
        for (int i = 0; i < size; i++) {
            char[] chars = A[i].toCharArray();
            for (char ch: chars) {
                if (map.containsKey(ch)) {
                    Map<Integer, Integer> timesMap = map.get(ch);
                    if (timesMap.containsKey(i)) {
                        timesMap.put(i, timesMap.get(i) + 1);
                    } else {
                        timesMap.put(i, 1);
                    }
                } else {
                    Map<Integer, Integer> timesMap = new HashMap<>();
                    timesMap.put(i, 1);
                    map.put(ch, timesMap);
                }
            }
        }
        List<String> res = new ArrayList<>();
        Map<Character, Integer> timesMap = new HashMap<>();
        Set<Character> characterSet = map.keySet();

        for (Character ch:characterSet) {
            Map<Integer, Integer> tmp = map.get(ch);
            Set<Integer> keys = tmp.keySet();
            int min = Integer.MAX_VALUE;
            if (keys.size() == size) {//这个字符被包含进了所有的字符串中
                for (Integer key: keys) {
                    min = min < tmp.get(key) ? min : tmp.get(key);
                }
                timesMap.put(ch, min);
            }
        }

        for (Character ch:timesMap.keySet()) {
            for (int i = 0; i < timesMap.get(ch); i++) {
                res.add(String.valueOf(ch));
            }
        }
        return res;
    }
}
