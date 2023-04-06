package ua.ithillel.bigo.sort;

import ua.ithillel.utils.ArrayUtils;
import ua.ithillel.utils.LogUtils;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        LogUtils.log("Bubble sort of array: %s", Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int value = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = value;
                }
            }
        }
    }

    public static void main(String[] args) {
        var array = ArrayUtils.randomArray(100, 8);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
