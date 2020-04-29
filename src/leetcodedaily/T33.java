package leetcodedaily;

public class T33 {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > nums[left]) {
                if(target > nums[mid]) {
                    left = mid+1;
                } else {
                    if(target>=nums[left]) {
                        right = mid-1;
                    } else {
                        left = mid+1;
                    }
                }
            } else {
                if(target > nums[mid]) {
                    if(target <= nums[right]) {
                        left = mid+1;
                    } else {
                        right = mid-1;
                    }
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int search = new T33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(search);
    }
}
