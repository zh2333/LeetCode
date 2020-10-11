package com.leetcode.reviewe1002;

import org.junit.Test;

import java.util.*;

/**
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    @Test
    public void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println("[");
        for (List<String> list: res ) {
            System.out.print("  [");
            for (String str: list) {
                if(list.get(list.size() - 1) == str) {
                    System.out.print("\"" + str + "\"");
                } else {
                    System.out.print("\"" + str + "\"" + ",");
                }
            }
            System.out.println("],");
        }
        System.out.println("]");
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for ( String str : strs ) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if(!strMap.containsKey(sortedStr)) {
                List<String> tmpStr = new ArrayList<>();
                tmpStr.add(str);
                strMap.put(sortedStr, tmpStr);
            } else {
                strMap.get(sortedStr).add(str);
            }
        }
        res.addAll(strMap.values());
        return res;
    }
}
