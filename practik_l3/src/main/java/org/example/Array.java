package org.example;
import lombok.Data;

@Data
public class Array implements IMath, ISort {
    private int[] array;

    public Array(int[] array) {
        this.array = array;
    }

    @Override
    public int max() {
        int m = array[0];
        for (int item : array) {
            if (item > m) { m = item; }
        }
        return m;
    }

    @Override
    public int min() {
        int m = array[0];
        for (int item : array) {
            if (item < m) { m = item; }
        }
        return m;
    }

    @Override
    public int avg() {
        int a = 0;
        for (int item : array) {
            a += item;
        }
        return a / array.length;
    }

    @Override
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

    @Override
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
}
