public class QuickSort{

    public static void quickSort(int[] numbers, int low, int high){
        if(low >= high){
            return;
        }
        int start = low;
        int end = high;
        int middle = (start + end )/2;
        int pivot = numbers[middle];
        while(start <= end){
            while(numbers[start] < pivot){
                start++;
            }
            while(numbers[end] > pivot){
                end--;
            }
            if(start <= end){
                int temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(numbers,low,end);
        quickSort(numbers,start,high);
    }
}
