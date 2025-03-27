/******************************************************************
 *
 *   Zach Kofira / Section 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE

        //create boolean to track condition
        boolean subset = true;
        //create hashtable
        Hashtable holder = new Hashtable();

        //store array A in hashtable
        for(int i = 0; i < list1.length; i++) {
            holder.put(list1[i], list1[i]);
        }
        //check if each member of array B is in the hashtable, i.  If any fail, stop checking
        int j = 0;
        while (subset && j < list2.length) {
            subset = holder.contains(list2[j]);
            j++;
        }

        //return answer
        return subset;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE

        //create int to store kth value, and int to store iterations needed to find max with a min heap
        int value = 0;
        int iterate = array.length - k + 1;
        //create priority queue to hold array of ints
        PriorityQueue queue = new PriorityQueue(array.length);

        //add entire array to queue
        for(int i = 0; i < array.length; i++) {
            queue.add(array[i]);
        }

        //pull until value is obtained
        for(int i = 0; i < iterate; i++) {
            value = (int) queue.poll();
        }

        //return value
        return value;
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE

        //create priority queue to hold array of ints
        PriorityQueue queue = new PriorityQueue(array1.length + array2.length);
        //create int array that can hold all items of both arrays
        int[] sorted = new int[array1.length + array2.length];

        //add array 1 to priority queue
        for(int i = 0; i < array1.length; i++) {
            queue.add(array1[i]);
        }
        //add array 2 to priority queue
        for(int i = 0; i < array2.length; i++) {
            queue.add(array2[i]);
        }
        //pull values from priority queue and put them into their place in the sorted array
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = (int) queue.poll();
        }

        //return the sorted array
        return sorted;
    }

}