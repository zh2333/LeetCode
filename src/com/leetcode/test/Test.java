package com.leetcode.test;

import com.leetcode.p146.LRUCache;
import com.leetcode.utils.StringUtil;

class Test{
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		sb.append(2);
		sb.deleteCharAt(sb.length() - 1);
		StringUtil.printStr(sb.toString());
	}
}
