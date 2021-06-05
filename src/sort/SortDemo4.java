package sort;

public class SortDemo4 {

    public void quickSort(int[] arr) {
        _quickSort(arr, 0, arr.length - 1);
        Utils.printArr(arr);
    }

    private void _quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = partition(arr, start, end);
            _quickSort(arr, start, middle - 1);
            _quickSort(arr, middle + 1, end);
        }

    }

    private int partition(int[] arr, int start, int end) {
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


    //返回最左边的索引
    public int binarySearchLeft(int[] arr, int target) {
        return _binarySearchLeft(arr, 0, arr.length - 1, target);
    }

    //返回最右边的索引
    public int binarySearchRight(int[] arr, int target) {
        return _binarySearchRight(arr, 0, arr.length - 1, target);
    }

    public int _binarySearchRight(int[] arr, int left, int right, int target) {
        if (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] < target) {
                //右边找
                return _binarySearchRight(arr, middle + 1, right, target);
            } else if (arr[middle] > target) {
                //左边找
                return _binarySearchRight(arr, left, middle - 1, target);
            } else {
                if (middle == right || arr[middle + 1] > target) {
                    return middle;
                } else {
                    //继续去左边找
                    return _binarySearchRight(arr, middle+1, right, target);
                }
            }
        }
        return -1;
    }

    public int _binarySearchLeft(int[] arr, int left, int right, int target) {
        if (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] < target) {
                //右边找
                return _binarySearchLeft(arr, middle + 1, right, target);
            } else if (arr[middle] > target) {
                //左边找
                return _binarySearchLeft(arr, left, middle - 1, target);
            } else {
                if (middle == left || arr[middle - 1] < target) {
                    return middle;
                } else {
                    //继续去左边找
                    return _binarySearchLeft(arr, left, middle - 1, target);
                }
            }
        }
        return -1;
    }

}
