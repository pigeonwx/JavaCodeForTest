package com.algo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    public static void bucketSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int bucketSize = 5;
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int value : array) {
            int bucketIndex = (value - min) / bucketSize;
            buckets.get(bucketIndex).add(value);
        }

        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            System.out.println(bucket);
        }

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                array[index++] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {29, 25, 3, 49, 9, 37, 21, 43};
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }
}