class CeilingOfANumber {

  public static int searchCeilingOfANumber(int[] arr, int key) {
     if (key > arr[arr.length - 1]) // if the 'key' is bigger than the biggest element
      return -1;
    int mid = -1;
    int left = 0, right = arr.length-1;
    while(left <= right){
      mid = (left+right)/2;
      if(arr[mid] == key){
        return mid;
      }
      else if(arr[mid] > key){
        right = mid-1;
      }
      else{
        left = mid+1;
      }
    }
    return mid;
  }

  public static void main(String[] args) {
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
    System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
  }
}
