package com.leetcode.p79;

/**
 * ����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�
	���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
	ʾ��:
	board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	���� word = "ABCCED", ���� true.
	���� word = "SEE", ���� true.
	���� word = "ABCB", ���� false.
 * @author �ź�
 *	���:
 * 	����
 * 	0-----------x------------
 * 	|
 * 	|
 * 	|
 * 	|		  (x,y-1)
 * 	y (x-1,y) ( x, y)   (x+1,y)
 * 	|		  (x,y+1)
 * 	|
 * 	|
 * 	|
 * 	|
 * 	����һ������ϵ.��һ������������Ʒ�����ƶ�
 * 	int[][] directions = {{0,-1},{1,0},{0,1}{-1,0}}
 * 	����һ��marked�������ڱ�������ϵ�ĳ����ĸ�Ƿ��Ѿ�����
 */
class Solution {
	private static int m;
	private static int n;
	private static int[][] directions = {{0,-1},{1,0},{0,1},{-1,0}};//��ʼ����������
	private static String word;
	private static boolean[][] marked;//�������,��λΪtrue��ʾ�Ѿ����߹�
	private static char[][] board;
	private static int len;
    public boolean exist(char[][] board, String word) {
    	Solution.board = board;
    	Solution.word = word;
    	Solution.m = board.length;
    	if(m == 0) return false;
    	Solution.n= board[0].length;
    	Solution.marked = new boolean[m][n];
    	Solution.len = word.length();
    	
    	//���ö�ά�����������
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if(dfs(i,j,0)){
    				return true;
    			}
			}
		}
    	return false;
    }
    
    //������ȱ���
    public boolean dfs(int m,int n,int start){
    	//�ж��Ƿ��Ѿ�������word�����һ����ĸ,������ҵ�����true
    	if(start == len-1){
    		return board[m][n] == word.charAt(start);
    	}
    	
    	//�����ǰword�е���ĸ��board���ҵ�,�Ͱ�board�е�ĳһλ��Ϊtrue,���ƶ�ָ��
    	if(board[m][n] == word.charAt(start)){
    		marked[m][n] = true;
    		//���ĸ�������
    		for (int i = 0; i < 4; i++) {
				int nextX = m + directions[i][0];
				int nextY = n + directions[i][1];
				//�����һ������ûӴԽ�粢��δ�����Ϊtrue,�ͷ����������
				if(inArea(nextX, nextY) && !marked[nextX][nextY]){
					if(dfs(nextX, nextY, start+1)){
                        return true;
                    }
				}
				
			}
            
            marked[m][n] = false;
    	}
    	
		return false;
    	
    }
    
    //�ж������Ƿ�Խ��,x����0����С���п�,y���ڵ���0��С���п�
    public static boolean inArea(int x, int y){
		return x >=0 && x<m && y>=0 && y<n;
	}
}