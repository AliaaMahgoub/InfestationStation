package com.badlogic.ratrun;

import java.util.*;
// Write methods that traverse each of the following:
// String
// Array
// ArrayList
public class Requirements
{
    public static void printRequirements()
    {
        // iterative approach
        for (int i = 4; i>=0; i--)
            System.out.print(i + " ");

        System.out.println();
        countDown(4);
        countDown(-2);

        printString("cat");
        int[] arr = {1,2,3};
        print(arr);
        ArrayList<Object> arrList = new ArrayList<Object>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        printArrList(arrList);

        System.out.println("linear search is more efficient if the key is before index 3. Also, it s helpful when the array is not sorted.");
        int key = (int)(Math.random()*10);
        System.out.println("Searching for " + key  + "\n");

        int[] arr2 = randomArr(); //generate random array
        ArrayList<Integer> a = new ArrayList<Integer>();
        a = randomArrayList(); // generate random ArrayList. I won't use this because I want to be able to compare the methods
        for (int i=0; i<10; i++)
        {
            a.set(i, arr2[i]);
        }

        System.out.print("Random array: ");
        print(arr2);
        System.out.println("\nLinear search:");
        System.out.println(linearSearch(arr2, key));
        System.out.println("\nSelection sort:");
        selectionSort(arr2);
        System.out.println("\nBinary search:");
        System.out.println(BinarySearch.binarySearch(arr2, 0, arr.length, key));
        System.out.println("Statement execution count: " + BinarySearch.getArrSEC());
        System.out.println("\nIterative Binary search:");
        System.out.println(BinarySearch.iterativeBinarySearch(arr2, 0, arr.length, key));

        System.out.print("\nRandom ArrayList: ");
        print(a);
        System.out.println("\nLinear search:");
        System.out.println(linearSearch(a, key));
        System.out.println("\nSelection sort:");
        selectionSort(a);
        System.out.println("\nBinary search:");
        System.out.println(BinarySearch.binarySearch(a, 0, a.size(), key));
        System.out.println("Statement execution count: " + BinarySearch.getArrListSEC());

        int[] test = randomArr();
        System.out.println("Starting array:");
        System.out.println(Arrays.toString(test));
        int random = (int)(Math.random()*1000);
        MergeSort.sort(test, 0, test.length-1);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(test));
        System.out.println("Searching for " + random + ", found at index " + BinarySearch.binarySearch(test, 0, test.length, random));
    }
    //counts down to zero if number is greater than or equal to 0
    public static void countDown(int n)
    {
        if (n>=0)
        {
            System.out.print(n + " ");
            countDown(n-1);
        }
    }
    public static void printString(String str)
    {
        System.out.println();
        for (int i=0; i<str.length(); i++)
            System.out.print(str.substring(i,i+1) + " ");
    }

    public static void printArrList(ArrayList<Object> arr)
    {
        System.out.println();
        for (int i=0; i<arr.size(); i++)
            System.out.print(arr.get(i) + " ");
    }

    public static int[] randomArr()
    {
        int[] arr = new int[10];
        for (int i=0; i<arr.length; i++)
        {
            arr[i] = (int)(Math.random()*10);
        }
        return arr;
    }
    public static ArrayList<Integer> randomArrayList()
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i=0; i<10; i++)
        {
            arr.add((int)(Math.random()*10));
        }
        return arr;
    }

    public static int linearSearch(int[] arr, int key)
    {
        int count = 0;
        for (int i=0; i<arr.length; i++)
        {
            count++;
            if (arr[i]==key)
            {
                System.out.println("Statement execution count: " + count);
                return i;
            }
        }
        System.out.println("Statement execution count: "  + count);
        return -1;
    }
    public static int linearSearch(ArrayList<Integer> arr, int key)
    {
        int count = 0;
        for (int i=0; i<arr.size(); i++)
        {
            count++;
            if (arr.get(i)==key)
            {
                System.out.println("Execution count: " + count);
                return i;
            }
        }
        System.out.println("Execution count: " + count);
        return -1;
    }

    public static void selectionSort(int[] arr)
    {
        int count = 0; //total swaps
        for(int i = 0; i < arr.length - 1; i++)
        {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }
            if(i != minIndex)
            {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                count++;
            }
        }
        System.out.println("Swaps: " + count);
        print(arr);
    }
    public static void selectionSort(ArrayList<Integer> arr)
    {
        try{
            int count = 0; //total swaps
            for(int i = 0; i < arr.size() - 1; i++)
            {
                int minIndex = i;
                for(int j = i + 1; j < arr.size(); j++)
                {
                    if(arr.get(j) < arr.get(minIndex))
                    {
                        minIndex = j;
                    }
                }
                if(i != minIndex)
                {
                    int temp = arr.get(minIndex);
                    arr.set(minIndex, arr.get(i));
                    arr.set(i, temp);
                    count++;
                }
            }
            System.out.println("Swaps: " + count);
            print(arr);
        }
        catch(Exception e){return;}

    }

    public static void print(int[] arr)
    {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
    public static void print(ArrayList<Integer> arr)
    {
        for(int i=0; i<arr.size(); i++)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }
}
