import java.util.Arrays;

public class CustomArrayList{

    private int _length = 5;
    private int[] array = new int[_length];
    private int _index = 0;

    public int size(){
        return _index;
    }

    public void add(int obj){
        if(_index >= _length){
            _length = _length * (3/2 + 1);
            int[] newArray = new int[_length];
            for(int i = 0; i < _index; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[_index] = obj;
        _index++;
    }

    public void print(){
        System.out.print("[");
        for(int i = 0; i < _index; i++){
            if(i == _index - 1){
                System.out.print(array[i]);
                continue;
            }
            System.out.print(array[i] + ", ");
        }
        System.out.print("]");
        System.out.println();
    }

    public void remove(int index){
        if(index >= _index){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = index; i < _index; i++){
            array[i] = array[i + 1];
        }
        _index--;
    }

    public void removeAll(){
        array = new int[0];
        _index = 0;
    }

    public int get(int index){
        if(index >= _index){
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    public boolean contains(int element){
        for(int i = 0; i < _index; i++){
            if(array[i] == element){
                return true;
            }
        }
        return false;
    }

    public void removeElement(int element){
        for(int i = 0; i < _index; i++){
            if(array[i] == element){
                for(int j = i; j < _index; j++){
                    array[j] = array[j + 1];
                }
                _index--;
                break;
            }
        }
    }
}
