public class LomutoPartition{
    int partition(int arr[],int l,int h){
        int pivot = arr[h];
        int i= l-1;
        for(int j=0;j<h;j++){
            if(arr[j]<pivot){
                int temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[++i];
        arr[i] = arr[h];
        arr[h] = temp;
        return i;
    }

    public static void main(String[] args) {
        LomutoPartition lm = new LomutoPartition();
        int[] arr = {10,80,30,90,40,50,70};
        int index = lm.partition(arr, 0, 6);
        for(int val : arr)
            System.out.print(val+" ");
        System.out.print("\n"+index);
    }
}