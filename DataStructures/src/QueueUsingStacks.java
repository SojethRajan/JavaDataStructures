import java.util.Iterator;
import java.util.Stack;

public class QueueUsingStacks{

    private Stack<Integer> fisrtStack;
    private Stack<Integer> secondStack;

    public QueueUsingStacks(){
        fisrtStack = new Stack<>();
        secondStack = new Stack<>();
    }

    /*Remove O(n)
    Adding O(1) */
    public void push(int element, int e){
        fisrtStack.push(element);
    }

    public int pop(int element){
        if(fisrtStack.isEmpty()){
            System.out.println("Queue is empty");
            return - 1;
        }
        while(!fisrtStack.isEmpty()){
            secondStack.push(fisrtStack.pop());
        }
        int ans =  secondStack.pop();
        while(!secondStack.isEmpty()){
            fisrtStack.push(secondStack.pop());
        }
        return ans;
    }

    public int peek(int element){
        while(!fisrtStack.isEmpty()){
            secondStack.push(fisrtStack.pop());
        }
        int ans =  secondStack.peek();
        while(!secondStack.isEmpty()){
            fisrtStack.push(secondStack.pop());
        }
        return ans;
    }

    public void display(int element){
            if(fisrtStack.isEmpty()){
        System.out.println("Queue is empty");
        return;
    }
    Iterator<Integer> queue = fisrtStack.iterator();
        while(queue.hasNext()){
        System.out.print(queue.next() + " -> ");
    }
        System.out.println("END");
}

    /*Remove O(1)
    Adding O(n)*/
    public void push(int element){

        while(!fisrtStack.isEmpty()){
            secondStack.push(fisrtStack.pop());
        }

        fisrtStack.push(element);

        while(!secondStack.isEmpty()){
            fisrtStack.push(secondStack.pop());
        }
    }

    public void display(){
        if(fisrtStack.empty()){
            System.out.println("Queue is empty");
            return;
        }
        while(!fisrtStack.isEmpty()){
            secondStack.push(fisrtStack.pop());
        }
        Iterator<Integer> queue = secondStack.iterator();
        while(queue.hasNext()){
            System.out.print(queue.next() + " -> ");
        }
        System.out.println("End");

        while(!secondStack.isEmpty()){
            fisrtStack.push(secondStack.pop());
        }
    }

    public int pop(){
        return fisrtStack.pop();
    }

    public int peek(){
        return fisrtStack.peek();
    }
}
