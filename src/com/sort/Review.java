import com.sort.test.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Review {

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode (int val){
            this.val = val;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    /**
     * @func 找到树中两个节点的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果root为空直接返回
        //如果要找的祖先就是p或者q,直接返回
        if(root == null || root == p || root == q){
            return root;
        }

        //递归root放入左子树和右子树
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //如果左子树为空,说明在右子树上
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }

        //如果上述情况都不满足,说明当前root就是最近公共祖先
        return root;
    }

    /**
     * @func 高楼扔鸡蛋(动规)
     * @param K
     * @param N
     * @return
     */
    public int supperEggDrop(int K,int N){
        int[] dp = new  int[K+1];
        int ans = 0;//结果
        while(dp[K] < N){
            for (int i = K; i > 0; i--) {//从后向前找
                dp[i] = dp[i] + dp[i - 1] + 1;
            }
            ans++;
        }
        return ans;
    }

    /**
     * @func 找到无序数组的中位数,数据结构:优先级队列
     * @param nums
     * @return
     */
    public static double median(int[] nums){
        int len = nums.length;
        int heapSize = len / 2 + 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        //将数组的前半部分建堆
        for (int i = 0; i < heapSize; i++) {
            heap.add(nums[i]);
        }

        //将数组的后半部分元素和堆顶比较,如果大于就替换
        for (int i = heapSize; i < len ; i++) {
            if(heap.peek() < nums[i]){
                heap.poll();
                heap.add(nums[i]);
            }
        }

        if(len % 2 != 0){
            return heap.peek();
        }else {
            return (heap.poll() + heap.poll()) / 2.0;
        }
    }

    /**
     * @func 检查一棵树是否是完全二叉树
     * @param root 树根节点
     * @return 是/否
     */
   public static boolean checkComplemention(TreeNode root){
       LinkedList<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       boolean flag = false;//标志当前节点的左邻居是否存在左孩子,或者左孩子为空的情况

       while(!queue.isEmpty()){
           TreeNode tmp = queue.poll();
           TreeNode left = tmp.left;
           TreeNode right = tmp.right;

           //1.如果当前节点的左邻居存在左孩子,且当前节点的左孩子或者有孩子不为空,返回false
           if(flag && (left != null || right != null)){
               return false;
           }

           //2.如果当前节点的左右孩子都存在,就入队
           if(left != null && right != null){
               queue.add(left);
               queue.add(right);
           }else if(left == null && right != null){
               //3.如果当前节点左孩子不存你,右孩子存在,返回false
               return false;
           }else if(left != null && right == null){
               //4.如果当前节点的额左孩子不为空,右孩子为空,则将左孩子入队并标记flag为true
               queue.add(left);
               flag = true;
           }else {
               flag = true;
           }
       }
       return true;
   }

    /**
     * @func 跳跃游戏2
     * @param nums
     * @return
     */
   public static int canJump2(int[] nums){
       int len = nums.length;
       int maxDistance = 0;
       int steps = 0;
       int end = 0;//下次跳跃的边界
       for (int i = 0; i < len - 1 ; i++) {//到达最后一个节点之后不用跳
           maxDistance = Math.max(maxDistance,nums[i]+i);
           //当到达边界时就更新本次遍历所能到达的最远距离
           if(i == end){
               end = maxDistance;
               steps++;
           }

       }
       return steps;
   }

    /**
     * 跳跃游戏1,是否能跳到最后一个节点
     * @param nums
     * @return
     */
   public static boolean canJump(int[] nums){
        int maxDistanceIndex = 0;
        int len = nums.length;
       for (int i = 0; i < len; i++) {
           if(i > maxDistanceIndex){
               return false;
           }else {
               maxDistanceIndex = Math.max(maxDistanceIndex,nums[i] + i);
           }
       }
       return true;
   }

    /**
     * 盛水最多的容器
     * @param height
     * @return
     */
   public static int maxArea(int[] height){
       int currArea = 0;
       int maxArea = 0;
       int len = height.length;
       for (int i = 0; i < len - 1; i++) {
           for (int j = i + 1; j < len; j++) {
                currArea = (j - i) * Math.min(height[i],height[j]);
                maxArea = currArea > maxArea ? currArea : maxArea;
           }
       }
       return maxArea;
   }

    /**
     * 环形链表1:探测链表中是否存在环
     * @param head
     * @return
     */
   public static boolean detectCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(true){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        return  true;
   }

   public  static ListNode detectCycle2(ListNode head){
       if (head == null || head.next == null){
           return null;
       }

       ListNode slow = head;
       ListNode fast = head.next;

       while(slow != fast){
           if(fast == null || fast.next == null){
               return null;
           }

           slow = slow.next;
           fast = fast.next.next;
       }

       fast = head;
       while(fast != slow){
           slow = slow.next;
           fast = fast.next;
       }
       return fast;
   }

    /**
     * 反转字符串中的单词,保证每个翻转之后的单子相对顺序不变
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        String[] snum = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        int j = snum.length - 1;
        while(j >= 0){
            if(!snum[j].equals("")){
                sb.append(snum[j] + " ");
            }
            j--;
        }
        return sb.toString().trim();
    }
    @Test
    public void test(){
        String s = "a good  example";
        System.out.println(reverseWords(s));
    }
    //++++++++++++++++++++++++++大数相加++++++++++++++++++++
    public static String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int i = len1 - 1;
        int j = len2 - 1;
        int barry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            int tmp1 = i >= 0 ? num1.charAt(i) - '0': 0;
            int tmp2 = j >= 0 ? num2.charAt(j) - '0': 0;
            int tmp = tmp1 + tmp2 + barry;
            barry = tmp / 10;
            sb.append(tmp % 10);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
    //+++++++++++++++++++++++++二叉树的直径++++++++++++++++++++++



}



