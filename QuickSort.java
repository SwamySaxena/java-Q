// Importing required functions
import java.util.*;

// Importing required functions
import java.util.*;

class QuickSort {
	public static void qs(int[] nums, int l, int r){
		if(l<r){
			int q = partition(nums,l,r);
			qs(nums,l,q-1);
			qs(nums,q+1,r);
		}
	}

	public static int partition(int[] nums, int l, int r){
		int q = nums[r];
		int j = l-1;
		for(int i = l; i<=r-1; i++){
			if(q >= nums[i]){
				j++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		int temp = nums[++j];
		nums[j] = q;
	    nums[r] = temp;
		return j;
	}

	static void quickSort(int[] nums) {
		qs(nums, 0, nums.length-1);
	}



	public static void main(String[] args) {
		int[][] numsList = {{55, 23, 26, 2, 18, 78, 23, 8, 2, 3}, {1}, {9, 8, 7, 2, 3, 1},
				{10, 20, 30, -1, -2}};

		for (int i = 0; i < numsList.length; i++) {
			System.out.println((i + 1) + ". Before Sorting");
			System.out.println("   " + Arrays.toString(numsList[i]));

			quickSort(numsList[i]);

			System.out.println("   After Sorting");
			System.out.println("   " + Arrays.toString(numsList[i]));
			System.out.println(
					"-----------------------------------------------------------------------------------------------------\n");
		}

	}
}
