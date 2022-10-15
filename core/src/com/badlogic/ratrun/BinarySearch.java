package com.badlogic.ratrun;

import java.util.*;
public class BinarySearch
{
    private static int arrStatementExecutionCount;
    private static int arrListStatementExecutionCount;

    public static int binarySearch(int[] arr, int left, int right, int key)
    {
        arrStatementExecutionCount++;
        if (right >= left)
        {
            int mid = (left + right) / 2;
            if (arr[mid] == key)
            {
                return mid;
            }
            else if (arr[mid] > key)
            {
                return binarySearch(arr, left, mid - 1, key);
            }
            else
            {
                return binarySearch(arr, mid + 1, right, key);
            }
        }
        return -1;
    }
    public static int binarySearch(ArrayList<Integer> myList, int low, int high, int key)
    {
        try{
            arrListStatementExecutionCount++;
            int mid = (high + low) / 2;
            if (key < myList.get(mid))
            {
                return binarySearch(myList, low, mid - 1, key);
            }
            else if (key > myList.get(mid))
            {
                return binarySearch(myList, mid + 1, high, key);
            }
            else if (myList.get(mid).equals(key))
            {
                return mid;
            }
            return -1;
        }
        catch(Exception e){
            System.out.println("Something went wrong.");
            System.exit(0);
            return -1;
        }
    }
    public static int iterativeBinarySearch(int[] arr, int left, int right, int key)
    {
        for (int i=0; i<arr.length; i++)
        {
            if (right >= left)
            {
                int mid = (left + right) / 2;
                if (arr[mid] == key)
                {
                    return mid;
                }
                else if (arr[mid] > key)
                {
                    right = mid -1;
                }
                else
                {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    public static int getArrSEC() {return arrStatementExecutionCount;}
    public static int getArrListSEC() {return arrListStatementExecutionCount;}
}
