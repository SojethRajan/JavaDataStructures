public class CircularQueue{

    private int size = 0;
    private int start = 0;
    private int end = 0;
    private static int defaultSize = 5;
    private int[] array;

    public CircularQueue(){
        this(defaultSize);
    }
    public CircularQueue(int size){
        defaultSize = size;
        this.array = new int[defaultSize];
    }

    public void push(int element){
        if(size == defaultSize){
            throw new ArrayIndexOutOfBoundsException("queue is full");
        }
        array[end] = element;
        end++;
        end = end % defaultSize;
        size++;
    }

    public int pop(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int ans = array[start];
        start++;
        start = start % defaultSize;
        size--;

        return ans;
    }

    public void display(){
        int i = start;
        while(true){
            System.out.print(array[i] + " -> ");
            i++;
            i = i % defaultSize;
            if(i == end){
                System.out.println("end");
                break;
            }
        }
    }

    public int front(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[start];
    }
}
