package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

//Video 1 : https://youtu.be/37E9ckMDdTk?si=XxQ6GUL_Z9auljW7

/*
 * 1. Find Largest Element In Array
 * 2. 
 * 
*/
public class PracticeVideo1 {

    int[] arr = { 2, 1000, 4, 1, 7, 3, 9, 6, 7, 4, 5, 9, 90, 221, 654 };

    int[] sorted_array = { 1, 3, 3, 4, 6, 7, 8, 8, 9, 9, 9, 11, 12, 13, 14, 14, 14 };

    public static void main(String[] args) {
        new PracticeVideo1();
    }

    PracticeVideo1() {
        System.out.println("findLargestElementInArray ==> " + findLargestElementInArray(arr));
        System.out.println("findSecondLargestElementInArray ==> " + findSecondLargestElementInArray(arr));
        System.out.println("isSorted ==> " + isSorted(sorted_array));
        System.out.println("removeDuplicate ==> " + removeDuplicate(sorted_array));
    }

    public int findLargestElementInArray(int arr[]) {
        int result = Integer.MIN_VALUE;
        for (int a : arr)
            if (a > result)
                result = a;
        return result;
    }

    public int findSecondLargestElementInArray(int arr[]) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int a : arr) {
            if (a > first) {
                second = first;
                first = a;
            } else if (a < first && a > second)
                second = a;
        }

        return second;
    }

    public boolean isSorted(int arr[]) {

        int l = arr.length - 1;
        for (int i = 0; i < l; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    public List<Integer> removeDuplicate(int[] arr) {
        int len = arr.length, l = 0, r = 0;
        for (int i = 0; i < len; i++) {
            if (arr[l] == arr[r])
                r++;
            else
                swap(arr, ++l, r++);
        }
        System.out.println("Index " + l);
        return IntStream.of(arr).boxed().toList();
    }

    public void swap(int arr[], int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}