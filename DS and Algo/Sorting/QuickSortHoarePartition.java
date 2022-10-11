import java.util.Arrays;

public class QuickSortHoarePartition{
    public static int hoarePartition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i=low;
        int j = high;
        while(true){
            while(arr[i]<pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            if(i>=j)
                return j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void qSort(int[] arr, int low, int high){
        if(low<high){
            int pivot = hoarePartition(arr, low, high);
            qSort(arr, low, pivot);
            qSort(arr, pivot+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,8,3,7,1,10,3,2,1,4,2};
        qSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}