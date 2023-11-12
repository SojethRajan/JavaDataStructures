import javax.swing.plaf.synth.SynthDesktopIconUI;

public class BinarySearch{

    public static int binarySearch(int[] array, int target){
        int start = 0;
        int end = array.length - 1;

        while(start <= end){
            int middle = (start + end) / 2;
            if(target == array[middle]){
                return middle;
            }
            else if(target < array[middle]){
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static int orderAgnostic(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        boolean isAscending = array[start] < array[end];
        while(start <= end){
            int middle = (start + end)/2;
            if(target == array[middle]){
                return middle;
            }
            if(isAscending){
                if(target > middle){
                    start = middle + 1;
                }
                else {
                    end = middle - 1;
                }
            }
            else {
                if(target > middle){
                    end = middle - 1;
                }
                else {
                    start = middle + 1;
                }
            }
        }
        return  -1;
    }

    public static int ceilingFloor(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            int middle = (start + end)/2;
            if(target == array[middle]){
                return middle;
            }
            else if(target < array[middle]){
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        System.out.println(end + " " + start);
        return start; // for ceiling of the Number
        //return end; // for floor of the Number
    }

    public static int firstLastOccurrence(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        int firstFind = 0;
        while(start <= end){
            int middle = (start + end) / 2;
            if(target == array[middle]){
                firstFind = middle;
                start = middle + 1; // last Occurrence
                // end = middle - 1; // first Occurrence
            } else if(target < array[middle]){
                end = middle - 1;
            } else{
                start = middle + 1;
            }
        }
        return firstFind;
    }

    public static int peakMountainArray(int[] array){
        int start = 0;
        int end = array.length - 1;

        while(start <= end){
            int middle = (start + end) / 2;

            if(start == end){
                return middle;
            }
            if(array[middle] < array[middle + 1]){
                start = middle + 1;
            }
            else {
                end = middle;
            }
        }
        return  -1 ;
    }

    public static int searchRotatedArray(int[] array, int target){
        int pivot = findPivot(array);
        if(target == array[pivot]){
            return pivot;
        }
        int leftHalf = binarySearchOnRotatedArray(array,0,pivot,target);
        if(leftHalf >= 0){
            return leftHalf;
        }
        int rightHalf = binarySearchOnRotatedArray(array,pivot + 1, array.length - 1, target);
        if(rightHalf >= 0){
            return rightHalf;
        }
        return -1;

    }
    private static int findPivot(int[] array){
        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            int middle = (start + end) / 2;
            if(middle < end && array[middle] > array[middle + 1]){
                return middle;
            }
            if(middle > start && array[middle] < array[middle - 1]){
                return  middle - 1;
            }
            if(array[start] >= array[middle]){
                end = middle - 1;
            }
            else{
                start = middle;
            }
        }
        return array.length - 1;
    }
    private static int binarySearchOnRotatedArray(int[] array, int start, int end, int target){
        while(start <= end){
            int middle = (start + end) / 2;
            if(target == array[middle]){
                return middle;
            }
            else if(target < array[middle]){
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static int findMinBinarySearch(int[] array){
        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            int middle = (start + end) / 2;
            if(middle < end && array[middle] > array[middle + 1]){
                return array[middle + 1];
            }
            if(middle > start && array[middle] < array[middle - 1]){
                return  array[middle];
            }
            else if(array[start] >= array[middle]){
                end = middle - 1;
            }
            else {
                start = middle;
            }
        }
        return array[0];
    }

    public static int singleNonDuplicate(int[] array){
        if(array.length == 1){
            return array[0];
        }
        if(array[0] != array[1]){
            return array[0];
        }
        if(array[array.length - 1] != array[array.length - 2]){
            return array[array.length - 1];
        }
        int start = 1;
        int end = array.length - 2;
        while(start <= end){
            int middle = (start + end) / 2;
            if(array[middle] != array[middle + 1] && array[middle] != array[middle - 1]){
                return array[middle];
            }
            if(middle % 2 == 1 && array[middle] == array[middle - 1]
                    || middle % 2 == 0 && array[middle] == array[middle + 1]){
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }
        return  -1;
    }


}
