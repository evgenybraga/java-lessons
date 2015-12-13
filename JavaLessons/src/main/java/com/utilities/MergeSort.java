package com.utilities;

/**
 * Created by admin on 29.11.2015.
 */

import java.util.Arrays;

public class MergeSort {
    private int[] unsorted;
    private int[] aux;
    private int arraysize;

    public MergeSort(int[] array) {
        arraysize = array.length;
        unsorted = array;
        aux = new int[arraysize];
    }

    public void sort(boolean invertDirection) {
        sortMerge(0, arraysize - 1, invertDirection);
    }

    private void sortMerge(int low, int high, boolean invertDirection) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            sortMerge(low, middle, invertDirection);
            sortMerge(middle + 1, high, invertDirection);
            merge(low, middle, high, invertDirection);
        }
    }

    private void merge(int low, int middle, int high, boolean invertDirection) {
        System.arraycopy(unsorted, low, aux, low, high - low + 1);
        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if ((invertDirection && aux[i] >= aux[j]) || (!invertDirection && aux[i] <= aux[j])) {
                unsorted[k] = aux[i];
                i++;
            } else {
                unsorted[k] = aux[j];
                j++;
            }
            k++;
        }
        System.arraycopy(aux, i, unsorted, k, middle - i + 1);
        Arrays.fill(aux, (char) 0);
    }
}
