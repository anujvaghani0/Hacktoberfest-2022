import java.util.Arrays;
import java.util.Scanner;
class InsertionRecursivo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] input = sc.nextLine().split(" ");
        int [] v = new int[input.length];
        for (int i = 0; i < input.length; i++){
            v[i] = Integer.parseInt(input[i]);
        }
        sort(v, 0);
        sc.close();
    }
    static void sort(int[] arr, int index){
        int j = index +1;
        if(j != arr.length){
            
            while (j > 0 && arr[j] < arr[j-1]){
                swap(arr,j, j-1);
                j-= 1;
            }
            System.out.println(Arrays.toString(arr));
            sort(arr, index + 1);
        }


    }
    static void swap(int[] arr,int i,int j){
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

}
