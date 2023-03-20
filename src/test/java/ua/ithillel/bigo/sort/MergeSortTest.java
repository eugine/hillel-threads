package ua.ithillel.bigo.sort;

class MergeSortTest extends SortAlgorithmTest {


    @Override
    public void sort(int[] array) {
        MergeSort.mergeSort(array);
    }

}