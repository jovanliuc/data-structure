package datastructure.sort;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class MergeSort {

    private int[] temp;

    @Test
    void test() {
        int[] nums = {5 ,3, 2, 4, 1, 6};
        mergeSort(nums);
        System.out.println(nums.length);
    }

    private void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        temp = new int[len];
        mergeSort(nums, 0, len - 1);
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            nums[k++] = temp[i++];
        }
        while (j <= high) {
            nums[k++] = temp[j++];
        }
    }
}
