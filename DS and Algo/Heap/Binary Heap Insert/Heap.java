class MinHeap{
    int size, capacity;
    int arr[];
    public MinHeap(int capacity){
        this.capacity = capacity;
        size = 0;
        arr = new int[capacity];
    }

    private int left(int i){return ((2*i)+1);}
    private int right(int i){return ((2*i)+2);}
    private int parent(int i){return (i-1)/2;}

    public void insert(int value){
        if(size==capacity){
            System.out.println("heap is full");
            return;
        }
        size++;
        arr[size-1] = value;
        for(int i=size-1;i!=0 && arr[parent(i)]>arr[i];){
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }
    }

    public void print(){
        for(int i=0;i<size;i++)
            System.out.print(arr[i]+" ");
    }
}


public class Heap{
    public static void main(String[] args) {
        MinHeap h = new MinHeap(5);
        h.insert(50);
        h.insert(40);
        h.insert(30);
        h.insert(20);
        h.insert(10);
        h.insert(5);
        h.print();
    }
}