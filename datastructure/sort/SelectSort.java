package datastructure.sort;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class SelectSort {

    @Test
    void test() {
        int[] nums = {5 ,3, 2, 4, 1, 6};
        selectSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " -> ");
        }
    }

    private void selectSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                nums[i] = nums[i] ^ nums[min];
                nums[min] = nums[i] ^ nums[min];
                nums[i] = nums[i] ^ nums[min];
            }
        }
    }
}
