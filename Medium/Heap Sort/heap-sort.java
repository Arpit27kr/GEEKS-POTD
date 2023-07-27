//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends


// Java program for implementation of Heap Sort
class Solution
{
    // Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // Start from the last non-leaf node and heapify all nodes in reverse order
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            heapify(arr, n, i);
        }
    }
 
    // Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as the root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child
 
        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
        {
            largest = left;
        }
 
        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
        {
            largest = right;
        }
 
        // If largest is not the root
        if (largest != i)
        {
            // Swap the largest element with the root
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
 
            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }
    
    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        // Build the max heap
        buildHeap(arr, n);
 
        // One by one extract elements from the heap
        for (int i = n - 1; i > 0; i--)
        {
            // Move the current root to the end (the sorted part of the array)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // Call heapify on the reduced heap (the unsorted part)
            heapify(arr, i, 0);
        }
    }
}

 
 
