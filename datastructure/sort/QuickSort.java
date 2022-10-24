package datastructure.sort;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Random;

public class QuickSort {

    @Test
    void test() {
        int[] nums = {5 ,3, 2, 4, 1, 6};
        quickSort(nums);
    }

    private void quickSort(int[] nums) {
        if (nums == null || nums.length <=1) {
            return;
        }
        // shuffle(nums);
        quickSort(nums, 0, nums.length - 1);
        System.out.println(nums.length);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(nums, low, high);
        quickSort(nums, low, pivot - 1);
        quickSort(nums, pivot + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int pivotVal = nums[low];

        while (low < high && nums[high] >= pivotVal) {
            high--;
        }
        nums[low] = nums[high];

        while (low < high && nums[low] <= pivotVal) {
            low++;
        }
        nums[high] = nums[low];

        nums[low] = pivotVal;
        return low;
    }

    private void shuffle(int[]  nums) {
        int len = nums.length;
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            int j = r.nextInt(len);
            if (i == j){
                continue;
            }
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
