import java.util.*;
import java.util.Map.Entry;

public class StriversQuestion {

    public void secondLargestElement(int[] array){
        int max = array[0];
        int secondMax = Integer.MIN_VALUE;
        for(int i = 1; i < array.length; i++){

            if(array[i] > max){
                secondMax = max;
                max = array[i];
            }

            else if(array[i] > secondMax && array[i] != max){
                secondMax = array[i];
            }

        }
        System.out.println(secondMax);
    }

    public void checkIfSorted(int[] array){
        boolean isSorted  = true;
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i + 1]){
                isSorted = false;
                break;
            }
        }

        System.out.println(isSorted);
    }

    public int removeDuplicates(int[] array){
        int start = 0;
        int end = 1;
        while(end < array.length){
            if(array[start] != array[end]){
                array[start + 1] = array[end];
                start++;
            }
            end++;
        }
        System.out.println(Arrays.toString(array));
        System.out.println(++start);
        return ++start;
    }

    public void leftRotate(int l){
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        int k = l % arr.length;
        rotate(arr,0, n);
        rotate(arr,0, k);
        rotate(arr,k, n);

        System.out.println((Arrays.toString(arr)));
    }

    public void rotate(int[] array, int start, int end){
        int last = end - 1;
        for(int i = start; i < (start + end)/2; i++){
            int temp = array[i];
            array[i] = array[last];
            array[last] = temp;
            last--;
        }
    }

    public void moveZerosToEnd(int[] array){
        int start = 0;
        int end = 0;
        while(end < array.length){
            if(array[end] == 0){
                end++;
                continue;
            }

            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end = start;
        }

        System.out.println(Arrays.toString(array));
    }

    public int search(int[] array, int target){
        int start = 0;
        int end = array.length - 1;

        while (start <= end){

            int mid = (start + end)/2;

            if(array[mid] == target){
                return mid;
            }

            if(target > array[mid]){
                start = mid + 1;
            }
            else if(target < array[mid]){
                end = mid - 1;
            }
        }
        return  -1;

    }

    public void unionTwoUnsortedArray(int[] array1, int[] array2){
        Set<Integer> set = new TreeSet<>();
        Set<Integer> common = new TreeSet<>();

        for (int number : array1){
            set.add(number);
        }

        for(int number : array2){
            if(set.contains(number)){
                common.add(number);
            }
        }

        int[] union = new int[common.size()];
        int i = 0;
        for(int number : common){
            union[i] = number;
            i++;
        }

        System.out.println(Arrays.toString(union));
    }

    public void unionTwoSortedArrays(int[] array1, int[] array2){
        int pointer1 = 0;
        int pointer2 = 0;
        List<Integer> list = new ArrayList<>();

        while(pointer2 < array2.length && pointer1 < array1.length){
            if(array1[pointer1] == array2[pointer2]){
                list.add(array1[pointer1]);
                pointer2++;
                pointer1++;
            }
            else if(array1[pointer1] < array2[pointer2]){
                pointer1++;
            }
            else if(array1[pointer1] > array2[pointer2]){
                pointer2++;
            }
        }

        System.out.println(list);
    }

    public void findMissingNumber(int[] array){
        int sum = 0;
        int n = array.length;
        for(int i = 0; i < n; i++){
            sum = sum + array[i];
        }
        int required = n * (n + 1)/2;
        System.out.println(required - sum);
    }

    public void findMaxConsecutiveOnes(int[] array){
        int maxCount = 0;
        int count = 0;
        int end = 0;
        while(end < array.length){
            if(array[end] != 1){
                count = 0;
                end++;
                continue;
            }
            end++;
            count++;
            maxCount = Math.max(count, maxCount);
        }
        System.out.println(maxCount);
    }

    public void singleNumber(int[] array){
        HashMap<Integer, Integer> maps = new HashMap();

        for(int i = 0; i < array.length; i++){
            if(maps.containsKey(array[i])){
                maps.put(array[i], maps.get(array[i]) + 1);
            }
            else
                maps.put(array[i], 1);
        }

        for(Entry<Integer, Integer> set : maps.entrySet()){
            if(set.getValue() == 1){
                System.out.println(set.getKey());
                break;
            }
        }
    }

    public void longestSubArrayKSum(int[] array, int k){
        int sum = 0;
        int i = 0;
        int j = 0;
        int length = 0;
        while(j < array.length){
            sum = sum + array[j];
            while(sum > k){
                sum = sum - array[i];
                i++;
            }
            if (sum == k){
                length = Math.max(length, j - i + 1);
            }
            j++;
        }

        System.out.println(length);
    }

    public void longestSubArrayKSumPositivesNegatives(int[] array, int k){
        int sum = 0;
        int maxSum = 0;
        int length = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            sum = sum + array[i];
            if(sum == k){
                length = Math.max(length,i + 1);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            int rem = sum - k;

            if (map.containsKey(rem)) {
                length = Math.max(length, i - map.get(rem));
            }
        }

        System.out.println(length);
    }


    public void twoSum(int[] array, int target){
        int[] ans = new int[2];
        HashMap<Integer, Integer> maps = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            int required = target - array[i];
            if(maps.containsKey(required)){
                ans[0] = i;
                ans[1] = maps.get(required);
                break;
            }
            else {
                maps.put(array[i], i);
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}


