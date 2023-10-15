import java.util.*;

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

    //[1, 2, 3, 1, 1, 4]
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

}
