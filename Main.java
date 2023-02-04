import java.util.*;

// Problem Statement #
// Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
// Example 1:

// Input: [3, 1, 5, 12, 2, 11], K = 3
// Output: [5, 12, 11]

class Main {

  public static List<Integer> findKLargestNumbers(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

    // put first 'k' numbers in min heap
    for (int i = 0; i < k; i++)
      minHeap.add(nums[i]);

    for (int i = k; i < nums.length; i++) {
      if (nums[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(nums[i]);
      }
    }

    return new ArrayList<>(minHeap);

  }

  // Problem Statement #
  // Given an unsorted array of numbers, find Kth smallest number in it.
  // Example 1:
  // Input: [1, 5, 12, 2, 11, 5], K = 3
  // Output: 5
  // Explanation: The 3rd smallest number is '5', as the first two smaller numbers
  // are [1, 2].

  public static int findKSmallestNumber(int[] nums, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

    // put first 'k' numbers in min heap
    for (int i = 0; i < k; i++)
      maxHeap.add(nums[i]);

    for (int i = k; i < nums.length; i++) {
      if (nums[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.add(nums[i]);
      }
    }

    return maxHeap.peek();

  }

  public static void main(String[] args) {

    List<Integer> result = Main.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
    System.out.println("K largest numbers" + result);

    int result1 = Main.findKSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
    System.out.println("Kth smallest numbers ------" + result1);

  }
}