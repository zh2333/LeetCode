package com.leetcode.p409;

/**
 * ����һ��������д��ĸ��Сд��ĸ���ַ������ҵ�ͨ����Щ��ĸ����ɵ���Ļ��Ĵ���
	�ڹ�������У���ע�����ִ�Сд������ "Aa" ���ܵ���һ�������ַ�����
	ע��:
	�����ַ����ĳ��Ȳ��ᳬ�� 1010��
	ʾ�� 1:
	����:
	"abccccdd"
	���:
	7
	����:
	���ǿ��Թ������Ļ��Ĵ���"dccaccd", ���ĳ����� 7��
 * @author �ź�
 *	���:ͳ��ÿ���ַ����ֵĴ���,�����ż��,����ַ�(�ظ�)���Ա�����,�������Ϊ�������ַ��ĸ���>=2,��ֻ��һ��������ȫ����,������ַ�������Ҫ-1
 */
class Solution {
	
	public static void main(String[] args) {
		String s = "abccccdd";
		int len = longestPalindrome(s);
		System.out.println(len);
	}
    public static int longestPalindrome(String s) {
    	int[] ans = new int[128];
    	char[] chars = s.toCharArray();
    	//ͳ��ÿ���ַ����ֵĴ���
    	for (char c : chars) {
			ans[c]++;
		}
    	int len = ans.length;
    	int count = 0;
    	//ͳ�������ַ��ĸ���
    	for (int i = 0; i < len; i++) {
			if(ans[i] % 2 != 0){
				count++;
			}
		}
    	
		return count = count >= 2 ? s.length()-count+1 : s.length();
    	
    }
}
