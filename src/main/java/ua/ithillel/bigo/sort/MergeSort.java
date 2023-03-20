package ua.ithillel.bigo.sort;

import ua.ithillel.utils.ArrayUtils;

import java.util.Arrays;

//https://www.baeldung.com/java-merge-sort

public class MergeSort {

    public static void mergeSort(int[] array) {
        int n = array.length;
        if (n < 2) {
            return;
        }
        var mid = n / 2;
        var left = Arrays.copyOfRange(array, 0, mid);
        var right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0, mainIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                array[mainIndex++] = left[leftIndex++];
            } else {
                array[mainIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            array[mainIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            array[mainIndex++] = right[rightIndex++];
        }
    }

    public static void main(String[] args) {
        var array = ArrayUtils.randomArray(1000, 10);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
