public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        mergeSort(nums,0,3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    /**
     * 分治
     * @param nums
     * @param L
     * @param R
     */
    public static void mergeSort(int[] nums,int L,int R){
        if(L == R) {
            return;//递归终止条件
        }
        int M = (L + R)/2;
        mergeSort(nums,L,M);
        mergeSort(nums,M + 1,R);
        //合并两边已经有序的子数组
        merge(nums,L,M+1,R);

    }

    /**
     * 将两个有序子数组合并
     * @param nums
     * @param L
     * @param M
     * @param R
     */
    public static void merge(int[] nums,int L,int M,int R){
        int leftSize = M - L;
        int rightSize = R - M + 1;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        //将原数组拆成两个部分,装入到两个数组中去
        //1.将左半部分放到left数组中
        for (int i = L; i < M; i++) {
            left[i-L] = nums[i];
        }
        //2.将左半部分放到right数组中
        for (int i = M; i <= R; i++) {
            right[i-M] = nums[i];
        }

        //3.依次比较两个数组中的元素,将较小的那个元素填到数组中去
        int i = 0;
        int j = 0;
        int k = L;
        while(i < leftSize && j < rightSize){
            if(left[i] < right[j]){
                nums[k] = left[i];
                k++;
                i++;
            }else{
                nums[k] = right[j];
                k++;
                j++;
            }
        }
        //4.将剩下的元素填入到数组中去
        while(i < leftSize){
            nums[k] = left[i];
            k++;
            i++;
        }
        while(j < rightSize){
            nums[k] = right[j];
            k++;
            j++;
        }

    }
}
