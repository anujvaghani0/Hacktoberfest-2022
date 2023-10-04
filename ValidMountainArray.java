package Arrays;

public class ValidMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,5,2,1};
        System.out.println(validMountainArray(arr));
    }
    count=0

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] > arr[start + 1]) {
                end--;
            } else if (arr[end - 1] < arr[end]) {
                    Start++;
            } else {
                break;
            }
        }
        return start != 0 && end != arr.length - 1 && start == end;
    }
}
