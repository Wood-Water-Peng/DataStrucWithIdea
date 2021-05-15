package arr;

public class ArrDemo {

    /**
     * 荷兰国旗问题
     * <p>
     * {1,0,1,2,0,1}   -->{0,0,1,1,2}
     *
     * @param nums 思路一:
     *             单指针实现
     */
    public void sortColors(int[] nums) {
        int pos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                pos++;
                swap(nums, i, pos);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                pos++;
                swap(nums, i, pos);
            }
        }
        printArr(nums);
    }

    //双指针实现
    public void sortColors2(int[] nums) {
        //最左边0的位置
        int pos_0 = 0;
        //最右边2的位置
        int pos_2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            //将最左边的2交换到右侧pos_2的位置
            while (i < pos_2 && nums[i] == 2) {
                swap(nums, i, pos_2);
                pos_2--;
            }
            //将0交换到pos_0位置
            if (nums[i] == 0) {
                swap(nums, i, pos_0);
                pos_0++;
            }
        }

        printArr(nums);

    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
}
