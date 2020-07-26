package com.leetcode.p365;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
	如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
	你允许：
	装满任意一个水壶
	清空任意一个水壶
	从一个水壶向另外一个水壶倒水，直到装满或者倒空
	示例 1: (From the famous "Die Hard" example)
	输入: x = 3, y = 5, z = 4
	输出: True
	示例 2:
	输入: x = 2, y = 6, z = 5
	输出: False
 * @author 张恒
 *	gcd方法:如果z%(x和y的最大公约数)==0,表示可以
 */
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
    	if(z < 0 || x+y < z) return false;
    	
    	int big = Math.max(x, y);
    	int small = Math.min(x, y);
    	
    	if(small ==0 ) return big == z;
    	while(big % small != 0){
    		int tmp = small;
    		small = big % small;
    		big = tmp;
    	}
    	return small == z;
    }
}

class Solution2 {
    public boolean canMeasureWater(int x, int y, int z) {
    	if(z < 0 || x+y < z) return false;
    	
    	Set<Integer> set = new HashSet<Integer>();//记录状态,防止重复计算
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(0);
    	
    	while(!q.isEmpty()){
    		int n = q.poll();
    		
    		if(n + x <= x+y && set.add(n+x)){
    			q.add(n+x);
    		}
    		if(n + y <= x+y && set.add(n+y)){
    			q.add(n+y);
    		}
    		
    		if(n-x>=0 && set.add(n-x)){
    			q.add(n-x);
    		}
    		
    		if(n-y >= 0 && set.add(n-y)){
    			q.add(n-y);
    		}
    		
    		if(set.contains(z)){
    			return true;
    		}
    		
    	}
    	return false;
    }
}