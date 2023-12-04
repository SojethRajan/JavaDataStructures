import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CustomStack{

    private int index = 0;
    private int defaultSize = 1;
    private int[] stackArray;

    CustomStack(){
        stackArray = new int[defaultSize];
    }

    public void push(int element){
        if(index >= defaultSize){
            defaultSize = defaultSize * ((3/2) + 1);
            int[] array = new int[defaultSize];

            for(int i = 0; i < stackArray.length; i++){
                array[i] = stackArray[i];
            }
            stackArray = array;
        }
        stackArray[index] = element;
        index++;
    }

    public int pop(){
        if(index < 0){
            throw new StackOverflowError("stack is empty");
        }
        index--;
        return stackArray[index];
    }

    public int peek(){
        if(index < 0){
            throw new StackOverflowError("stack is empty");
        }
        return stackArray[index - 1];
    }

    public void display(){
        System.out.print("[");
        for(int i = 0; i < index; i++){
            if(i == index - 1){
                System.out.print(stackArray[i]);
                break;
            }
            System.out.print(stackArray[i] + ", ");
        }
        System.out.println("]");
    }

    public int gameOfTwoStacks(int[] s1, int[] s2, int maxSum){
        return helper(maxSum,s1,s2,0,0) - 1;
    }
    private int helper(int maxSum, int[] a, int[] b, int sum, int count){
        if(sum > maxSum){
            return count;
        }
        if(a.length == 0 || b.length == 0){
            return count;
        }
        int ans1 = helper(maxSum, Arrays.copyOfRange(a,1,a.length),b,sum + a[0],count + 1);
        int ans2 = helper(maxSum, a,Arrays.copyOfRange(b,1,b.length),sum + b[0],count + 1);

        return Math.max(ans1,ans2);
    }

    public int histogramMaxArea(int[] array){
        int area = 0;
        for(int i = 0; i < array.length; i++){
            int leftCount = 0;
            int rightCount = 0;
            int j = i + 1;
            while(j < array.length && array[i] <= array[j]){
                j++;
                rightCount++;
            }
            j = i - 1;
            while(j > -1 && array[j] >= array[i]){
                j--;
                leftCount++;
            }
            int ans = (leftCount + rightCount + 1) * array[i];
            area = Math.max(ans,area);
        }
        return area;
    }

    public boolean validParenthesis(String word){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < word.length(); i++){
            if(!stack.isEmpty()){
                if(parenthesisChecker(stack.peek(),word.charAt(i))){
                    stack.pop();
                    continue;
                }
            }
            stack.push(word.charAt(i));
        }
        return stack.isEmpty();
    }
    private boolean parenthesisChecker(char parenthesisFromStack,char newParenthesis){
        if(parenthesisFromStack == '(' && newParenthesis == ')'){
            return true;
        }
        else if(parenthesisFromStack == '[' && newParenthesis == ']'){
            return true;
        }
        else if(parenthesisFromStack == '{' && newParenthesis == '}'){
            return true;
        }
        return false;
        //return (parenthesisFromStack == '(' && newParenthesis == ')');
    }
    public int minAddToMakeValid(String word){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < word.length(); i++){
            if(!stack.isEmpty()){
                if(parenthesisChecker(stack.peek(),word.charAt(i))){
                    stack.pop();
                    continue;
                }
            }
            stack.push(word.charAt(i));
        }
        return stack.size();
    }


}
