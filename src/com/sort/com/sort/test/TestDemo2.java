package com.sort.test;

import org.junit.Test;

public class TestDemo2 {


    @Test
    public void testInsertSort(){
        int[] nums={10,43,89,45,31,90,54,67,32,1,0,7,3,5,76,81,51,22,60,71,52,36,37,41,10,55,2222,4545,454859};
        insertSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    @Test
    public void testQuickSort(){
        int[] nums={10,43,89,45,31,90,54,67,32,1,0,7,3,5,76,81,51,22,60,71,52,36,37,41,10,55,2222,4545,454859};
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    @Test
    public void testHeapSort(){
        int[] nums={10,43,89,45,31,90,54,67,32,1,0,7,3,5,76,81,51,22,60,71,52,36,37,41,10,55,2222,4545,454859};
        heapSort(nums,nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    @Test
    public void testMergeSort(){
        int[] nums={10,43,89,45,31,90,54,67,32,1,0,7,3,5,76,81,51,22,60,71,52,36,37,41,10,55,2222,4545,454859};
        mergeSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }


    /**
     * 插入排序
     * @param nums
     */
    public static void insertSort(int[] nums){
        int  len = nums.length;
        for (int i = 1; i < len; i++) {
            int currNum = nums[i];//当前要排序的节点
            int j = i - 1;//当前排序节点的前一个节点
            while(j >=0 && nums[j] > currNum){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = currNum;
        }
    }

    /**
     * 快速排序
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int[] nums,int left,int right){
        int i = left;
        int j = right;
        int  tmp;
        if(i<j){
            tmp = nums[i];
            while(i < j){
                //从右向左找到一个元素小于当前元素,放在其左边
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

//+++++++++++++++++++++++++++++堆排序++++++++++++++++++++++++++++++++++

    /**
     * 堆排序
     * step:
     * 1.建堆
     * 2.将根节点和尾结点交换
     * 3.缩小堆大小,重新堆化
     * 4.重复上述步骤
     * @param nums
     * @param n 节点个数
     */
    public static void heapSort(int[] nums,int n){
        buildHeap(nums,n);
        for (int i = n-1; i >=0 ; i--) {
            swap(nums,0,i);
            heapify(nums,i,0);//继续对根节点做堆化
        }
    }

    /**
     * @func 对树中的某个节点进行堆化操作
     * @param tree
     * @param n 树的节点个数
     * @param i 对哪个节点进行堆化操作
     */
    public static void heapify(int[] tree,int n, int i){
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int maxValueIndex = i;

        if(leftChild < n && tree[leftChild] > tree[maxValueIndex]){
            maxValueIndex = leftChild;
        }
        if(rightChild < n && tree[rightChild] > tree[maxValueIndex]){
            maxValueIndex = rightChild;
        }
        if(maxValueIndex != i){//说明发现了值比父节点大的孩子
            swap(tree,i,maxValueIndex);
            heapify(tree,n,maxValueIndex);
        }
    }

    /**
     * @func 从已知数组构建堆,从最后一个节点的父节点开始构建
     * @param tree
     * @param n
     */
    public static void buildHeap(int[] tree,int n){
        int lastNode = n - 1;
        int lastNodeParent = (lastNode - 1) / 2;
        for (int i = lastNodeParent; i >=0 ; i--) {
            heapify(tree,n,i);
        }
    }

    /**
     * @func 交换数组中两个节点的位置
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
//+++++++++++++++++++++++++++++++++++++归并排序++++++++++++++++++++++++++++++++++++
    public static void mergeSort(int[] nums,int L,int R){
        if(L == R) return;
        int mid = (R + L) / 2;
        mergeSort(nums,L,mid);
        mergeSort(nums,mid + 1,R);
        merge(nums,L,mid+1,R);
    }

    /**
     * func 将两个子数组合并起来
     * left[] L M
     * right[] M+1 R
     * @param nums
     * @param L 左子数组左边界
     * @param M 左子数组右边界,右子数组左边界
     * @param R 右子数组右边界
     */
    public static void merge(int[] nums,int L,int M,int R){
        int leftSize = M - L;
        int rightSize = R - M + 1;
        int[] left = new int[leftSize] ;
        int[] right = new int[rightSize];

        //将mid左右的两个部分分别拷贝到两个数组中
        for (int i = L; i < M ; i++) {
            left[i - L] = nums[i];
        }
        for (int i = M; i <=R ; i++) {
            right[i - M] = nums[i];
        }

        int i = 0;
        int j = 0;
        int k = L;
        //按照大小 顺序将数字再填会原来的数组
        while(i < leftSize && j < rightSize){
            if(left[i] < right[j]){
                nums[k] = left[i];
                i++;
                k++;
            }else {
                nums[k] = right[j];
                j++;
                k++;
            }
        }

        //将剩余元素拷贝到原来的数组中
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
