package Seminar_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class dz_02 {
    public static void main(String[] args) {
        // Задача на комбинации
        System.out.println(combine(5, 3));

        // Сортировка слиянием
        int[] A = {13, 3, 8, 1, 15, 2, 3, 7, 4};
        System.out.println(Arrays.toString(A));
        System.out.print(Arrays.toString(mergeSort(A)));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> tmp = new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {
        back(n, k, 1);
        return res;
    }

    public static void back(int n, int k, int start) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i <= n - (k - tmp.size()) + 1; i++) {
            tmp.add(i);
            back(n, k, i + 1);
            tmp.removeLast();
        }
    }

    public static int[] mergeSort(int[] array) {
        int size = array.length;
        if (size <= 1) {
            return array;
        }
        int[] leftSide = mergeSort(Arrays.copyOfRange(array, 0, size / 2));
        int[] rightSide = mergeSort(Arrays.copyOfRange(array, size / 2, size));
        int n = 0; int m = 0; int k = 0;
        int[] copyArray = new int[size];
        while (n < leftSide.length && m < rightSide.length) {
            if (leftSide[n] <= rightSide[m]) copyArray[k++] = leftSide[n++];
            else copyArray[k++] = rightSide[m++];
        }
        while (n < leftSide.length) {
            copyArray[k++] = leftSide[n++];
        }
        while (m < rightSide.length) {
            copyArray[k++] = rightSide[m++];
        }
        for (int i = 0; i < size; i++) {
            array[i] = copyArray[i];
        }
        return array;
    }
}
