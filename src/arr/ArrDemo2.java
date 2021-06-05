package arr;

public class ArrDemo2 {

    /**
     * 荷兰国旗问题
     * <p>
     * {1,0,1,2,0,1}   -->{0,0,1,1,2}
     *
     * @param arr 思路一:
     *            单指针实现
     */

    public void sortColors(int[] arr) {
//1.将0交换到最左边
        int position = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                position++;
                swap(arr, position, i);
            }
        }

        for (int i = position; i < arr.length; i++) {
            if (arr[i] == 1) {
                position++;
                swap(arr, position, i);
            }
        }

        printArr(arr);
    }

    public static void printArr(int[] arr) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            builder.append(',');
        }
        builder.append(']');
        System.out.println(builder.toString());
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
