public class BinaryHeap {
    public int[] data = new int[10];
    int size= 0;
    public  void add(int item){
        if(size == data.length){
            grow_array();
        }
        data[size++]= item;
        int current = size -1;
        int parent = (current-1)/2;

        while(data[current]<data[parent]&& current!=0){
            swap(data,current, parent);
            current = parent;
            parent = (parent-1)/2;
        }
    }

    public int remove(){
        swap(data, 0, size-1);
        --size;
        if (size > 0){
            shiftdown(0);
        }
        return data[size];
    }

    public void shiftdown(int pos){
        int parent = pos;
        int left = parent *2+ 1;
        int right = parent *2 +2;
        if(left >= size || right >= size){
            return;
        }
        if(data[left] <data[right] && data[left] < data[pos]){
            swap(data, left, pos);
            shiftdown(left);
        }
        else if(data[right] < data[left] && data[right]< data[pos]){
            swap(data,right,pos);
            shiftdown(right);
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    private void grow_array() {
        int newArr[] = new int[data.length*2];
        for(int i = 0; i < size; i++){
            newArr[i] = data[i];
        }
        data = newArr;
    }
}
