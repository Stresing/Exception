public class work1 {

    public static void main(String[] args) {

        // Задание №1.
        // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

        // System.out.println(arithmeticException(10, 0));

        // int[] arr = { 1 };
        // System.out.println(indexOutOfBoundsException(arr, 9));
    
        // System.out.println(NegativeArraySizeException(1));
    }

    public static int arithmeticException(int numOne, int numTwo) {
        return numOne / numTwo;
    }

    public static int indexOutOfBoundsException(int[] array, int numberElement) {
        return array[numberElement];
    }

    public static int NegativeArraySizeException (int a){
        int[] array = new int[-5];
        return a;
    }
}