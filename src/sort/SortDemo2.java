package sort;

/**
 * 排序相关
 * 1.插入排序
 * 2.选择排序
 * 3.冒泡排序
 * 4.归并排序
 * 5.快排
 * <p>
 * 二分选择
 * <p>
 * 对归并排序和快速排序的练习
 */
public class SortDemo2 {


    /**
     * 归并排序   先分再合
     *
     * @param arr
     */
    public void mergeSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        partition(arr, left, right);
        printArr(arr);
    }

    private void partition(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + ((right - left) >> 1);
            partition(arr, left, middle);
            partition(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    //前提条件是[left,middle]和[middle+1,right]之间的序列都是有序的
    private void merge(int[] arr, int left, int middle, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int index = 0;
        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {
                tmp[index] = arr[i];
                i++;
            } else {
                tmp[index] = arr[j];
                j++;
            }
            index++;
        }

        //转移剩余的元素
        while (i <= middle) {
            tmp[index] = arr[i];
            i++;
            index++;
        }

        while (j <= right) {
            tmp[index] = arr[j];
            j++;
            index++;
        }

        //将tmp中的元素复制到arr[]
        for (int k = 0; k < tmp.length; k++) {
            arr[left + k] = tmp[k];
        }
    }


    /**
     * 快速排序
     *
     * @param arr
     */
    public void quickSort(int arr[]) {

        _quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private void _quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = partition2(arr, start, end);
            _quickSort(arr, start, mid - 1);
            _quickSort(arr, mid + 1, end);
        }
    }

    /**
     * @param arr
     * @param start
     * @param end
     * @return 锚点所在的索引
     */
    public int partition2(int[] arr, int start, int end) {
        int middle = start - 1;
        int pivot = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                middle++;
                swap(arr, middle, i);
            }
        }
        swap(arr, middle + 1, end);

        return middle + 1;

    }


    /**
     * @param arr    有序数组-非递减
     * @param target
     * @return target在arr中的索引，如果不存在则返回-1
     */
    public int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int index = _rightMost(arr, start, end, target);
        printArr(arr);
        System.out.println("binarySearch target->" + index);
        return index;
    }

    public int _leftMost(int[] arr, int start, int end, int target) {
        if (start <= end) {
            int mid = start + ((end - start) >> 1);
            if ((mid == 0 || arr[mid - 1] < target) && arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return _leftMost(arr, mid + 1, end, target);
            } else {
                return _leftMost(arr, start, mid - 1, target);
            }
        }
        return -1;
    }

    public int _rightMost(int[] arr, int start, int end, int target) {
        if (start <= end) {
            int mid = start + ((end - start) >> 1);
            if ((mid == end || arr[mid + 1] > target) && arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return _rightMost(arr, start, mid - 1, target);
            } else {
                return _rightMost(arr, mid + 1, end, target);
            }
        }
        return -1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void printArr(int[] arr) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            builder.append(",");
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}
