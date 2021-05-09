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
 */
public class SortDemo {

    /**
     * 插入排序   --将无序的一边插入有序的一边
     *
     * @param arr
     */
    public void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
                j--;
            }
        }
        printArr(arr);
    }

    /**
     * 上升序列
     * 选择排序  --左边有序，右边无序   从无序的列表中选择一张最小的，放入左边有序的
     *
     * @param arr
     */
    public void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int start = 0;
        while (start < arr.length) {
            int min = arr[start];
            int minPosition = start;
            for (int i = start; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    minPosition = i;
                }
            }
            swap(arr, start, minPosition);
            start++;
        }
        printArr(arr);
    }

    /**
     * 冒泡排序 --从[0..n-1]将大的元素冒泡到最右边的位置
     * [5,8,4,2,3]
     * [5,8,4,2,3]
     * [5,4,8,2,3]
     * [5,4,2,8,3]
     * [5,4,2,3,8]
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        //n表示需要冒泡的次数  如果是两个元素，那么冒泡一次就可以
        int n = arr.length - 1;
        while (n > 0) {
            for (int i = 0; i < n; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            n--;
        }
        printArr(arr);
    }

    /**
     * 归并排序
     * [5,4,2,3,8]
     * 1.不使用额外的空间，先分再和
     *
     * @param arr
     */
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int start = 0;
        int end = arr.length - 1;
        _mergeSort(arr, start, end);
        printArr(arr);
    }

    private void _merge(int[] arr, int start, int middle, int end) {
        int[] tmp = new int[end - start + 1];
        //
        int i = start;
        int j = middle + 1;
        int n = 0;
        //左右两个数组中可能有部分元素还在
        while (i <= middle && j <= end) {
            if (arr[i] < arr[j]) {
                tmp[n] = arr[i];
                i++;
            } else {
                tmp[n] = arr[j];
                j++;
            }
            n++;
        }

        //移动残留元素
        while (i <= middle) {
            tmp[n] = arr[i];
            i++;
            n++;
        }

        while (j <= end) {
            tmp[n] = arr[j];
            j++;
            n++;
        }

        //将临时数组的元素迁移到原数组
        for (int k = 0; k < tmp.length; k++) {
            arr[k + start] = tmp[k];
        }
    }

    private void _mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = start + ((end - start) >> 1);

            _mergeSort(arr, start, middle);
            _mergeSort(arr, middle + 1, end);

            _merge(arr, start, middle, end);
        }
    }


    /**
     * 快速排序
     *
     * @param arr
     */
    public void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        _quickSort(arr, 0, arr.length - 1);
        printArr(arr);
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
        //锚点左边<=锚点
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


    /**
     * 在排序数组中寻找某个元素是否存在
     *
     * @param sortedArr
     * @param target
     * @return 存在-返回target在arr中的位置   不存在-返回-1
     */
    public int binarySearch(int[] sortedArr, int target) {
        int search = _binarySearchFirst(sortedArr, 0, sortedArr.length - 1, target);
        return search;
    }

    public int _binarySearch(int[] sortedArr, int left, int right, int target) {
        int result = -1;
        if (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (sortedArr[middle] == target && target > sortedArr[middle - 1]) {
                //继续向左寻找
                result = middle;
            } else if (sortedArr[middle] < target) {
                result = _binarySearch(sortedArr, middle + 1, right, target);
            } else {
                result = _binarySearch(sortedArr, left, middle - 1, target);
            }
        }
        return result;
    }

    public int _binarySearchFirst(int[] sortedArr, int left, int right, int target) {
        int result = -1;
        if (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (sortedArr[middle] == target && (middle == 0 || target > sortedArr[middle - 1])) {
                //继续向左寻找
                result = middle;
            } else if (sortedArr[middle] < target) {
                result = _binarySearch(sortedArr, middle + 1, right, target);
            } else {
                result = _binarySearch(sortedArr, left, middle - 1, target);
            }
        }
        return result;
    }

    public int _binarySearchLast(int[] sortedArr, int left, int right, int target) {
        int result = -1;
        if (left <= right) {
            int middle = left + ((right - left) >> 1);
            if ((middle == right || target > sortedArr[middle + 1]) && sortedArr[middle] == target) {
                //继续向由寻找
                result = middle;
            } else if (sortedArr[middle] > target) {
                result = _binarySearch(sortedArr, left, middle - 1, target);
            } else {
                result = _binarySearch(sortedArr, middle + 1, right, target);
            }
        }
        return result;
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
