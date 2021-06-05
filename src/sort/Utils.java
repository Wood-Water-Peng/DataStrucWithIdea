package sort;

public class Utils {
    public static void printArr(int[] arr) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            builder.append(',');
        }
        builder.append(']');
        System.out.println("arr->" + builder.toString());
    }
}
