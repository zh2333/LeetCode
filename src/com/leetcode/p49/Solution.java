package com.leetcode.p49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
	ʾ��:
	����: ["eat", "tea", "tan", "ate", "nat", "bat"],
	���:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	˵����
	
	���������ΪСд��ĸ��
	�����Ǵ������˳��

 * @author �ź�
 *
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	if(strs == null) return new ArrayList();
    	
    	//����ӳ��
    	Map<String,List> ans = new HashMap<String,List>();
    	for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String key = String.valueOf(c);
			if(!ans.containsKey(key)){
				//�������뼯����
				ans.put(key, new ArrayList());
			}
			//����ͬ��ĸ���ַ�������ͬһ��list��
			ans.get(key).add(str);
		}
    	//��hashMap�е�valueȡ�����Ž���һ������
    	return new ArrayList(ans.values());
    }
}