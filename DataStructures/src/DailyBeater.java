public class DailyBeater {

    public void maxSubArrayWithMaxSum(int[] array){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < array.length; i++){
            sum = sum + array[i];

            if(sum > maxSum){
                maxSum = sum;
                end = i;
            }

            if(sum < 0){
                sum = 0;
                start = i + 1;
            }
        }
        System.out.println(start + ","  + end);
    }

    public void maxProductSubArray(int[] array){
        int maxProduct = Integer.MIN_VALUE;;
        int prefix = 1;
        int suffix = 1;

        for(int i = 0; i < array.length; i++){

            if(prefix == 0)
                prefix = 1;

            if (suffix == 0)
                suffix = 1;

            prefix = prefix * array[i];
            suffix = suffix * array[array.length - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        System.out.println(maxProduct);
    }

    public void maxAbsoluteSum(int[] array){
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i < array.length; i++){
            sum1 = sum1 + array[i];
            sum2 = sum2 + array[i];

            if(sum1 > maxSum){
                maxSum = sum1;
            }

            if(sum2 < minSum){
                minSum = sum2;
            }

            if(sum1 < 0){
                sum1 = 0;
            }

            if(sum2 > 0){
                sum2 = 0;
            }
        }
        int ans = Math.max(maxSum, Math.abs(minSum));
        System.out.println(ans);
    }

    public int maxSubarraySumCircular(int[] array){
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int sum1 = 0;
        int sum2 = 0;
        int arraySum = 0;

        for(int i = 0; i < array.length; i++){
            sum1 = sum1 + array[i];
            sum2 = sum2 + array[i];
            arraySum = arraySum + array[i];

            if(sum1 > maxSum)
                maxSum = sum1;

            if(sum2 < minSum){
                minSum = sum2;
            }

            if(sum1 < 0){
                sum1 = 0;
            }

            if(sum2 > 0){
                sum2 = 0;
            }
        }

        if(minSum == arraySum){
            return maxSum;
        }
        else {
            return Math.max(maxSum, (arraySum - minSum));
        }
    }


}
