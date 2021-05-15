package sort;

public class SortDemo3 {

    /**
     * 归并排序
     *
     * @param arr
     */
    public void mergeSort(int[] arr) {
        partition(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private void partition(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            partition(arr, left, mid);
            partition(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

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
        //找到残留的
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
        for (int k = 0; k < tmp.length; k++) {
            arr[left + k] = tmp[k];
        }

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

    /**
     * 快速排序
     * <p>
     * 找到每次选中的pivot在剩余数组中的位置
     */

    public void quickSort(int[] arr) {
        _quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    public void _quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = quickPartition(arr, start, end);
            _quickSort(arr, start, middle - 1);
            _quickSort(arr, middle + 1, end);
        }
    }

    public int quickPartition(int[] arr, int start, int end) {
        int middle = start - 1;
        int pivot = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                middle++;
                swap(arr, i, middle);
            }
        }

        swap(arr, middle + 1, end);

        return middle + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public int binarySearch(int[] arr, int target) {
        int position = -1;
        position = _binarySearchRightMost(arr, target, 0, arr.length - 1);
        System.out.println(position);
        return position;
    }


    //找最左边的 1,2,2,2,3,4,5
    public int _binarySearchLeftMost(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] > target) {
                //找左边的
                return _binarySearchLeftMost(arr, target, left, middle - 1);

            } else if (arr[middle] < target) {
                return _binarySearchLeftMost(arr, target, middle + 1, right);
            } else {
                //相等
                if (middle == left) {
                    return middle;
                }
                if (arr[middle - 1] == target) {
                    return _binarySearchLeftMost(arr, target, left, middle - 1);
                }
                return middle;
            }
        }
        return -1;
    }

    //找最右边的 1,2,2,2,3,4,5
    public int _binarySearchRightMost(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] > target) {
                //找左边的
                return _binarySearchRightMost(arr, target, left, middle - 1);

            } else if (arr[middle] < target) {
                return _binarySearchRightMost(arr, target, middle + 1, right);
            } else {
                //相等
                if (middle == right) {
                    return middle;
                }
                if (arr[middle + 1] == target) {
                    return _binarySearchRightMost(arr, target, middle+1, right);
                }
                return middle;
            }
        }
        return -1;
    }
}
