public class OpenAddressing{
    int[] arr;
    int cap,size;

    public OpenAddressing(int c){
        cap = c;
        size = 0;
        arr = new int[cap];
        for(int i=0;i<cap;i++)
            arr[i] = -1; // - 1 means slot is empty
    }

    int hash(int key){
        return key%cap;
    }

    boolean insert(int key){
        if(size==cap)
            return false;
        int i = hash(key);
        while(arr[i] != -1 && arr[i] != -2 && arr[i] != key)
            i = (i+1)%cap;
        if(arr[i]==key)
            return false;
        else{
            arr[i] = key;
            size++;
            return true;
        }
    }

    boolean search(int key){
        int h = hash(key);
        int i = h;
        while(arr[i] != -1){
            if(arr[i] == key)
                return true;
            i = (i+1)%cap;
            if(i==h)    return false;
        }
        return false;
    }

    boolean erase(int key){
        int h = hash(key);
        int i = h;
        while(arr[i] != -1){
            if(arr[i] == key){
                arr[i] = -2;//-2 means DELETED value
                return true;
            }
            i = (i+1)%cap;
            if(i==h) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        OpenAddressing mh = new OpenAddressing(7);
        mh.insert(49);
        mh.insert(56);
        mh.insert(72);
        System.out.println(mh.search(56));
        mh.erase(56);
        System.out.println(mh.search(56));
    }
}