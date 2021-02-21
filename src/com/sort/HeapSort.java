package com.sort;

public class HeapSort {
    /**
     * 堆排序
     * 堆化过程:(假设对索引为i的节点进行堆化)
     * 其左孩子节点在数组中的索引:2*i+1
     * 其右孩子节点在数组中的索引:2*i+2
     * 从这三个节点中选出最大的值的节点放到索引i的位置
     *
     * @param nums
     */
    public static void heapSort(int[] nums,int n){
        buildHeap(nums,n);
        for (int i = n-1; i >= 0 ; i--) {
            //将最后一个节点和根节点交换,起到排序的效果
            swap(nums,i,0);
            //将除了有序序列之外的剩下的所有节点再次堆化
            heapify(nums,i,0);//i=n-1,正好将最后一个节点排除在堆化过程之外
        }
    }

    /**
     *
     * @param tree 节点数组
     * @param n 树中有多少个节点
     * @param i 当前对那个节点做堆化操作
     */
    public static void heapify(int[] tree,int n,int i){
        if(i >= n){
            return;
        }
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex= 2 * i + 2;
        int maxValueIndex = i;

        //两个if语句找到三个节点中值最大的那个索引
        if(leftChildIndex <n && tree[leftChildIndex] > tree[maxValueIndex]){
            maxValueIndex = leftChildIndex;
        }
        if(rightChildIndex < n && tree[rightChildIndex] > tree[maxValueIndex]){
            maxValueIndex = rightChildIndex;
        }

        //交换最大值和当前堆化节点的位置
        if(maxValueIndex != i){
            swap(tree,maxValueIndex,i);
            heapify(tree,n,maxValueIndex);
        }
    }

    public static void buildHeap(int[] tree,int n){
        int lastNode = tree.length-1;
        int lastNodeParent = (lastNode - 1) / 2;
        //从最后一个节点的父节点开始堆化
        for (int i = lastNodeParent; i >=0 ; i--) {
            heapify(tree,n,i);
        }
    }


    /**
     * 交换值的位置
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
