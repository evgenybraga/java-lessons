package com.lesson01;

/**
 * Created by admin on 29.11.2015.
 */

import java.util.Arrays;

public class MergeSort2 {

    public static void sort(int[] array, boolean invertDirection) {
        if (invertDirection){
            sortDescending(array);
        }
        else{
            sortAscending(array);
        }
    }

    public static void sortAscending(int[] array) {
        int low = 0;
        int high = array.length - 1;
        sortMergeAscending(array, low, high);
    }

    public static void sortDescending(int[] array) {
        int low = 0;
        int high = array.length - 1;
        sortMergeDescending(array, low, high);
    }

    private static void sortMergeAscending(int[] array, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            sortMergeAscending(array, low, middle);
            sortMergeAscending(array, middle + 1, high);
            mergeAscending(array, low, middle, high);
        }
    }

    private static void sortMergeDescending(int[] array, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            sortMergeDescending(array, low, middle);
            sortMergeDescending(array, middle + 1, high);
            mergeDescending(array, low, middle, high);
        }
    }

    private static void mergeAscending(int[] array, int low, int middle, int high) {
        int[] auxiliary = new int[array.length];
        System.arraycopy(array, low, auxiliary, low, high - low + 1);
        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (auxiliary[i] <= auxiliary[j]) {
                array[k] = auxiliary[i];
                i++;
            } else {
                array[k] = auxiliary[j];
                j++;
            }
            k++;
        }
        System.arraycopy(auxiliary, i, array, k, middle - i + 1);
    }

    private static void mergeDescending(int[] array, int low, int middle, int high) {
        int[] auxiliary = new int[array.length];
        System.arraycopy(array, low, auxiliary, low, high - low + 1);
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (auxiliary[i] >= auxiliary[j]) {
                array[k] = auxiliary[i];
                i++;
            } else {
                array[k] = auxiliary[j];
                j++;
            }
            k++;
        }
        System.arraycopy(auxiliary, i, array, k, middle - i + 1);
    }
}
