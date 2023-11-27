public class CustomQueue{

    private int index = 0;
    private int defaultSize = 5;
    private int[] queueArray;

    public CustomQueue(){
        queueArray = new int[defaultSize];
    }

    public void push(int element){
        if(index >= defaultSize){
            defaultSize = defaultSize * (3/2 + 1);
            int[] array = new int[defaultSize];
            for(int i = 0; i < queueArray.length; i++){
                array[i] = queueArray[i];
            }
            queueArray = array;
        }
        queueArray[index] = element;
        index++;
    }

    public void display(){
        System.out.print("[");
        for(int i = 0; i < index; i++){
            if(i == index - 1){
                System.out.print(queueArray[i]);
                break;
            }
            System.out.print(queueArray[i] + ", ");
        }
        System.out.println("]");
    }

    public int pop(){
        if(index == 0){
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        int ans = queueArray[0];
        for(int i = 0; i < queueArray.length - 1; i++){
            queueArray[i] = queueArray[i + 1];
        }
        index--;
        return ans;
    }

    public int peek(){
        if(index == 0){
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        return queueArray[0];
    }
}
