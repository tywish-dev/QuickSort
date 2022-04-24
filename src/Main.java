import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int[] intArray = new int[10];

        // Generating random elements between -255 and 255 for array
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(-255,255);
        }

        quickSort(intArray, 0, intArray.length);

        // Printing array
        for (int j : intArray) {
            System.out.println(j);
        }
    }

    public static void quickSort(int[] input, int start, int end) {
        if (end - start < 2){
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    public static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j){

            while (i < j && input[--j] >= pivot);
            if (i < j){
                input[i] = input[j];
            }

            while (i < j && input[++i] <= pivot);
            if (i < j){
                input[j] = input[i];
            }
        }

        input[j] = pivot;
        return j;
    }
}