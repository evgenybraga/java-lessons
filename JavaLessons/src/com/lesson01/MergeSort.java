package com.lesson01;

/**
 * Created by admin on 29.11.2015.
 */
import java.util.Arrays;

public class MergeSort
{
    private int[] unsorted;
    private int[] aux;
    private int arraysize;


    public MergeSort(int[] array)
    {
        arraysize = array.length;
        unsorted = array;
        aux  = new int[arraysize];
    }

    public void sort()
    {
        sortMerge(0, arraysize - 1);
    }

    private void sortMerge(int low, int high)
    {
        if (low < high)
        {
            int middle = low + (high - low) / 2;
            sortMerge(low, middle);
            sortMerge(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high)
    {
        System.arraycopy(unsorted, low, aux, low, high - low + 1);
        //System.out.println("-----------------------------------");
        //System.out.println("aux = " + Arrays.toString(aux));
        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high)
        {
            //System.out.println("Compare " + aux[i] + " and " + aux[j]);

            if (aux[i] <= aux[j])
            {
                unsorted[k] = aux[i];
                i++;
            }
            else
            {
                unsorted[k] = aux[j];
                j++;
            }
            k++;
            //System.out.println("unsorted = " + Arrays.toString(unsorted));
        }
        System.arraycopy(aux, i, unsorted, k, middle - i + 1);
        Arrays.fill(aux, (char)0);
        //System.out.println("Copy rest of aux");
        //System.out.println("unsorted = " + Arrays.toString(unsorted));
    }
}
