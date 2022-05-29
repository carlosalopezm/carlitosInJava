/*
 * author: Carlos López  
 * date: 05/29/22
 * Description: This class returns the index of a value in a sorted array.
 * If the value is found the index is returned; Else, the ideal index is
 * returned. 
 *
 */

class BinaryInsert{
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int middle = 0;
        while(start <= end){
            middle = start + (end-start)/2;
            if(target < nums[middle]){
                end = middle-1;
            }
            else if(target > nums[middle])
                start = middle +1;  
            else
                if(target == nums[middle])
                    return middle;
        }
        return start;

    } 

    public static void main(String Args[]){
      binaryInsert g =  new binaryInsert();
      int[] example = {1,3, 5, 6};
      int[] example2 = {1,3};
      System.out.println(g.searchInsert(example, 2));
      System.out.println(g.searchInsert(example, 0));
      System.out.println(g.searchInsert(example, 7));
      System.out.println(g.searchInsert(example2, 2));
      System.out.println(g.searchInsert(example2, 3));
      System.out.println(g.searchInsert(example2, 0));




      
    }

}



