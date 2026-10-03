import java.util.Arrays;

public class solution75 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 0, 0, 2, 1};
        solution75 sol = new solution75();
        sol.sortClass(nums);
        
        System.out.println(Arrays.toString(nums));
    }

    public void sortClass(int[] nums){
        if(nums.length <= 1){
            return;
        }

        for(int i = 1; i < nums.length; i++){
            int key = nums[i];
            int j = i - 1;

            while(j >= 0 && nums[j] > key){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }
}