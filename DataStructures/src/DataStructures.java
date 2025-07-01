import java.util.*;

public class DataStructures {

    public static void main(String[] args){
        int[] numbers = {5,0,1,2,3,4};

        //var ans = BinarySearch.findPivot(numbers);


        var ans = findPivot(numbers);
        System.out.println(ans);
    }

    public static void bubbleSort(int[] numbers){
        for(int i = 0; i < numbers.length; i++){

            for(int j = 0; j < numbers.length - i - 1; j++){

                 if(numbers[j] > numbers[j+1]){
                     int temp = numbers[j];
                     numbers[j] = numbers[j+1];
                     numbers[j+1] = temp;
                 }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    public static void selectionSort(int[] array){
        for(int i = 0; i < array.length ; i++){
            int maxIndex = getMax(array.length - 1 - i,array);

            int temp = array[maxIndex];
            array[maxIndex] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }

        System.out.println(Arrays.toString(array));
    }

    public static int getMax(int stop, int[] array){
        int maxIndex = 0;
        for(int i = 1; i <= stop; i++){
            if(array[i] > array[maxIndex]){
                maxIndex = i;
            }
        }
        return  maxIndex;
    }

    public static void insertionSort(int[] array){
        for(int i = 0 ; i < array.length - 1; i++){
            for(int j =  i + 1 ; j > 0; j--){
                if(array[j] < array[j - 1]){
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int low, int high){
        if(high <= low){

            return;
        }
        int start = low;
        int end = high;
        int mid = (start + end) / 2;
        int pivot = array[mid];

        while (start <= end){
            while (array[start] < pivot) {
                start++;
            }

            while (array[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(array, low, end);
        quickSort(array, start, high);

    }
;
    public static int[] mergeSort(int[] array){
        if(array.length == 1){
            return array;
        }
        int half = array.length / 2;

        int[] leftHalf = mergeSort(Arrays.copyOfRange(array, 0, half));
        int[] rightHalf = mergeSort(Arrays.copyOfRange(array, half, array.length));

        return mergeArrays(leftHalf, rightHalf);
    }

    public static int[] mergeArrays(int[] left, int[] right){
        int[] mergedArray = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                mergedArray[k] = left[i];
                i++;
            }
            else if(right[j] < left[i]){
                mergedArray[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length){
            mergedArray[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length){
            mergedArray[k] = right[j];
            k++;
            j++;
        }
        return mergedArray;
    }

    public static int binarySearch(int[] array, int target){
        int start = 0;
        int end = array.length ;
        while (start < end){
            int mid = (start + end) / 2;
            if(array[mid] == target){
                return mid;
            }
            else if (array[mid] < target){
                start = mid + 1 ;
            }
            else if (array[mid] > target){
                end = mid - 1;
            }
        }
        return 0;
    }

    //how many times the array has been rotated
    public static int findPivot(int[] array){
        int start = 0;
        int end = array.length - 1;
        while (start <= end){
            int mid = (start + end)/2;
            if(array[mid] > array[mid + 1]){
                return  (mid + 1) % (array.length - 1);
            }
            if(array[mid] < array[mid - 1]){
                return  mid % (array.length - 1);
            }
            if(array[start] < array[mid]){
                start = mid;
            }
            else
                //array[start] > array[mid]
                end = mid -1;
        }
        return 0;
    }


}

