package org.example;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class Array {
    private int[] array;

    public void add(int item) {
        if (array == null) {
            array = new int[1];
            array[0] = item;
            return;
        }
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = item;
        array = newArray;
    }

    public int max() {
        if (array == null || array.length == 0) return 0;

        int m = array[0];

        for (int item : array) {
            if (item > m) {
                m = item;
            }
        }
        return m;
    }

    public int min() {
        if (array == null || array.length == 0) return 0;

        int m = array[0];

        for (int item : array) {
            if (item < m) {
                m = item;
            }
        }
        return m;
    }

    public int avg() {
        if (array == null || array.length == 0) return 0;

        int a = 0;

        for (int item : array) {
            a += item;
        }
        return a;
    }

    public void sortAsc() {
        for (short i = 0; i < array.length - 1; i++)
        {
            for (short j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void sortDesc() {
        for (short i = 0; i < array.length - 1; i++)
        {
            for (short j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] < array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public int find(int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public int change(int index, int newValue) {
        if (array == null || array.length == 0) {
            return -1;
        }

        if (index >= 0 && index < array.length - 1) {
            array[index] = newValue;
            return 0;
        }
        return -1;
    }
}