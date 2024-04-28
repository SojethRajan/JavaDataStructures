import java.util.*;
import java.util.List;

public class CodingNinjas{

    public static int countDigits(int n){
        int count = 0;
        while(n != 0){
            n = n / 10;
            count++;
        }
        return count;
    }

    public static int calGCD(int n, int m){
        /*if(a == 0){
            return b;
        }
        return calGCD(b%a,a);*/

        int gcd = 1;
        for(int i = Math.min(n, m); i > 1; i--){
            if(n % i == 0 && m % i == 0){
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    public static int sumOfAllDivisors(int n){
        return helper(5, 0);
    }
    private static int helper(int n, int sum){
        if(n == 0){
            return sum;
        }
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                sum = sum + i;
                if((n / i) != i){
                    sum = sum + (n / i);
                }
            }

        }
        return helper(--n, sum);
    }

    public static int[] printNos(int x){
        int[] numbers = new int[x];
        return helperPrintNos(x, numbers, 0);
    }
    private static int[] helperPrintNos(int x, int[] numbers, int count){
        if(x == count){
            return numbers;
        }
        numbers[count] = ++count;
        return helperPrintNos(x, numbers, count);
    }

    public static List<Long> factorial(long n){
        return helperFactorial(n, new ArrayList<>(), 0);
    }
    private static List<Long> helperFactorial(long x, List lists, long count){
        long fact = factorialNumber(++count);
        if(fact > x){
            return lists;
        }
        lists.add(fact);
        return helperFactorial(x, lists, count);
    }
    private static long factorialNumber(long x){
        if(x == 1){
            return 1;
        }
        return x * factorialNumber(x - 1);
    }

    public static int[] reverseArray(int n, int[] nums){
        if(n == 1){
            return nums;
        }
        return helperReverser(n, nums, 0);
    }
    private static int[] helperReverser(int n, int[] numbers, int count){
        if(count == n / 2){
            return numbers;
        }
        int temp = numbers[count];
        numbers[count] = numbers[n - 1 - count];
        numbers[n - 1 - count] = temp;

        return helperReverser(n, numbers, ++count);
    }

    public static int[] generateFibonacciNumbers(int n){
        int[] series = new int[n];
        return helperToGenerateSeries(n,series,0);
    }
    public static int[] helperToGenerateSeries(int n, int[] series, int count){
        if(count == n){
            return series;
        }
        int result = fib(count);
        series[count] = result;
        return  helperToGenerateSeries(n,series,++count);
    }
    public static int fib(int n){
        if(n < 2){
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int[] getFrequencies(int[] array) {
        TreeMap<Integer, Integer> maps = new TreeMap<>();
        for(int i = 0; i < array.length; i++){
            if(maps.containsKey(array[i])){
                maps.put(array[i],maps.get(array[i]) + 1);
            }
            else {
                maps.put(array[i], 1);
            }
        }
        Integer smallest = maps.ceilingKey(0);
        Integer largest = maps.ceilingKey(0);
        for( Map.Entry entry : maps.entrySet()){
            if((Integer)entry.getValue() < maps.get(smallest)){
                smallest = (Integer) entry.getKey();
            }
            if((Integer)entry.getValue() > maps.get(largest)){
                largest = (Integer) entry.getKey();
            }
        }
        return new int[]{largest, smallest};
    }

    public static int removeDuplicates(ArrayList<Integer> arr,int n) {
        // Write your code here.

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < arr.size(); i++){
            if(map.containsKey(arr.get(i))){
                map.put(arr.get(i), map.get(arr.get(i)) + 1);

            }
            else {
                map.put(arr.get(i), 1);
            }
        }
        return map.size();
    }

    public static int[] rotateArrayRight(int[] arr, int n) {
        // Write your code here.
        int k = 1;
        k = n - 1 - k;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k );
        reverse(arr,k + 1, n - 1);
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static void reverse(int[] array, int start, int stop){
        for(int i = start; i <= stop; i++){
            int temp = array[i];
            array[i] = array[stop];
            array[stop] = temp;

            stop--;
        }
    }

    public static int[] moveZeros( int[] array) {
        int pointerOne = 0;
        int pointerTwo = 0;
        while(pointerOne < array.length && pointerTwo < array.length){
            while(pointerOne < array.length && array[pointerOne] != 0){
                pointerOne++;
                pointerTwo++;
            }
            while(pointerTwo < array.length && array[pointerTwo] == 0){
                pointerTwo++;
            }
            if(pointerTwo < array.length){
                int temp = array[pointerTwo];
                array[pointerTwo] = array[pointerOne];
                array[pointerOne] = temp;
                pointerOne++;
                pointerTwo = pointerOne;
            }
        }
        return array;
    }

    public static List<Integer> sortedUnionArray(int[] a, int[] b) {
        // Write your code here
        //merge sort
        List<Integer> list = new ArrayList();
        int i = 0;
        int j = 0;

        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                if(!list.contains(a[i]))
                    list.add(a[i]);
                i++;
            }
            else {
                if(!list.contains(b[j]))
                    list.add(b[j]);
                j++;
            }
        }
        while(i <  a.length){
            if(!list.contains(a[i]))
                list.add(a[i]);
            i++;
        }

        while(j < b.length){
            if(!list.contains(b[j]))
                list.add(b[j]);
            j++;
        }
        return list;
    }

    public static int longestSubArrayWithSumK(int []a, long k) {
        int i = 0;
        int j = 0;
        int length = 0;
        long sum = 0;
        while(j < a.length){
            sum = sum + a[j];
            while(i <= j && sum > k){
                sum = sum - a[i];
                i++;
            }
            if(sum == k){
                length = Math.max(length, j - i + 1);
            }
            j++;
        }
        System.out.println(length);
        return length;
    }

    public static int longestSubArrayWithKSumPositivesNegativesZeros(int[] a, int k){
        long sum = 0;
        boolean flag = false;
        int maxLength = 0;
        HashMap<Integer, Long> maps = new HashMap<>();
        for(int i = 0; i < a.length; i++){
            sum = sum + a[i];
            if(sum == k){
                flag = true;
                maxLength = Math.max(maxLength, i + 1);
            }
            if(!maps.containsValue(sum)){
                maps.put(i,sum);
            }
            long rem = Math.abs(sum - k);
            for(Map.Entry<Integer,Long> entry : maps.entrySet()){
                if(rem == (Long)entry.getValue()){
                    maxLength = Math.max(maxLength, i - (Integer) entry.getKey());
                    /*length = Math.max(length , (int)entry.getKey() + 1);*/
                    break;
                }
            }
        }
        if(flag){
            return maxLength;
        }
        return 0;
    }

    public static int lowerBound(int []array, int x) {
        // Write your code here
        int start = 0;
        int end = array.length - 1;
        int lowerBound = 0;
        boolean flag = false;
        while(start <= end){
            int middle = (start + end) / 2;
            if(x == array[middle]){
                lowerBound = middle;
                end = middle - 1;
                flag = true;
            }
            else if(x < array[middle]){
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        if(flag){
            return lowerBound;
        }
        return start;
    }

    public static int upperBound(int []array, int target){
        // Write your code here.
        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            int middle = (start + end) / 2;
            if(target == array[middle]){
                start = middle + 1;
            }
            else if(target < array[middle]){
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        return start;
    }

    public static int searchInsert(int [] array, int m){
        int start = 0;
        int end = array.length - 1;
        int desiredIndex = 0;
        while(start <= end){
            int middle = (start + end) / 2;
            if(m == array[middle]){
                return middle;
            }
            else if(m < array[middle]){
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        return start;
    }

    public static int maxDepth(String s) {
        // Write your code here...
        Stack<Character> stack = new Stack<>();
        int size = 0;
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty()){
                if(s.charAt(i) == ')' && stack.peek() == '('){
                    if(stack.size() > size){
                        size = stack.size();
                    }
                    stack.pop();
                    continue;
                }
            }
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
        }
        return size;
    }

    public static void reverseWordsInSentence(String str){
        String word = "";
        String s = str.trim();
        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) != ' '){
                word = word + s.charAt(i);
                i++;
                if(i == s.length()){
                    stack.push(word);
                }
            }
            else{
                stack.push(word);
                word= "";
                while(s.charAt(i) == ' '){
                    i++;
                }
            }
        }
        String result = "";
        while(!stack.isEmpty()){
            result = result + stack.pop() + " ";
        }
        System.out.println(result.trim());
    }

    public static String commonPrefix(String[] array, int n){
        Arrays.sort(array);
        String first = array[0];
        String last = array[n - 1];
        String prefix = "";
        for(int i = 0; i < first.length() && i < last.length(); i++){
            if(first.charAt(i) == last.charAt(i)){
                prefix = prefix + first.charAt(i);
            }
            else {
                break;
            }
        }
        return prefix;
    }

    public static boolean areIsomorphic(String first, String second){
        if(first.length() != second.length()){
            return false;
        }
        int[] map1 = new int[200];
        int[] map2 = new int[200];
        for(int i = 0; i < first.length(); i++){
            if(map1[first.charAt(i)] != map2[second.charAt(i)]){
                return false;
            }
            map1[first.charAt(i)] = i + 1;
            map2[second.charAt(i)] = i + 1;
        }
        return true;
    }

   /*If only Node class is given*/
    public static Node constructLL(int []arr) {
       Node head = new Node(arr[0]);
       Node pointer = head;
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            pointer.next = temp;
            pointer = temp;
        }
        return head;
    }

    public static List<Integer> superiorElements(int[] array) {
        List<Integer> list = new ArrayList<>();
        list.add(array[array.length - 1]);
        int max = array[array.length - 1];
        for(int i = array.length - 2; i >= 0; i--){
            if(array[i] > max){
                max = array[i];
                list.add(array[i]);
            }
        }
        //System.out.println(list);
        return list;
    }
}
