public class BinarySearch{

    public static int binarySearch(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            int middle = (start + end) / 2;

            if(target == array[middle]){
                return middle;
            }
            else if(array[middle] < target){
                start = middle + 1;
            }
            else{
                end = middle - 1;
            }
            
        }
        return -1;
    }
}
