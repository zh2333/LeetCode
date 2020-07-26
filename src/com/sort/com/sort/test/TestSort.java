package com.sort.test;
import org.junit.Test;

public class TestSort {
    @Test
    public void testInsertSort(){
        int[] nums = {50,30,40,20,45,36,10,6,37,1,39,32,4,46,49,41,7,25,3,26,9,22,5,21,2,19};
        insertSort(nums);
        for (int i = 0; i < nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    @Test
    public void testQuickSort(){
        int[] nums = {50,30,40,20,45,36,10,6,37,1,39,32,4,46,49,41,7,25,3,26,9,22,5,21,2,19};
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    @Test
    public void testHeapSort(){
        int[] nums = {1,2,3,4,5};
        System.out.println(heapSort(nums,nums.length,2));
        for (int i = 0; i < nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    @Test
    public void testMergeSort(){
        int[] nums = {50,30,40,20,45,36,10,6,37,1,39,32,4,46,49,41,7,25,3,26,9,22,5,21,2,19};
        mergeSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }
    }


//+++++++++++++++++++++++++++++++++++插入排序++++++++++++++++++++++++++++++++++++++
    /**
     * 插入排序
     * @param nums
     */
    public static void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int currNum = nums[i];//当前待排元素
            int j = i - 1;
            while(j >= 0 && nums[j] >= currNum){
                nums[j+1] = nums[j];//将元素向后移动
                j--;//从当前位置向前搜索
            }
            nums[j+1] = currNum;//把空出来的位置填上待排元素
        }
    }


//+++++++++++++++++++++++++++++++++++快速排序+++++++++++++++++++++++++++++++++++++
    /**
     * 快速排序
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int[] nums,int left,int right){
      int i = left;
      int j = right;
      int tmp;
      if(i < j){
          tmp = nums[i];
          while(i < j){
              //从右向左找
              while(i < j && nums[j] > tmp) --j;
              if(i < j){
                  nums[i] = nums[j];
                  ++i;
              }
              while(i < j && nums[i] < tmp) ++i;
              if(i < j){
                  nums[j] = nums[i];
                  --j;
              }
          }
          nums[i] = tmp;
          quickSort(nums,left,i-1);
          quickSort(nums,i+1,right);
      }

    }


//+++++++++++++++++++++++++++++++++++堆排序++++++++++++++++++++++++++++++++++++++
    /**
     * 堆排序
     * @param tree
     * @param n
     */
    public static int  heapSort(int[] tree,int n,int k){
        buildHeap(tree,n);
        for (int i = n - 1; i >= n - k ; i--) {
            //1.将根节点交换到最后一个位置
            swap(tree,0,i);
            //2.将除了最后一个节点之外的所有节点重新堆化
            heapify(tree,i,0);
        }
        return tree[0];
    }

    /**
     * function 从最后一个节点的父节点开始构建一个堆
     * @param tree
     * @param n
     */
    public static void buildHeap(int[] tree, int n){
        int lastNode = n - 1;
        int lastNodeParent =  (lastNode - 1) / 2;
        for (int i = lastNodeParent; i >= 0 ; i--) {
            heapify(tree,n,i);
        }
    }


    /**
     * function 将树中的某个节点堆化(将其与左右孩子进行比较,选出较大的值放在这个位置)
     * @param tree
     * @param n
     * @param i 当前要堆化的节点
     */
    public static void heapify(int[] tree,int n,int i){
        //1.根据需要堆化的节点找到左右孩子
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;
        int maxValueIndex = i;

        if(leftChildIndex < n && tree[leftChildIndex] > tree[maxValueIndex]){
            maxValueIndex = leftChildIndex;
        }

        if(rightChildIndex < n && tree[rightChildIndex] > tree[maxValueIndex]){
            maxValueIndex = rightChildIndex;
        }

        if(maxValueIndex != i){
            swap(tree,maxValueIndex,i);
            heapify(tree,n,maxValueIndex);
        }


    }

    /**
     * function 将数组中两个元素交换位置
     * @param nums
     * @param i
     * @param j
     */
    public  static void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


//+++++++++++++++++++++++++++++++++++归并排序++++++++++++++++++++++++++++++++++

    /**
     * 分治
     * @param nums
     * @param L
     * @param R
     */
    public static void mergeSort(int[] nums,int L,int R){
        //分治终止条件--当前数组中只有一个元素
        if(L == R) return;
        int M = (L + R) / 2;
        mergeSort(nums,L,M);
        mergeSort(nums,M+1,R);
        merge(nums,L,M+1,R);
    }

    public static void merge(int[] nums,int L, int M, int R){
        //1.将左右两个子数组分别拷贝
        int leftSize = M - L;
        int rightSize = R - M + 1;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = L; i < M ; i++) {
            left[i-L] = nums[i];
        }
        for (int i = M; i <= R; i++) {
            right[i-M] = nums[i];
        }

        //2.比较,将两个数组中较小的元素拷贝到源数组中的相应位置
        int i = 0;
        int j = 0;
        int k = L;
        while(i < leftSize && j < rightSize){
            if(left[i] < right[j]){
                nums[k] = left[i];
                i++;
                k++;
            }else{
                nums[k] = right[j];
                j++;
                k++;
            }
        }

        //3.拷贝剩余元素
        while(i < leftSize){
            nums[k] = left[i];
            i++;
            k++;
        }
        while(j < rightSize){
            nums[k] = right[j];
            j++;
            k++;
        }


    }
}
