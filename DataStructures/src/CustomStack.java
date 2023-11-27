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
}
