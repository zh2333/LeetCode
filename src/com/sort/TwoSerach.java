import org.junit.Test;

public class TwoSerach {
    @Test
    public void test(){
        int[] nums = {-1,0,2,8,24,54,154};
        System.out.println(binarySearch2(nums,54));
    }
    public static int BinarySearch(int[] nums, int target){
        int len = nums.length;
        if(len == 0) return -1;
        int left = 0;
        int right = len - 1;
        int mid;
        while(left <= right){
            mid = (left + right) >>> 1;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] nums,int target){
        if(nums.length == 0) return -1;
        return helper(nums,0,nums.length - 1, target);
    }
    public static int helper(int[] nums,int left,int right, int target){
       if(left > right){
           return -1;
       }
       int mid = (left + right) >>> 1;
       if(nums[mid] == target){
           return mid;
       }else if(nums[mid] > target) {
           return helper(nums,left,mid - 1,target);
       }else {
           return helper(nums,mid + 1,right,target);
       }

    }
}
