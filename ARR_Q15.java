import java.util.*;

class SubarrayProductLessThanK {

  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> subarrays = new ArrayList<>();
    for(int i = 0; i<arr.length; i++){
      int current = 1;
      int j = i;
      while(j < arr.length){
        current*=arr[j];
        if(current < target){
          List<Integer> temp = new ArrayList<>();
          int c = i;
          while(c<=j){
            temp.add(arr[c]);
            c++;
          }
          subarrays.add(temp);
        }
        j++;
      }
    }
    return subarrays;
  }
}

  public static void main(String[] args) {
    System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
    System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
  }
}


/////////////////////////////////////////////////////////////////////// ALTERNATE ///////////////////////////////////////////////////////////////////////////////////////
import java.util.*;

class SubarrayProductLessThanK {

  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();
    double product = 1;
    int left = 0;
    for (int right = 0; right < arr.length; right++) {
      product *= arr[right];
      while (product >= target && left < arr.length)
        product /= arr[left++];
      // since the product of all numbers from left to right is less than the target therefore,
      // all subarrays from left to right will have a product less than the target too; to avoid
      // duplicates, we will start with a subarray containing only arr[right] and then extend it
      List<Integer> tempList = new LinkedList<>();
      for (int i = right; i >= left; i--) {
        tempList.add(0, arr[i]);
        result.add(new ArrayList<>(tempList));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
    System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
  }
}
